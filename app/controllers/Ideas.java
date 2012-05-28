package controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

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
	static HashMap<String,String> idea = init();
	
	public static HashMap<String,String> init() {
		HashMap<String,String> newIdea = new HashMap();
		newIdea.put("title", "");
		newIdea.put("id", "");
		newIdea.put("text", "");
		newIdea.put("creator", "");
		newIdea.put("score", "");
		newIdea.put("date", "");
		return newIdea;
	}
	
	public static boolean existsIdea() {
		if (idea.get("id") != "") {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static Result index() {
		if (!existsIdea()) {
			getRecentIdea();
		}
		return ok(views.html.idea.render(idea.get("title"),idea.get("text"),idea.get("creator"),idea.get("score")));
	}
	
	private Result getIdeaAsynchronously() {
		return async(
				WS.url("http://fiveheads.ideascale.com/a/rest/v1/ideas/recent")
				.setHeader("api_token", API_TOKEN)
				.get().map(
						new Function<WS.Response, Result>() {
							public Result apply(WS.Response response) {
								idea.put("id", response.asJson().findPath("id").getNumberValue().toString());
								idea.put("text", response.asJson().findPath("text").getTextValue());
								idea.put("title", response.asJson().findPath("title").getTextValue());
								idea.put("voteCount", response.asJson().findPath("voteCount").getNumberValue().toString());
								idea.put("creator", response.asJson().findPath("name").getTextValue());
								return ok("Operation successful");
							}
						}
				)
		);
	}
	
	public static Response getRecentIdea() {
		WSRequestHolder request = WS.url("http://fiveheads.ideascale.com/a/rest/v1/ideas/recent")
				.setHeader("api_token", API_TOKEN);
		Response response = request.get().get();
		idea.put("id", response.asJson().findPath("id").getNumberValue().toString());
		idea.put("text", response.asJson().findPath("text").getTextValue());
		idea.put("title", response.asJson().findPath("title").getTextValue());
		idea.put("score", response.asJson().findPath("voteCount").getNumberValue().toString());
		idea.put("creator", response.asJson().findPath("name").getTextValue());
		return response;
	}

	public static Response getIdea(String ideaId) throws TimeoutException {
		WSRequestHolder request = WS.url("http://fiveheads.ideascale.com/a/rest/v1/ideas/" + ideaId)
				.setHeader("api_token", API_TOKEN);
		Response response = request.get().get();
		idea.put("id", response.asJson().findPath("id").getNumberValue().toString());
		idea.put("text", response.asJson().findPath("text").getTextValue());
		idea.put("title", response.asJson().findPath("title").getTextValue());
		idea.put("score", response.asJson().findPath("voteCount").getNumberValue().toString());
		idea.put("creator", response.asJson().findPath("name").getTextValue());
		return response;
	}
	
    public static Html showIdea() {
    	return views.html.idea.render(idea.get("title"),idea.get("text"),idea.get("creator"),idea.get("score"));
    }
    
    public static Result voteUp() {
    	WSRequestHolder request = WS.url("http://ideas.ideascale.com/a/rest/v1/ideas/"+ idea.get("id") +"/vote/up")
				.setHeader("api_token", API_TOKEN);
    	Response response = request.post("{ \"myVote\":1 }").get();
    	if (response.getStatus() == 200) {
    		return ok("Your vote has been registered");
    	}
    	else {
    		return badRequest("Problem when try to register your vote");
    	}
    }
    
    public static Result voteDown() {
    	WSRequestHolder request = WS.url("http://ideas.ideascale.com/a/rest/v1/ideas/"+ idea.get("id") +"/vote/down")
				.setHeader("api_token", API_TOKEN);
    	Response response = request.post("{ \"myVote\":-1 }").get();
    	if (response.getStatus() == 200) {
    		return ok("Your vote has been registered");
    	}
    	else {
    		return badRequest("Problem when try to register your vote");
    	}
    }

    public static Result change() {
    	Response response = getRecentIdea();
    	if (response.getStatus() == 200) {
    		return ok(views.html.idea.render(idea.get("title"),idea.get("text"),idea.get("creator"),idea.get("score")));
    	}
    	else {
    		return badRequest("Problem when try to obtain an idea");
    	}
    }
    
    public static Result updateIdeaInfo() {
    	Response response;
		try {
			response = getIdea(idea.get("id"));
			if (response.getStatus() == 200) {
	    		return ok(views.html.idea.render(idea.get("title"),idea.get("text"),idea.get("creator"),idea.get("score")));
	    	}
	    	else {
	    		return badRequest("Problem when try to upload the idea");
	    	}
		} catch (TimeoutException e) {
			e.printStackTrace();
			return badRequest("Promise timed out after 5000 : MILLISECONDS");
		}
    }
    
    public static Result create() {
    	return TODO;
    }
}
