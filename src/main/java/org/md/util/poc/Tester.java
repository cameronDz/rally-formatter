package org.md.util.poc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.md.util.data.UserStoryXLSX;
import org.md.util.services.XLSXDataReaderService;
import org.md.util.services.XLSXDataWriterService;

/**
 * @author Cameron
 */
public class Tester {

	public static void main(String[] args) {
		String file = "assets/data/export.xlsx";
		XLSXDataReaderService reader;
		List<UserStoryXLSX> userStoryXlsxList = new ArrayList<UserStoryXLSX>();
		try {
			reader = new XLSXDataReaderService(file);
			userStoryXlsxList = reader.createUserStories();
		} catch (IOException e) {
			// TODO use proper logging
			e.printStackTrace();
		}
		// TODO convert to a service
		XLSXDataWriterService writer = new XLSXDataWriterService();
		writer.generateDocs(userStoryXlsxList);
	}
}
