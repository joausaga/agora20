package models;

import java.util.ArrayList;
import java.util.List;

import play.data.validation.Constraints.Required;

public class Idea {
	
	public Long id;
	public String title;
	public String content;
	
	public static List<Idea> all() {
		return new ArrayList<Idea>();
	}
	
	public static void create(Idea idea) {
	}
	  
	public static void delete(Long id) {
	}
}
