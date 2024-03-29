package org.md.util.services;

import java.awt.Color;
import java.io.IOException;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PdfBoxWriterService {

	private static final Log LOG = LogFactory.getLog(PdfBoxWriterService.class);

	public PdfBoxWriterService() {}
	
	/**
	 * @param path directory and filename to output document
	 */
	public void generateDocument(String path) {

		// Create a document and add a page to it
		PDDocument document = new PDDocument();
		PDPage page1 = new PDPage(PDRectangle.A4);
		// PDRectangle.LETTER and others are also possible
		PDRectangle rect = page1.getMediaBox();
		// rect can be used to get the page width and height
		document.addPage(page1);

		// Create a new font object selecting one of the PDF base fonts
		PDFont fontPlain = PDType1Font.HELVETICA;
		PDFont fontBold = PDType1Font.HELVETICA_BOLD;
		PDFont fontItalic = PDType1Font.HELVETICA_OBLIQUE;
		PDFont fontMono = PDType1Font.COURIER;

		// Start a new content stream which will "hold" the to be created content
		PDPageContentStream cos;
		try {
			cos = new PDPageContentStream(document, page1);
			int line = 0;
	
			// Define a text content stream using the selected font, move the cursor and draw some text
			cos.beginText();
			cos.setFont(fontPlain, 12);
			cos.newLineAtOffset(100, rect.getHeight() - 50*(++line));
			cos.showText("Hello World. This is a test to see how far it will go to lalalalalallalalallalalalalalalsdfja allalalalalallala");
			cos.endText();
	
			cos.beginText();
			cos.setFont(fontItalic, 12);
			cos.newLineAtOffset(100, rect.getHeight() - 50*(++line));
			cos.showText("Italic");
			cos.endText();
	
			cos.beginText();
			cos.setFont(fontBold, 12);
			cos.newLineAtOffset(100, rect.getHeight() - 50*(++line));
			cos.showText("Bold");
			cos.endText();
	
			cos.beginText();
			cos.setFont(fontMono, 12);
			cos.setNonStrokingColor(Color.BLUE);
			cos.newLineAtOffset(100, rect.getHeight() - 50*(++line));
			cos.showText("Monospaced blue");
			cos.endText();
	
			// Make sure that the content stream is closed:
			cos.close();
	
			PDPage page2 = new PDPage(PDRectangle.A4);
			document.addPage(page2);
			cos = new PDPageContentStream(document, page2);
	
			// draw a red box in the lower left hand corner
			cos.setNonStrokingColor(Color.RED);
			cos.addRect(10, 10, 100, 100);
			cos.fill();
	
			// add two lines of different widths
			cos.setLineWidth(1);
			cos.moveTo(200, 250);
			cos.lineTo(400, 250);
			cos.closeAndStroke();
			cos.setLineWidth(5);
			cos.moveTo(200, 300);
			cos.lineTo(400, 300);
			cos.closeAndStroke();
	
			// add an image
			try {
				PDImageXObject ximage = PDImageXObject.createFromFile("assets/data/RALLY_ACCEPTED.png", document);
				float scale = 0.5f; // alter this value to set the image size
				cos.drawImage(ximage, 100, 400, ximage.getWidth()*scale, ximage.getHeight()*scale);
			} catch (IOException imageException) {
				LOG.error("Unable to add image to document", imageException);
			}
	
			// add a second image
			try {
				PDImageXObject ximage = PDImageXObject.createFromFile("assets/data/RALLY_DEFINED.png", document);
				float scale = 0.5f; // alter this value to set the image size
				cos.drawImage(ximage, 150, 450, ximage.getWidth()*scale, ximage.getHeight()*scale);
			} catch (IOException imageException) {
				LOG.error("Unable to add image to document", imageException);
			}
			// close the content stream for page 2
			cos.close();
			// Save the results and ensure that the document is properly closed:
			document.save(path);
			document.close();

		} catch (IOException e) {
			LOG.error("Unable to finish generating document", e);
		}
	}
}
