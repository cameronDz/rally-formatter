package writer;

import data.UserStoryXLSX;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Cameron
 */
public class XLSXWriter {
    
    /**
     * Basic constructor for writing a doc
     * @param list List of US that will be printed out.
     */
    public XLSXWriter(List<UserStoryXLSX> list) {
        // create document
        XWPFDocument document = new XWPFDocument();
       
        // create head of document and write to file
        XWPFParagraph tmpParagraph = document.createParagraph();
        XWPFRun tmpRun = tmpParagraph.createRun();
        tmpRun.setText("CA Agile Central extracted Data");
        tmpRun.setFontSize(18);
        try {
                document.write(new FileOutputStream(new File("yourTestHere.docx")));
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        System.out.print("AAA");
        
        //loop through list of US and write each to the file
        Iterator<UserStoryXLSX> iterator = list.iterator();
        while( iterator.hasNext() ) {
            System.out.print("AAA");
            
            // reses paragraph
            tmpParagraph = document.createParagraph();
            tmpRun = tmpParagraph.createRun();
            
            // put US data into string
            UserStoryXLSX us = iterator.next();
            String usString = "US";
            usString += us.getId() + ": ";
            usString += us.getName() + "\n";
            usString += "Description: " + us.getDescription() + "\n";
            usString += "Notes: " + us.getNotes() + "\n";
            
            // set the US string to be written in to doc
            tmpRun.setText(usString);
            tmpRun.setFontSize(12);
            try {
                    document.write(new FileOutputStream(new File("yourTestHere.docx")));
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
        }
        
        //document.close();
    }
}
