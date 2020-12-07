package simpli_calc;
import java.util.Scanner;

public class SimpliCalc {

	public static float addition(float a, float b) {
		return a+b;
	}
	public static float subtraction(float a, float b) {
		return a-b;
	}
	public static float multiplication(float a, float b) {
		return a*b;
	}
	public static float division(float a, float b) {
		return a/b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		System.out.println("Please enter 1 or Add for addition");
		System.out.println("Please enter 2 or Subtract for subtraction");
		System.out.println("Please enter 3 or Multiply for multiplication");
		System.out.println("Please enter 4 or Divide for division");
		System.out.println("Please enter 5 or Exit to exit");
		Scanner userInput = new Scanner(System.in);
		System.out.print("Your response: ");
		String choice = userInput.next();
		float xInput, yInput;
		switch(choice) {
			case "1":
			case "add":
			case "Add":
				System.out.print("Please enter two numbers: ");
				xInput = userInput.nextFloat();
				yInput = userInput.nextFloat();
				System.out.println("Answer is: " + addition(xInput, yInput));
				break;
			case "2":
			case "subtract":
			case "Subtract":
				System.out.print("Please enter two numbers: ");
				xInput = userInput.nextFloat();
				yInput = userInput.nextFloat();
				System.out.println("Answer is: " + subtraction(xInput, yInput));
				break;
			case "3":
			case "multiply":
			case "Multiply":
				System.out.print("Please enter two numbers: ");
				xInput = userInput.nextFloat();
				yInput = userInput.nextFloat();
				System.out.println("Answer is: " + multiplication(xInput, yInput));
				break;
			case "4":
			case "divide":
			case "Divide":
				System.out.print("Please enter two numbers: ");
				xInput = userInput.nextFloat();
				yInput = userInput.nextFloat();
				System.out.println("Answer is: " + division(xInput, yInput));
				break;
			case "5":
			case "Exit":
				System.out.print("You have chosen to exit");
				break;
			default:
				System.out.print("You have chosen to exit");
		}
	}

}
