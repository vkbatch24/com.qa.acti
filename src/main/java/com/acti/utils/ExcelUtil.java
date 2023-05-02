package com.acti.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	XSSFWorkbook wb;
	
	public  ExcelUtil(String excelPath) {
		try {
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
		}
		catch(NullPointerException e) {
			System.out.println("File Name cannot be null." + e.getMessage());
		}
		catch(FileNotFoundException e) {
			System.out.println("Unable to find file." + e.getMessage());
		}
		catch(IOException e) {
			System.out.println("Unable to read file." + e.getMessage());
		}
		
		
	}
	
	public int getRows(int sheetNum) {
		int numRows = wb.getSheetAt(sheetNum).getLastRowNum()+1;
		return numRows;
	}
	
	public String getCellData(int sheetNum, int rowNum, int colNum){
		String rowValue = wb.getSheetAt(sheetNum).getRow(rowNum).getCell(colNum).toString();
		return rowValue;
		

	}
}
