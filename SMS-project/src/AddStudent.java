import java.util.Random;
import java.util.Scanner;

public class AddStudent {

	private static String firstName;
	private static String lastName;
	private static String userName;
	private static String password;
	private static String studentType;
	private static int gpa;
	private static String specialChars = "!@#$%^&*().";
	
	/**
	 * This method generates login username based on user's first name followed by first letter of 
	   last name followed by 2 random numbers
	 * @return automatically generated username
	 */
	public static String getUserInfo() {
		// student enters first name and last name
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter First Name: ");
		firstName = kb.nextLine();
		System.out.print("Enter Last Name: ");
		lastName = kb.nextLine();

		// username = first name + first letter of last name + 2 random numbers
		Random random = new Random();
		int num = random.nextInt(90) + 10;
		userName = firstName + lastName.substring(0, 1) + num;
		System.out.println("UserName: " + userName);

		return userName;
	}
	
	/**
	 * This method verifies that the password entered by the user meets the minimum 
	   requirements of at least 8 characters long including at least 1 uppercase, 
	   1 lowercase, 1 number and 1 special character
	 * @return user generated password
	 */
	private static String verifyPassword() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter Your Password: ");
		password = kb.nextLine();

		char currentChar;
		
		boolean hasDigit = false;
		boolean hasLower = false;
		boolean hasUpper = false;
		boolean hasSpecialChar = false;
		boolean hasSpace = false;

		if (password.length() < 8) {
			System.out.print("Oops! Your password is less than 8 characters.");
			return verifyPassword();
		}

		for (int i = 0; !hasSpace && i < password.length(); i++) {
			currentChar = password.charAt(i);
			if (!hasDigit && Character.isDigit(currentChar))
				hasDigit = true;
			if (!hasLower && Character.isLowerCase(currentChar))
				hasLower = true;
			if (!hasUpper && Character.isUpperCase(currentChar))
				hasUpper = true;
			if (currentChar == ' ')
				hasSpace = true;
			if (!hasSpecialChar && specialChars.indexOf(currentChar) != -1)
				hasSpecialChar = true;
		}

		System.out.println("Password: " + password);

		if (hasDigit && hasLower && hasUpper && hasSpecialChar && !hasSpace)
			return password;
		else {
			System.out.println(
					"Oops! You are not meeting the password requirement of 1 uppercase letter, "
					+ "1 lowercase letter, 1 number, 1 special character, and a minimum of 8 characters. "
					+ "Please enter a new password.");
			verifyPassword();
		}

		return password;
	}

	/**
	 * This method gets the GPA of a transfer student and displays no GPA if the user 
	   is a new student
	 * @return GPA of transfer student 
	 */
	public static double getGPA() {
		Scanner kb = new Scanner(System.in);
		System.out.print(
				"Are you a new student or a transfer student? Enter 'N' for new student and 'T' for transfer student: ");
		studentType = kb.nextLine();

		if (studentType.equalsIgnoreCase("N")) {
			System.out.println("GPA is unavailabe. ");
		} else if (studentType.equalsIgnoreCase("T")) {
			// Transfer Student GPA
			double min = 2.0;
			double max = 4.0;
			Random r = new Random();
			System.out.println("Your GPA is " + (r.nextInt((int) ((max - min) * 10 + 1)) + min * 10) / 10.0);
		} else {
			System.out.println("Invalid input! Please enter 'N' or 'T'. ");
			getGPA();
		}
		return gpa;
	}
	
	/* This method tests all methods */
	public static void addStudentRun() {
		getUserInfo();
		verifyPassword();
		getGPA();
	}
}