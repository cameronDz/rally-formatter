/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.md.util.poc;

import java.io.IOException;
import java.util.List;

import org.md.util.data.UserStoryXLSX;
import org.md.util.reader.XLSXReader;
import org.md.util.writer.XLSXWriter;

/**
 * @author Cameron
 */
public class Tester {

	public static void main(String[] args) throws IOException {

        String file = "assets/data/export.xlsx";
        XLSXReader read = new XLSXReader(file);
        List<UserStoryXLSX> list = read.createUserStories();
        if(list.isEmpty()) {
        	// TODO use proper logger
            System.out.print("Empty");
        }
        // TODO this should be a void method call on a service or help class
        new XLSXWriter(list);
    }
}
