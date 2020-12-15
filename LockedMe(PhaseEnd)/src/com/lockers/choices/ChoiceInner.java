package com.lockers.choices;

import java.io.File;
import java.io.IOException;

public class ChoiceInner {
	public void Add(String fileName) throws IOException {
//		System.out.println("Please enter the DIRECTORY followed by the FILENAME and EXTENSION you would like to add to:  ");
		File file = new File(fileName);
		file.createNewFile();
		System.out.println("Created: " + file.getName() + " at: " + file.getCanonicalPath());
	}
	
	public void Delete(String fileName) {
//		System.out.println("Please enter the DIRECTORY followed by the FILENAME and EXTENSION you would like to delete:  ");
		File file = new File(fileName);
		if(file.exists()) {
			file.delete();
			System.out.println("File Deleted");
		}
		else {
			System.out.println("File not found...try again");
		}
	}
	
	public String Search(String fileName) {
//		System.out.println("Please enter the filename with its exntension that you wish to look for: ");
		File file = new File(fileName);
//		System.out.println(file.exists());
		if(file.exists()) {
			System.out.println(file.getName());
			return "File Found";
		}
		else {
			return "File Not Found...Try again";
		}
	}
}
