package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {
		
		File csvFile = new File(System.getProperty("user.dir")+"\\TestData\\"+fileName);
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] data;
		//to fetch the user into list
		List<User> usersList = new ArrayList<User>();
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext(); // this reads the row no. 1 which is a column header row(we skip it)
			//data = csvReader.readNext(); // this reads the row no. 2 --> actual test data hence, we save rows from here
			
			// if there is no row or we have reached end of file, readNext() gives null result
			//declare USer 
			User user;
			while((data = csvReader.readNext()) != null) {
				user = new User(data[0], data[1]);
				usersList.add(user);
			}
			
			for (User userData : usersList) {
				System.out.println(userData);
			}
			System.out.println(Arrays.toString(data));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersList.iterator();
	}

}
