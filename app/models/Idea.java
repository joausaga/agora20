package models;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Idea extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public Integer id;
	
	public Long idScale;
	public Date date;
	
	@Required
	public String title;
	@Lob
	@Basic(fetch = FetchType.EAGER)
	public String content;
	
	public Integer score;
	public String author;
	public Boolean registered;
	
	
	public static Finder<Integer,Idea> find = new Finder<Integer, Idea>(
		    Integer.class, Idea.class
	);
	
	public static List<Idea> all() {
		return find.all();
	}
	
	public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Idea i: Idea.find.orderBy("title").findList()) {
        	//Only add to the list options the Ideas that do not have extra information
        	if (ExtraInfo.find.where().eq("idea_id", i.id).findRowCount() == 0) {
        		options.put(i.id.toString(), i.title);
        	}
        }
        return options;
    }
	
	public static void create(Idea idea) {
		idea.save();
	}
	
	public String getStringScore() {
		return this.score.toString();
	}
	
	public void updateScore(Integer value) {
		this.score = this.score + value;
		this.update();
	}
	
	public void wasRegistered() {
		this.registered = true;
		this.update();
	}
	
	public static void delete(Integer id) {
		find.ref(id).delete();
	}
	
	public ExtraInfo extraInfo() {
		if (ExtraInfo.find.where().eq("idea_id", id).findRowCount() != 0) {
			return ExtraInfo.find.where().eq("idea_id", id)
									 .findList().get(0);
		}
		else {
			return null;
		}
	}
}
