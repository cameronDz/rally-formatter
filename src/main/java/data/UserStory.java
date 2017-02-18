package data;

public class UserStory extends AbstractAgileObject {
	
	/**
	 * Basic constructor.
	 * @param id Id of US being stored
	 * @param source the file type the object was extracted from
	 */
	public UserStory(int id, String source) {
		this.id = id;
		this.source = source;
		this.type = "US";
	}
	
	public String toString() {
		return this.type + this.id;
	}
}
