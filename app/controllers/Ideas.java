package controllers;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.persistence.Query;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import java.util.Random;

import akka.util.Duration;

import com.avaje.ebean.Ebean;

import models.ExtraInfo;
import models.Idea;
import models.Audit;
import play.Play;
import play.data.Form;
import play.data.format.Formats.DateTime;
import play.libs.F.Function;
import play.libs.Json;
import play.libs.WS;
import play.libs.WS.Response;
import play.libs.WS.WSRequestHolder;
import play.mvc.Controller;
import play.mvc.Result;
import play.api.Configuration;
import play.api.templates.Html;
import play.libs.Akka;
import play.Logger;

public class Ideas extends Controller {
	
	static Form<Idea> ideaForm = form(Idea.class);
	static final String API_TOKEN = "5b3326f8-50a5-419d-8f02-eef6a42fd61a";
	static final String COMMUNITY_NAME = "fiveheads";
	//static final String COMMUNITY_NAME = "agoratrento";
	//static final String API_TOKEN = "54a0840e-17b7-4f82-9243-07d1380e7e17";
	//static final String COMMUNITY_NAME = "agoraunitn";
	//static final String API_TOKEN = "11c2b8fb-9cc5-4dae-afd3-cf03abb8ecf1";
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
		ExtraInfo ei = currentIdea.extraInfo();
		if (ei != null) {
			return ok(views.html.idea.render(currentIdea.title,currentIdea.content,
					  currentIdea.author,currentIdea.score,ei.title, ei.content));
		}
		else {
			return ok(views.html.idea.render(currentIdea.title,currentIdea.content,
					  currentIdea.author,currentIdea.score,"", ""));
		}
	}
	
	/**
	 * Randomly get a new idea from the local database
	 * @return the idea retrieved
	 */
	public static Idea getLocalIdea() {
		if (existsIdea()) {
			Idea i = Idea.find.where().ne("id", currentIdea.id).orderBy("RAND()")
									.findList().get(0);
			return i;
		}
		else {
			Integer numberIdeas = Idea.find.all().size();
			if (numberIdeas == 0) {
				feedIdeas();
			}
			Idea i = Idea.find.orderBy("RAND()").findList().get(0);
			return i;
		}
	}
	
	/**
	 * Get recent ideas from IdeaScale.com
	 * @return request response
	 * @throws TimeoutException
	 */
	public static Response getRecentIdeas() throws TimeoutException {
		WSRequestHolder request = WS.url("http://"+COMMUNITY_NAME+".ideascale.com/a/rest/v1/ideas/recent")
				.setHeader("api_token", API_TOKEN);
		Response response = request.get().get();
		return response;
	}
	
	/**
	 * Get all ideas from IdeaScale.com
	 * @return request response
	 * @throws TimeoutException
	 */
	public static ArrayList<JsonNode> getAllIdeas() throws TimeoutException {
		WSRequestHolder request = WS.url("http://"+COMMUNITY_NAME+".ideascale.com/a/rest/v1/campaigns")
									.setHeader("api_token", API_TOKEN);
		Response response = request.get().get();
		ArrayList<JsonNode> allIdeas = new ArrayList<JsonNode>();
		if (response.getStatus() == 200) {
    		Iterator<JsonNode> campaigns = response.asJson().getElements(); 
    		while(campaigns.hasNext()) {
    			JsonNode campaign = campaigns.next();
    			Long campaignId = campaign.findPath("id").getLongValue();
    			WSRequestHolder requestIdeas = WS.url("http://"+COMMUNITY_NAME+".ideascale.com/a/rest/v1/campaigns/"+
    												  campaignId+"/ideas")
    											 .setHeader("api_token", API_TOKEN);
    			Response responseIdeas = requestIdeas.get().get();
    			if (responseIdeas.getStatus() == 200) {
    				Iterator<JsonNode> ideas = responseIdeas.asJson().getElements();
    				while(ideas.hasNext()) {
    					allIdeas.add(ideas.next());
    				}
    			}
    			else {
    				Logger.error("Something wrong with the request to obtain all the ideas from the campaign " + campaignId.toString());
    			}
    		}
		}
		else {
			Logger.error("Something wrong with the request to obtain all the ideas from IdeaScale");
		}
		return allIdeas;
	}
	
	/**
	 * Get idea information about a particular idea from IdeaScale.com
	 * @param ideaId ideaScale id 
	 * @return request response
	 * @throws TimeoutException
	 */
	/*public static Response getIdea(Long ideaId) throws TimeoutException {
		WSRequestHolder request = WS.url("http://fiveheads.ideascale.com/a/rest/v1/ideas/" + ideaId)
				.setHeader("api_token", API_TOKEN);
		Response response = request.get().get();
		return response;
	}*/
	
	public static Result getIdea(Long ideaId) {
        return async(
        		WS.url("http://"+COMMUNITY_NAME+".ideascale.com/a/rest/v1/ideas/" + ideaId)
				  .setHeader("api_token", API_TOKEN).get()
					  .map(
						  new Function<WS.Response, Result>() {
							  public Result apply(WS.Response response) {
								  if (response.getStatus() == 200) {
									  updateVotes(response);
								  }
								  return ok();
							  }
						  }
						)
        		);
     }
	
	
	/**
	 * Shows the information of the current idea
	 * @return 
	 */
    public static Result show() {
    	ObjectNode result = Json.newObject();
        result.put("title", currentIdea.title);
        result.put("content", currentIdea.content);
        result.put("author", currentIdea.author);
        result.put("score", currentIdea.score);
        ExtraInfo ei = currentIdea.extraInfo();
        if (ei != null) {
        	result.put("eiTitle", ei.title);
        	result.put("eiContent", ei.content);
        }
        else {
        	result.put("eiTitle", "");
        	result.put("eiContent", "");
        }
        return ok(result);
    }
    
    public static Result sendVote(String vote, String voteType) {
        return async(
            WS.url("http://"+COMMUNITY_NAME+".ideascale.com/a/rest/v1/ideas/"+ 
					  currentIdea.idScale +"/vote/" + voteType)
					  .setHeader("api_token", API_TOKEN).post(vote)
					  .map(
							  new Function<WS.Response, Result>() {
								  public Result apply(WS.Response response) {
									  Long ideaId = response.asJson().findPath("id").getLongValue();
									  if (ideaId == currentIdea.idScale) {
										  currentIdea.wasRegistered();
									  }
									  return ok();
								  }
							  }
						)
        		);
     }
    
    /**
     * Register the positive vote in the local database and also in IdeaScale.com
     * @return request result from the voting register in IdeaScale.com
     */
    public static Result voteUp() {
    	if (!existsIdea()) {
			currentIdea = getLocalIdea();
			Logger.error("Idea does not exists");
		}
    	if (currentIdea.registered == null || !currentIdea.registered) {
    		sendVote("{ \"myVote\":1 }","up");
    	}
    	currentIdea.updateScore(1);
    	registerEvent("VOTEUP");
    	return ok("You AGREED with the idea");
    }
    
    /**
     * Register the negative vote in the local database and also in IdeaScale.com
     * @return request result from the voting register in IdeaScale.com
     */
    public static Result voteDown() {
    	if (!existsIdea()) {
			currentIdea = getLocalIdea();
			Logger.error("Idea does not exists");
		}
    	if (currentIdea.registered == null || !currentIdea.registered) {
    		sendVote("{ \"myVote\":-1 }","down");
    	}
    	currentIdea.updateScore(-1);
    	registerEvent("VOTEDOWN");
    	return ok("You DISAGREED with the idea");
    }

    /**
     * Get a new idea from the local database
     * @return 
     */
    public static Result change(String event) {
    		currentIdea = getLocalIdea();
    		feedVotes();
    		ObjectNode result = Json.newObject();
            result.put("title", currentIdea.title);
            result.put("content", currentIdea.content);
            result.put("author", currentIdea.author);
            result.put("score", currentIdea.score);
            ExtraInfo ei = currentIdea.extraInfo();
            if (ei != null) {
            	result.put("eiTitle", ei.title);
            	result.put("eiContent", ei.content);
            }
            else {
            	result.put("eiTitle", "");
            	result.put("eiContent", "");
            }
            if (event.equals("true")) {
            	registerEvent("CHANGEIDEA");
            }
            return ok(result);
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
	    			Logger.info("New ideas retrieved from IdeaScale");
	    		}
	    		return redirect("/ideas");
	    	}
	    	else {
	    		Logger.error("Something wrong with the request to obtain new ideas from IdeaScale");
	    		return ok("Problems when feeting new ideas from IdeaScale.com");
	    	}
		} catch (TimeoutException e1) {
			Logger.error("Something wrong with the request to obtain new ideas from IdeaScale");
			return ok("Problems when feeting new ideas from IdeaScale.com");
		}
    }
    
    private static void deleteUnexistedIdeas(ArrayList<JsonNode> existedIdeas) {
    	if (!Idea.all().isEmpty()) {
    		for (Idea localIdea : Idea.all()) {
    			boolean alreadyExists = false;
    			for (JsonNode remoteIdea : existedIdeas) {
    				Long remoteIdeaId = remoteIdea.findPath("id").getLongValue();
    				if (localIdea.idScale == remoteIdeaId) {
    					alreadyExists = true;
    					break;
    				}
    			}
    			if (!alreadyExists) {
    				Idea.delete(localIdea.id);
    			}
    		}
    	}
    }
    
    public static Result syncIdeas() {
		try {
			ArrayList<JsonNode> allIdeas = getAllIdeas();
			deleteUnexistedIdeas(allIdeas);
			for (JsonNode idea : allIdeas) {
				Long ideaId = idea.findPath("id").getLongValue();
    			if (Idea.find.where().eq("id_scale", ideaId).
    					findRowCount() > 0) {
    				Idea i = Idea.find.where().eq("id_scale", ideaId).findList().get(0);
    				i.content = idea.findPath("text").getTextValue();
    				i.title = idea.findPath("title").getTextValue();
    				i.score = i.score + idea.findPath("voteCount").getIntValue();
    				i.update();
    			}
    			else {
					Idea i = new Idea();
					i.content = idea.findPath("text").getTextValue();
					i.title = idea.findPath("title").getTextValue();
					i.score = idea.findPath("voteCount").getIntValue();
					i.author = idea.findPath("name").getTextValue();
					i.idScale = idea.findPath("id").getLongValue();
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String ideaDate = idea.findPath("creationDateTime").
							getTextValue().split("T")[0];
					try {
						i.date = new Date(dateFormat.parse(ideaDate).
								getTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}
    			}
			}
			return redirect("/ideas");
		} catch (TimeoutException e1) {
			Logger.error("Something wrong with the request to obtain new ideas from IdeaScale");
			return ok("Problems when feeting new ideas from IdeaScale.com");
		}
    }
    
    public static void feedVotes() {
    	if (!existsIdea()) {
			currentIdea = getLocalIdea();
		}
    	getIdea(currentIdea.idScale);
    }
    
    public static void updateVotes(Response response) {
    	Long ideaId = response.asJson().findPath("id").getLongValue();
    	Integer currentScore = response.asJson().findPath("voteCount")
		   		   					   .getIntValue();
    	if (ideaId == currentIdea.idScale) {
    		currentIdea.updateScore(currentScore);
    	}
    }
    
    public static boolean registerEvent(String event) {
    	Audit audit = new Audit();
    	audit.event=event;
    	java.util.Date date= new java.util.Date();
    	audit.datetime=new Timestamp(date.getTime());
    	Audit.create(audit);
    	return true;
    }
}
