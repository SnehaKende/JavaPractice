package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelUtility;

public class LoginDataProvider {

	//Dataproviders return type can be
	//Object[] - object single dimensional array
	//object[][] - object two-dimensional array
	//Iterator
	@DataProvider(name = "LoginTestDataProvider")
	public static Iterator<Object[]> loginDataProvider() {
		
		Gson gson = new Gson();
		File dataFile = new File(System.getProperty("user.dir")+"\\TestData\\LoginData.json");
		FileReader reader = null;
		try {
			reader = new FileReader(dataFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestData data = gson.fromJson(reader, TestData.class); //deserialization --> creating java object from json filedata
		
		List<Object[]> users;
		users = new ArrayList<Object[]>();
		for(User user: data.getData()) {
			users.add(new Object[] {user});
		}
		
		return users.iterator();
		
	}
	
	@DataProvider(name = "LoginwithCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.readCSVFile("LoginData.csv");
	}
	
	@DataProvider(name = "LoginwithExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() {
		return ExcelUtility.readExcel("LoginData.xlsx");
	}
}
