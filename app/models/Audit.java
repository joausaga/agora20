package models;

import java.sql.Timestamp;
import java.util.List;

import play.*;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;


@Entity
public class Audit extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public Integer id;
	
	@Required
	public String event;
	@Required
	public Timestamp datetime;
	
	public static Finder<Integer,Idea> find = new Finder<Integer, Idea>(
		    Integer.class, Idea.class
	);
	
	public static List<Idea> all() {
		return find.all();
	}
	
	public static void create(Audit idea) {
		idea.save();
	}
}
