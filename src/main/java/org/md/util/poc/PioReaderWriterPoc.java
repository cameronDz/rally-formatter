package org.md.util.poc;

import java.util.List;

import org.md.util.models.UserStoryModel;
import org.md.util.services.PoiReaderService;
import org.md.util.services.PoiWriterService;

/**
 * @author Cameron
 */
public class PioReaderWriterPoc {

	public static void main(String[] args) {
		String path = "assets/data/export.xlsx";
		List<UserStoryModel> userStoryList = new PoiReaderService().createUserStories(path);
		new PoiWriterService().generateDocs(userStoryList, "test");
	}
}
