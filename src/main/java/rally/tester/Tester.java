/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rally.tester;

import data.UserStory;
import data.UserStoryXLSX;
import java.io.IOException;
import java.util.List;
import reader.XLSXReader;
import writer.XLSXWriter;

/**
 *
 * @author Cameron
 */
public class Tester {
    
    public static void main(String[] args) throws IOException {
        
        String file = "export.xlsx";
        XLSXReader read = new XLSXReader(file);
        List<UserStoryXLSX> list = read.createUserStories();
        if( list.isEmpty() ) {
            System.out.print("Empty");
        }
        XLSXWriter writer = new XLSXWriter(list);
    }
    
}
