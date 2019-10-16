package org.md.util.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.md.util.models.XLSXUserStoryModel;

public class XLSXDataReaderService {
	
	private static final Logger LOG = LogManager.getLogger();

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
     * @return List of all user stories
     */
    public List<XLSXUserStoryModel> createUserStories() {
        List<XLSXUserStoryModel> list = null;
		try {
			FileInputStream inputStream = new FileInputStream(new File(path));
			Workbook workbook = new XSSFWorkbook(inputStream);
	        Sheet sheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = sheet.iterator();
	        list = generateListByIteratoringThroughRows(iterator);
	        workbook.close();
		} catch (IOException e) {
			LOG.error("Could not finish generating User Story list", e);
		}
        return list;
    }

	private List<XLSXUserStoryModel> generateListByIteratoringThroughRows(Iterator<Row> iterator) {
        List<XLSXUserStoryModel> list = new ArrayList<XLSXUserStoryModel>();

        // iterator through list of stories, skip first row
        iterator.next();
        while(iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            XLSXUserStoryModel us = new XLSXUserStoryModel(0);
            
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
