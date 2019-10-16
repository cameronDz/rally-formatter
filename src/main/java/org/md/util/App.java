package org.md.util;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.md.util.models.UserStoryModel;
import org.md.util.services.PdfBoxWriterService;
import org.md.util.services.PoiReaderService;
import org.md.util.services.PoiWriterService;

public class App {

	private static final Logger LOG = LogManager.getLogger();

	public static void main (String... args) {
		LOG.info("Starting proof of concept run..");
		LOG.info("Starting pdfbox writer service..");
		String pdfBoxOutputPath = "target/pdfBoxDocument.pdf";
		new PdfBoxWriterService().generateDocument(pdfBoxOutputPath);
		LOG.info("Finishing pdfbox writer service..");
		
		LOG.info("Starting pio reader/writer service..");
		String poiExportInputPath = "assets/data/export.xlsx";
		String poiOutputPath = "target/poiWriter.docx";
		List<UserStoryModel> userStoryList = new PoiReaderService().createUserStories(poiExportInputPath);
		new PoiWriterService().generateDocs(userStoryList, poiOutputPath);
		LOG.info("Finishing pio reader/writer service..");
		LOG.info("Finishing proof of concept run..");
	}
}
