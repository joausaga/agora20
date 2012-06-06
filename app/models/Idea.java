package models;

import java.sql.Date;
import java.util.List;

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
	
	public static Finder<Integer,Idea> find = new Finder<Integer, Idea>(
		    Integer.class, Idea.class
	);
	
	public static List<Idea> all() {
		return find.all();
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
	
	public static void delete(Integer id) {
		find.ref(id).delete();
	}
}
