package data;

/**
 * Used as the basic class for all agile objects: Tasks, UserStories, Features,
 * and Capabilities.
 * @author Cameron
 *
 */
public abstract class AbstractAgileObject {
	
	protected String name;
	protected String description;
	protected String notes;
	protected String discussions;
	
	protected String type;
	protected String status;
	protected String source;
	
	protected int id;
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDiscussions() {
		return discussions;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSource() {
		return source;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setName(String s) {
		this.name = s;
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setDescription(String s) {
		this.description = s;
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setDiscussions(String s) {
		this.discussions = s;
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setNotes(String s) {
		this.notes = s;
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setType(String s) {
		this.type = s;
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setStatus(String s) {
		this.status = s;
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setSource(String s) {
		this.status = s;
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setId(int i) {
		this.id = i;
	}
	
	/**
	 * 
	 */
	public abstract String toString();
}
