package emailvalidation;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public static final String REGEX = "^[A-Za-z0-9_.]+@[a-z.]+$";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> emailList = new ArrayList<String>();
		emailList.add("test1@email.com");
		emailList.add("test_2@email.com");
		emailList.add("test.3@email.com");
		emailList.add("test4@email.com");
		emailList.add("test5@email.com");
		emailList.add("test6@email.com");
		emailList.add("test7@email.com");
		emailList.add("test%8@email.com");
		emailList.add("test9@email.co.m");
		emailList.add("test10@e#mail.com");
		emailList.add("test1email.com");
		System.out.print("Please enter an email: ");
		Scanner input = new Scanner(System.in);
		String email = input.next();
		emailList.add(email);
		
		Pattern p = Pattern.compile(REGEX);
		for(String str: emailList) {
			Matcher matcher = p.matcher(str);
			System.out.println("The emailID: " + str + " is " + (matcher.matches() ? "valid" : "invalid"));
		}
	}

}
