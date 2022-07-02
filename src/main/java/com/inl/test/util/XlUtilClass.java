package com.inl.test.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.zip.X0015_CertificateIdForFile;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlUtilClass {

	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlfile, String XlSheet) throws IOException {
		fis  = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(XlSheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}
	
	public static int getCellCount(String xlfile, String XlSheet, int rowNum) throws IOException {
		fis = new FileInputStream(xlfile);
		wb =new XSSFWorkbook(fis);
		ws = wb.getSheet(XlSheet);
		row = ws.getRow(rowNum); 
		int cellcount = row.getLastCellNum();
		wb.close();
		fis.close();
		
		return cellcount;
	}
	
	public static String getCellData(String xlfile, String XlSheet, int rowNum, int colNum) throws IOException {
		fis = new FileInputStream(xlfile);
		wb =new XSSFWorkbook(fis);
		ws = wb.getSheet(XlSheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		String data;
		try {
		DataFormatter df = new DataFormatter();
		String cellData = df.formatCellValue(cell);
		return cellData;
		}
		catch(Exception e) {
			data = "";
		}
		wb.close();
		fis.close();
		return data;
	}
	
	public static void setCellData(String xlfile, String XlSheet, int rowNum, int colNum, String data) throws IOException {
		fis = new FileInputStream(xlfile);
		wb =new XSSFWorkbook(fis);
		ws = wb.getSheet(XlSheet);
		row = ws.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(data);
		fos = new FileOutputStream(xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();	
		
	}
		
	
	
	
	
	

}
