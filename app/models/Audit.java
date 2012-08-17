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
	
	@OneToOne
	public Idea idea;
	
	public static Finder<Integer,Audit> find = new Finder<Integer, Audit>(
		    Integer.class, Audit.class
	);
	
	public static List<Audit> all() {
		return find.all();
	}
	
	public static void create(Audit idea) {
		idea.save();
	}
}
