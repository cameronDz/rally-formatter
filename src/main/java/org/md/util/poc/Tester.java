package org.md.util.poc;

import java.util.List;

import org.md.util.models.XLSXUserStoryModel;
import org.md.util.services.PoiReaderService;
import org.md.util.services.XLSXDataWriterService;

/**
 * @author Cameron
 */
public class Tester {

	public static void main(String[] args) {
		String path = "assets/data/export.xlsx";
		List<XLSXUserStoryModel> userStoryXlsxList = new PoiReaderService().createUserStories(path);
		new XLSXDataWriterService().generateDocs(userStoryXlsxList);
	}
}
