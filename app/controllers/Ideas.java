package controllers;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import javax.persistence.Query;

import org.codehaus.jackson.JsonNode;

import java.util.Random;

import com.avaje.ebean.Ebean;

import models.Idea;
import play.Play;
import play.data.Form;
import play.libs.F.Function;
import play.libs.WS;
import play.libs.WS.Response;
import play.libs.WS.WSRequestHolder;
import play.mvc.Controller;
import play.mvc.Result;
import play.api.Configuration;
import play.api.templates.Html;

public class Ideas extends Controller {
	
	static Form<Idea> ideaForm = form(Idea.class);
	static final String API_TOKEN = "5b3326f8-50a5-419d-8f02-eef6a42fd61a";
	static Idea currentIdea = null;
	
	public static boolean existsIdea() {
		if (currentIdea != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static Result index() {
		if (!existsIdea()) {
			currentIdea = getLocalIdea();
		}
		//System.out.print(currentIdea.content.toString());
		return ok(views.html.idea.render(currentIdea.title,currentIdea.content,
				  currentIdea.author,currentIdea.getStringScore()));
	}
	
	/**
	 * Randomly get a new idea from the local database
	 * @return the idea retrieved
	 */
	public static Idea getLocalIdea() {
		if (existsIdea()) {
			return Idea.find.where().ne("id", currentIdea.id).orderBy("RAND()")
									.findList().get(0);
		}
		else {
			Integer numberIdeas = Idea.find.all().size();
			if (numberIdeas == 0) {
				feedIdeas();
			}
			return Idea.find.orderBy("RAND()").findList().get(0);
		}
	}
	
	/**
	 * Get recent ideas from IdeaScale.com
	 * @return request response
	 * @throws TimeoutException
	 */
	public static Response getRecentIdeas() throws TimeoutException {
		WSRequestHolder request = WS.url("http://fiveheads.ideascale.com/a/rest/v1/ideas/recent")
				.setHeader("api_token", API_TOKEN);
		Response response = request.get().get();
		return response;
	}

	/**
	 * Get idea information from IdeaScale.com
	 * @param ideaId ideaScale id 
	 * @return request response
	 * @throws TimeoutException
	 */
	public static Response getIdea(Long ideaId) throws TimeoutException {
		WSRequestHolder request = WS.url("http://fiveheads.ideascale.com/a/rest/v1/ideas/" + ideaId)
				.setHeader("api_token", API_TOKEN);
		Response response = request.get().get();
		return response;
	}
	
	/**
	 * Shows the information of the current idea
	 * @return 
	 */
    public static Result show() {
    	return ok(views.html.idea.render(currentIdea.title,currentIdea.content,
				  currentIdea.author,currentIdea.getStringScore()));
    }
    
    /**
     * Register the positive vote in the local database and also in IdeaScale.com
     * @return request result from the voting register in IdeaScale.com
     */
    public static Result voteUp() {
    	WSRequestHolder request = WS.url("http://fiveheads.ideascale.com/a/rest/v1/ideas/"+ 
    									 currentIdea.idScale +"/vote/up")
				.setHeader("api_token", API_TOKEN);
    	Response response = request.post("{ \"myVote\":1 }").get();
    	if (response.getStatus() == 200) {
    		currentIdea.updateScore(1);
    		return ok("Your vote has been registered");
    	}
    	else {
    		return badRequest("Problem when try to register your vote");
    	}
    }
    
    /**
     * Register the negative vote in the local database and also in IdeaScale.com
     * @return request result from the voting register in IdeaScale.com
     */
    public static Result voteDown() {
    	WSRequestHolder request = WS.url("http://fiveheads.ideascale.com/a/rest/v1/ideas/"+ 
    									  currentIdea.idScale +"/vote/down")
				.setHeader("api_token", API_TOKEN);
    	Response response = request.post("{ \"myVote\":-1 }").get();
    	if (response.getStatus() == 200) {
    		currentIdea.updateScore(-1);
    		return ok("Your vote has been registered");
    	}
    	else {
    		return badRequest("Problem when try to register your vote");
    	}
    }

    /**
     * Get a new idea from the local database
     * @return 
     */
    public static Result change() {
    		currentIdea = getLocalIdea();
        	return ok(views.html.idea.render(currentIdea.title,currentIdea.content,
  				  	currentIdea.author,currentIdea.getStringScore()));
    }
    
    public static Result create() {
    	return TODO;
    }
    
    public static Result feedIdeas() {
    	Response response;
		try {
			response = getRecentIdeas();
			boolean newIdeasCreated = false;
	    	if (response.getStatus() == 200) {
	    		Iterator<JsonNode> newIdeas = response.asJson().getElements(); 
	    		while(newIdeas.hasNext()) {
	    			JsonNode newIdea = newIdeas.next();
	    			Long ideaId = newIdea.findPath("id").getLongValue();
	    			if (Idea.find.where().eq("id_scale", ideaId).
	    					findRowCount() == 0) {
	    				Idea i = new Idea();
	    				i.content = newIdea.findPath("text").getTextValue();
	    				i.title = newIdea.findPath("title").getTextValue();
	    				i.score = newIdea.findPath("voteCount").getIntValue();
	    				i.author = newIdea.findPath("name").getTextValue();
	    				i.idScale = newIdea.findPath("id").getLongValue();
	    				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    				String ideaDate = newIdea.findPath("creationDateTime").
	    						getTextValue().split("T")[0];
	    				try {
	    					i.date = new Date(dateFormat.parse(ideaDate).
	    							getTime());
	    				} catch (ParseException e) {
	    					e.printStackTrace();
	    				}
	    				Idea.create(i);
	    				newIdeasCreated = true;
	    			}
	    		}
	    		if (newIdeasCreated) {
	    			return ok("New ideas retrieved");
	    		}
	    		else {
	    			return ok("No new ideas found");
	    		}
	    	}
	    	else {
	    		return badRequest("Something wrong with the request");
	    	}
		} catch (TimeoutException e1) {
			return badRequest("Something wrong with the request");
		}
    }
    
    public static Result feedVotes() {
    	Integer previousScore = currentIdea.score;
    	System.out.print("Votes currently: " + previousScore);
    	Response response;
		try {
			response = getIdea(currentIdea.idScale);
			if (response.getStatus() == 200) {				
				Integer currentScore = response.asJson().findPath("voteCount")
						   					   .getIntValue();
				currentIdea.updateScore(currentScore);				
				System.out.print("Votes after: " + currentScore);				
		    	if (previousScore != currentScore) {
		    		return ok("New votes from IdeaScale.com");
		    	}
		    	else {
		        	return ok("No new vote from IdeaScale.com");
		    	}
	    	}
	    	else {
	    		return badRequest("Problem when try to upload the idea");
	    	}
		} catch (TimeoutException e) {
			e.printStackTrace();
			return badRequest("Promise timed out after 5000 : MILLISECONDS");
		}
    }
}
