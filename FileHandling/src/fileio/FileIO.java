package fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
	static List<Employee> empList = new ArrayList<Employee>();
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter 1 to do Employee data entry manually");
		System.out.println("Please enter 2 to read Employee data from data.txt file");
		System.out.println("Please enter 3 to exit");
		String choice = input.next();
		
		switch (choice) {
		case "1":
			do {
				Employee emp = new Employee();
				System.out.print("Please enter Employee ID: ");
				emp.setId(Integer.parseInt(input.next()));
				System.out.print("Please enter Employee name: ");
				emp.setName(input.next());
				System.out.print("Please enter Employee role: ");
				emp.setRole(input.next());
				empList.add(emp);
//				System.out.println(empList);
				System.out.print("Please enter your choice: ");
				choice = input.next();
			} while (choice.equalsIgnoreCase("3") == false);
			FileOutputStream fout = new FileOutputStream("empdata.txt");
			ObjectOutputStream objOut = new ObjectOutputStream(fout);
			objOut.writeObject(empList);
			break;
		
		case "2":
			File file = new File("data.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = br.readLine()) != null) {
				String[] val = line.split(",");
				Employee emp = new Employee(Integer.parseInt(val[0]), val[1], val[2]);
				empList.add(emp);
			}
			System.out.println(empList);
			break;
		
		case "3":
			System.out.println("You chose to exit");
			break;
		default:
			System.out.println("You chose to exit");
		}

	}

}
