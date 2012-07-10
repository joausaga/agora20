package controllers;

import java.util.concurrent.TimeUnit;

import akka.util.Duration;
import play.Logger;
import play.api.Routes;
import play.libs.Akka;
import play.mvc.*;

public class Application extends Controller {

	public static Result index() {
		Logger.info("Creating an async task to feed ideas from IdeaScale every 10 minutes");
		Akka.system().scheduler().schedule(
			Duration.create(0, TimeUnit.MILLISECONDS),
			Duration.create(10, TimeUnit.MINUTES),
			new Runnable() {
				public void run() {
					Ideas.feedIdeas();
				}
			}
		);
		return redirect(routes.Ideas.index());
	}
	
	public static Result projectPresentation() {
		return ok(views.html.presentation.render());
	}
	
}