package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

/**
 * Computer entity managed by Ebean
 */
@Entity 
public class ExtraInfo extends Model {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    public Integer id;
    
    @Constraints.Required
    public String title;
    
    @Lob
	@Basic(fetch = FetchType.EAGER)
	public String content;
    
    @OneToOne
    public Idea idea;
    
    /**
     * Generic query helper for entity ExtraInfo with id Integer
     */
    public static Finder<Integer,ExtraInfo> find = new Finder<Integer,ExtraInfo>(Integer.class, ExtraInfo.class); 
    
    /**
     * Return a page of extra information
     *
     * @param page Page to display
     * @param pageSize Number of extra informations per page
     * @param sortBy ExtraInfo property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the name column
     */
    public static Page<ExtraInfo> page(int page, int pageSize, String sortBy, String order, String filter) {
        return 
            find.where()
                .ilike("title", "%" + filter + "%")
                .orderBy(sortBy + " " + order)
                .fetch("idea")
                .findPagingList(pageSize)
                .getPage(page);
    }
    
    public static void delete(Integer id) {
		find.ref(id).delete();
	}
    
}

