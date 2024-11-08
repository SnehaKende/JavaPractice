package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelUtility {

	public static Iterator<User> readExcel(String fileName) {
		
		File excelFile = new File(System.getProperty("user.dir")+"\\TestData\\"+fileName);
		FileReader fileReader = null;
		
		List<User> userList = new ArrayList<User>();
		Row row;
		Cell emailCell, passwordCell;
		User user;
		XSSFWorkbook workbook;
		XSSFSheet xssfSheet;
		Iterator<Row> iteratorRow;
		
		//XLSX file
		try {
			workbook = new XSSFWorkbook(excelFile);
			xssfSheet = workbook.getSheet("LoginTestData");
			iteratorRow = xssfSheet.iterator();
			iteratorRow.next();
			while(iteratorRow.hasNext()) {
				
				row = iteratorRow.next();
				
				emailCell = row.getCell(0);
				passwordCell = row.getCell(1);

				 user = new User(emailCell.toString(), passwordCell.toString());
				userList.add(user);
				workbook.close();
			}
			
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
return userList.iterator();
	}

}
