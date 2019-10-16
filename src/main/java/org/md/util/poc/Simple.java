package org.md.util.poc;

import org.md.util.services.PdfBoxWriterService;
 
public class Simple {

	public static void main (String[] args) {
		String outputFileName = "target/Simple.pdf";
		new PdfBoxWriterService().generateDocument(outputFileName);
	}
}
