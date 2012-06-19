package controllers;

import java.util.Map;

import models.ExtraInfo;
import models.Idea;
import play.data.*;
import play.mvc.*;
import views.html.*;
import play.*;

public class ExtraInfos extends Controller {
	/**
     * This result directly redirect to extra info home.
     */
    public static Result GO_HOME = redirect(
        routes.ExtraInfos.list(0, "title", "asc", "")
    );
    
    public static Result index() {
    	return GO_HOME;
    }

    /**
     * Display the paginated list of extra informations available.
     *
     * @param page Current page number (starts from 0)
     * @param sortBy Column to be sorted
     * @param order Sort order (either asc or desc)
     * @param filter Filter applied on extra information title
     */
    public static Result list(int page, String sortBy, String order, String filter) {
        return ok(
            views.html.list.render(
                ExtraInfo.page(page, 10, sortBy, order, filter),
                sortBy, order, filter
            )
        );
    }
    
	/**
	* Display the 'edit form' of a existing Extra Information.
	*
	* @param id Id of the extra information to edit
	*/
    public static Result edit(Integer id) {
    	Form<ExtraInfo> extraInfoForm = form(ExtraInfo.class).fill(
    			ExtraInfo.find.byId(id)
	    );
	    return ok(
	    		views.html.editForm.render(id, extraInfoForm)
	    );
	}
    
    /**
     * Handle the 'edit form' submission 
     *
     * @param id Id of the extra information to edit
     */
    public static Result update(Integer id) {
        Form<ExtraInfo> extraInfoForm = form(ExtraInfo.class).bindFromRequest();
        if(extraInfoForm.hasErrors()) {
            return badRequest(views.html.editForm.render(id, extraInfoForm));
        }
        bindExtraInfo(extraInfoForm.data()).update(id);
        flash("success", "Computer " + extraInfoForm.get().title + " has been updated");
        return GO_HOME;
    }
    
    /**
     * Display the 'new extra info form'.
     */
    public static Result create() {
        Form<ExtraInfo> createExtraInfoForm = form(ExtraInfo.class);
        return ok(
        		views.html.createForm.render(createExtraInfoForm)
        );
    }
    
    public static Result save() {
    	Form<ExtraInfo> extraInfoForm = form(ExtraInfo.class).bindFromRequest();
        if(extraInfoForm.hasErrors()) {
            return badRequest(views.html.createForm.render(extraInfoForm));
        }
        bindExtraInfo(extraInfoForm.data()).save();
        flash("success", "Extra Info " + extraInfoForm.get().title + " has been created");
        return GO_HOME;
    }
    
    /**
     * Handle extra information deletion
     */
    public static Result delete(Integer id) {
        ExtraInfo.delete(id);
        flash("success", "Extra Information has been deleted");
        return GO_HOME;
    }
    
    private static ExtraInfo bindExtraInfo(Map<String,String> data) {
    	ExtraInfo newExtraInfo = new ExtraInfo();
    	newExtraInfo.title = data.get("title");
    	newExtraInfo.content = data.get("content");
    	Integer ideaId = Integer.parseInt(data.get("idea.id"));
    	newExtraInfo.idea = Idea.find.byId(ideaId);
        return newExtraInfo;
    }
}
