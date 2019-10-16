package org.md.util.poc;

import java.util.ArrayList;
import java.util.List;

import org.md.util.models.XLSXUserStoryModel;
import org.md.util.services.XLSXDataReaderService;
import org.md.util.services.XLSXDataWriterService;

/**
 * @author Cameron
 */
public class Tester {

	public static void main(String[] args) {
		String file = "assets/data/export.xlsx";
		XLSXDataReaderService reader;
		List<XLSXUserStoryModel> userStoryXlsxList = new ArrayList<XLSXUserStoryModel>();
		reader = new XLSXDataReaderService(file);
		userStoryXlsxList = reader.createUserStories();
		XLSXDataWriterService writer = new XLSXDataWriterService();
		writer.generateDocs(userStoryXlsxList);
	}
}
