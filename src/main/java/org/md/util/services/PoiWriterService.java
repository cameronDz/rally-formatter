package org.md.util.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.md.util.models.UserStoryModel;

/**
 * @author Cameron
 */
public class PoiWriterService {

	private static final Log LOG = LogFactory.getLog(PoiWriterService.class);

	public PoiWriterService() { }

	/**
	 * @param userStoryList List of US that will be printed out
	 * @param path directory and filename to output document
	 */
	public void generateDocs(List<UserStoryModel> userStoryList, String path) {
		// create variables for writing documents
		XWPFDocument document;
		XWPFParagraph tmpParagraph;
		XWPFRun tmpRun;

		// create first document
		document = new XWPFDocument();
		tmpParagraph = document.createParagraph();
		tmpRun = tmpParagraph.createRun();
		tmpRun.setText("CA Agile Central extracted Data");
		tmpRun.setFontSize(18);

		try {
			// create head of document and write to file
			document.write(new FileOutputStream(new File(path)));
			document.close();
		} catch (IOException e) {
			LOG.error("Could not finish writing document", e);
		}

		//loop through list of US and write each to the file
		Iterator<UserStoryModel> iterator = userStoryList.iterator();
		while (iterator.hasNext()) {

			// reset writer objects
			document = new XWPFDocument();
			tmpParagraph = document.createParagraph();
			tmpRun = tmpParagraph.createRun();

			// put US data into string
			UserStoryModel us = iterator.next();
			String usString = "US";
			usString += us.getId() + ": ";
			usString += us.getName() + "\n";
			usString += "Description: " + us.getDescription() + "\n";
			usString += "Notes: " + us.getNotes() + "\n";

			// set the US string to be written in to doc
			tmpRun.setText(usString);
			tmpRun.setFontSize(12);
			try {
				document.write(new FileOutputStream(new File(path)));
				document.close();
			} catch (IOException e) {
				LOG.error("Could not finish writing document", e);
			}
		}
	}
}
