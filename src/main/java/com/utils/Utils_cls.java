package com.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils_cls {

	//Store all commonly used methods for method reusablity purpose 
	
		static String filepath="";
		
		public static String[][] setdata(String sheetname) throws Throwable{
			File file=new File(filepath);
			FileInputStream stream=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(stream);
			XSSFSheet sheet=workbook.getSheet(sheetname);
			
			int rows=sheet.getPhysicalNumberOfRows();
			int col=sheet.getRow(1).getLastCellNum();
			String[][] data=new String[rows-1][col];
			
			for(int i=0;i<rows-1;i++) {
				for(int j=0;j<col;j++) {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				}
			}
			workbook.close();
			stream.close();
			return data;
		}
	
	
}
