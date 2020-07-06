package com.platform.project.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel {

		
	
	public Map<String, String> setMapData() throws IOException {
		 
		  String path = "C:\\Users\\Sehaj Singh\\eclipse-workspace\\SeleniumIntro\\src\\test\\resources\\propertiesxl.xlsx";
		  
		  FileInputStream fis = new FileInputStream(path);
	
		  Workbook workbook = new XSSFWorkbook(fis);
		
		  org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
		  
		  int lastRow = sheet.getLastRowNum();
		  
		   
		  Map<String, String> dataMap = new HashMap<String, String>();
		  
		  //Looping over entire row
		  for(int i=0; i<=lastRow; i++){
			  
			  Row row = sheet.getRow(i);
			  
			  //1st Cell as Value
			  Cell valueCell = row.getCell(1);
				  
			  //0th Cell as Key
			  Cell keyCell = row.getCell(0);
			  
				  
			  String value = valueCell.getStringCellValue().trim();
			  String key = keyCell.getStringCellValue().trim();
				  
			  //Putting key & value in dataMap
			  dataMap.put(key, value);
				  
			  
			 
		  }
		  
		 //Returning excelFileMap
		return dataMap;

	}

}
