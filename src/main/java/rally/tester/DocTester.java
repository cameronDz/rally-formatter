package rally.tester;

import java.io.File;   
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;   
import org.apache.poi.xwpf.usermodel.XWPFParagraph;   
import org.apache.poi.xwpf.usermodel.XWPFRun;   

public class DocTester {

	public static void main(String[] args) {
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph tmpParagraph = document.createParagraph();
		XWPFRun tmpRun = tmpParagraph.createRun();
		tmpRun.setText("LALALALAALALAAAA");
		tmpRun.setFontSize(18);
		try {
			document.write(new FileOutputStream(new File("target/yourpathhere.docx")));
			document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
