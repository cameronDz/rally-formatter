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
			document.write(new FileOutputStream(new File("yourpathhere.docx")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//document.close();
	}
	
}
