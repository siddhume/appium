package com.platform.project.commons;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcelProperties {
	HashMap< String, String > properties = new HashMap< String, String >();
	
	public void readExcelFile(File file)     { 

		XSSFCell cell1 =null;
		XSSFCell cell2 =null;

		try{                      

			// Create a FileInputStream by passing the location of excel
			FileInputStream input = new FileInputStream(file);         

			
			
			
			Workbook prop= new XSSFWorkbook(input);

			// get the sheet at location 0 by calling 
			// getSheetAt() method of the Workbook
			
			org.apache.poi.ss.usermodel.Sheet propSheet=prop.getSheet("Sheet1");
			
			
			
			
			

			// Create a Iterator object by calling 
			// sheet's method as rowIterator() which 
			// will return back us with Iterator, which will 
			// loop through each row.
			Iterator rowIterator = propSheet.rowIterator();   

			// Iterating row by row
			while(rowIterator.hasNext()){       

				// Creating a reference to row by calling 
				// next method of the iterator
				XSSFRow row = (XSSFRow) rowIterator.next(); 

				// Creating a iterator which will contain each
				// cell info related to that particular row
				Iterator cellIterator = row.cellIterator(); 

				// Iterating over each cell
				while(cellIterator.hasNext()){    

					// Creating a cell by calling next method of the iterator 
					cell1 = (XSSFCell) cellIterator.next(); 

					System.out.println("Cell One ... " + cell1.getRichStringCellValue());

					// extracting key from the xls
					String key = cell1.getRichStringCellValue().toString();

					// if cellIterator.hasNext() returns false than perform the
					// below task
					if(!cellIterator.hasNext()){

						System.out.println("No Such Element");

						String value = "";

						// put default key and key to it
						properties.put(key, value);  

					} 
					else {

						// if not than create yet another cell from the
						// cell iterator by calling its next method
						cell2 = (XSSFCell) cellIterator.next();

						System.out.println("Cell Two ... " + cell2.getRichStringCellValue());

						// extracting values from the cell2 
						String value = cell2.getRichStringCellValue().toString();

						// storing each properties into the HashMap
						properties.put(key, value);        
					}

					System.out.println("The properties are " + properties);                              

				}          
			}     
		}

		catch (Exception e){

			System.out.println("No Such Element Exception Occured ..... ");

			e.printStackTrace();

		}                
	}
	
	public static void main(String[] args) {

		// Create a object of ReadWriteExcelProperties
		readExcelProperties readWriteExcelProperties = new readExcelProperties();

		// Call readExcelFile() method by passing it location of xls
		// This method will load keys and values from xls to HashMap
	    File file =    new File("C:\\Users\\Sehaj Singh\\eclipse-workspace\\SeleniumIntro\\src\\test\\resources\\propertiesxl.xlsx");
		readWriteExcelProperties.readExcelFile(file);

		

	}
	
}
