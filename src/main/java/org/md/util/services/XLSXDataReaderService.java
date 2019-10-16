package org.md.util.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.md.util.data.UserStoryXLSX;

public class XLSXDataReaderService {

    private String path;

    public XLSXDataReaderService() {
    	this.path = "";
    }

    /**
     * Basic constructor for reader
     * @param path the file path of the XLSX sheet being read from
     */
    public XLSXDataReaderService(String path) {
        this.path = path;
    }

    /**
     * Iterates through workbook and returns all user stories.
     * @return List of all user stories.
     * @throws FileNotFoundException if the file does not exists
     * @throws IOException if the file can't be read
     */
    public List<UserStoryXLSX> createUserStories() throws FileNotFoundException, IOException {
        List<UserStoryXLSX> list = new ArrayList<UserStoryXLSX>();
        FileInputStream inputStream = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        // iterator through list of stories, skip first row
        Iterator<Row> iterator = sheet.iterator();
        iterator.next();
        while(iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            UserStoryXLSX us = new UserStoryXLSX(0);
            
            // work through the current 4 columns in the extract
            Cell cell = cellIterator.next();
            String value = cell.getStringCellValue();
            us.setId( getIntFromFormattedId( value ));
            
            // get US name
            cell = cellIterator.next();
            value = cell.getStringCellValue();
            us.setName(value);
            
            // get US description
            cell = cellIterator.next();
            value = cell.getStringCellValue();
            us.setName(value);
            
            // get US notes
            cell = cellIterator.next();
            value = cell.getStringCellValue();
            us.setName(value);
            
            // add US to list
            list.add(us);
        }
        workbook.close();
        return list;
    }

	/**
	 * Takes a formatted ID from rally, that contains integers as well as letters, removes the letters, and returns the integer.
	 * http://stackoverflow.com/questions/2338790/get-int-from-string-also-containing-letters-in-java
	 * @param idString String that contains desired ID
	 * @return integer that was previously in a String form with attached letters
	 */
	private int getIntFromFormattedId(String idString) {
		return Integer.parseInt(idString.replaceAll("[\\D]", ""));
	}
}
