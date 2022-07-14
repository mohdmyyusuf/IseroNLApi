package com.inl.test.util;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataSupplierClass {

@DataProvider(name = "userdetailssupplier")
public String[][] getUserData() throws IOException{
		//String dataFile = "C:\\EclipseWS\\ApiTestsIseroNL\\src\\main\\java\\com\\inl\\test\\data\\DataFile.xlsx";
		String dataFile =  System.getProperty("user.dir")+"\\src\\main\\java\\com\\inl\\test\\data\\DataFileApi.xlsx";
		
		int totalRows = XlUtilClass.getRowCount(dataFile, "Sheet1");
		int totalCols =  XlUtilClass.getCellCount(dataFile, "Sheet1", 1);
		
		String uservlues[][] = new String [totalRows][totalCols];
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				
				uservlues[i-1][j]	= XlUtilClass.getCellData(dataFile, "Sheet1", i, j);
			}
		}
		
		//String uservlues[][] = {{"yusuf","test"},{"khan","engg"},{"MY","arch"}, };
		
		return(uservlues);
	}
}
