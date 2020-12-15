package com.lockers.scanner;

import java.io.IOException;
import java.util.Scanner;

import com.lockers.choices.*;

public class UserInp {
	public static void main(String[] args) throws IOException {
		System.out.println("###############################################");
		System.out.println("Welcome to LockedMe file management system");
		System.out.println("brought to you by Shreyarth Bhatt");
		System.out.println("###############################################");
		System.out.println();
		ChoiceOuter co = new ChoiceOuter();
		ChoiceInner ci = new ChoiceInner();
		optionsSelection(co, ci);
	}

	private static void optionsSelection(ChoiceOuter co, ChoiceInner ci) throws IOException {
		String[] arr = { "1. I wish to review existing files", "2. I wish to add/delete/lookup files",
				"3. Close the application" };
		int[] arr1 = { 1, 2, 3 };
		int slen = arr1.length;
		System.out.println();
		for (int i = 0; i < slen; i++) {
			System.out.println(arr[i]);
			// display the all the Strings mentioned in the String array
		}
		System.out.println("\nEnter your choice:\t");
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(System.getProperty("line.separator"));
		int options = sc.nextInt();
		switch (options) {
		case 1:
			System.out.println("Please enter the path you would like to review the files of: \n");
			String path = sc.next();
			co.Search(path);
			optionsSelection(co, ci);
			break;
		case 2:
			System.out.println("1. I  wish to add a file to a directory");
			System.out.println("2. I wish to delete a file from a directory");
			System.out.println("3. I wish to search a file in a directory");
			System.out.println("4. I wish to exit");
			int optionsInner = sc.nextInt();
			do {
				System.out.println("");
				switch(optionsInner) {
				case 1:
					System.out.println("Please enter the DIRECTORY followed by the FILENAME and EXTENSION you would like to add to:  ");
					String pathInner = sc.next();
					ci.Add(pathInner);
					System.out.println("Enter your choice again");
					optionsInner = sc.nextInt();
					break;
				case 2:
					System.out.println("Please enter the DIRECTORY followed by the FILENAME and EXTENSION you would like to delete:  ");
					pathInner = sc.next();
					ci.Delete(pathInner);
					System.out.println("Enter your choice again");
					optionsInner = sc.nextInt();
					break;
				case 3:
					System.out.println("Please enter the filename with its exntension that you wish to look for: ");
					pathInner = sc.next();
					System.out.println(ci.Search(pathInner));
					System.out.println("Enter your choice again");
					optionsInner = sc.nextInt();
					break;
				case 4:
					System.out.println("You have chosen to exit this loop...");
					break;
				default:
					System.out.println("Invalid choice...Please try again");
					System.out.println("Enter your choice again");
					optionsInner = sc.nextInt();
					break;
				}
			}while(optionsInner != 4);
			optionsSelection(co, ci);
			break;
		case 3:
			closeApp();
			break;
		default:
			System.out.println("Invalid choice!...Please try again");
			optionsSelection(co, ci);
			break;
		}
	}

	private static void closeApp() {
		System.out.println("Closing your application... \nThank you!");
	}
}