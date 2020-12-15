package com.lockers.choices;

import java.io.File;
import java.util.Arrays;

public class ChoiceOuter {
		
	public void Search(String path) {
//		System.out.println("Please enter the directory you want to search");
		File file = new File(path);
		if(file.isDirectory()) {
			String[] fileNames = file.list();
			if(file.length() > 0) {
				Arrays.sort(fileNames);
				for(String name: fileNames) {
					System.out.println(name);
				}
			}
			else {
				System.out.println("Directory: " + file.getPath() + " is empty");
			}
			
		}
		else {
			System.out.println("Invalid entry...Please try again!");
		}
	}
	

	public void Exit() {
		System.out.println("You have chosen to exit. Goodbye!");
	}
}
