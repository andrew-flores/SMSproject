import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Fees {
	private static double totalBalance; // stores student's outstanding balance for their tuition
	private static String courses = ""; // store's student's desired course to enroll in
	private static int costOfCourse = 200; // cost of each course offered at the university

	// getter and setter for total balance
	double getTotalBalance() {
		return totalBalance;
	}

	void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}
	
	//Singleton design pattern #2
	private static Fees instance = new Fees();

	private Fees() {
	}

	public static Fees getInstance() {
		return instance;
	}


	
	public static String getCourses() {
		return courses;
	}
	
	// Desgin pattern #1 (iterator)
	// This function adds courses to the array list, then iterates through the list and displays them
	public static void coursesAvailable()
	   {
		  //create an array list 
		  ArrayList<String> list = new ArrayList<String>();
	     
	      // adding courses to the list
	      list.add("Art,");
	      list.add("Computer Science,");
	      list.add("Dance,");
	      list.add("Forensic Science,");
	      list.add("Literature,");
	      list.add("Math,");
	      list.add("Physics,");
	      list.add("Tennis,");
	      list.add("Yoga");
	     
	      // Iterator to traverse the list
	      Iterator iterator = list.iterator();
	      System.out.println("List of Courses Available: ");
	     
	      //print courses
	      while (iterator.hasNext())
	            System.out.print(iterator.next() + " ");
	 
	        System.out.println();
	       
	   }
	
	
	// Function to enroll Student in class and update tuition
	public static void enroll() {
		coursesAvailable(); // calls the iterator that displays courses available
		Scanner console = new Scanner(System.in);
		do { // enrolls student in desired classes until they choose to quit
			System.out.print("Enter a course to enroll in (enter quit to exit): ");
			String course = console.nextLine();
			if (!course.equals("quit")) {
				courses = courses + "\n" + course; // update courses variable
				//totalBalance = totalBalance + costOfCourse; 
				// update student's total account balance
				//Strategy design pattern #3
				Context context = new Context(new OperationAdd());
				totalBalance = context.executeStrategy(totalBalance, costOfCourse);
				
			} else 
				break;

		} while (1 != 0);

		System.out.println("Enrolled in: " + courses); // prints student's enrolled courses
		System.out.println("Tuition Balance: $" + totalBalance); // prints studen't total account balance
	}

	// Function goes through payment process for paying total account balance
	public static void viewAndPayBalance() {
		boolean done = false;
		String answer;
		Scanner input = new Scanner(System.in);
		// loops through payment process until student decides to stop paying
		while (!done) {
			System.out.println("You have an outstanding balance of $" + String.format("%.2f", totalBalance)); // shows
																												// current
																												// outstanding
																												// balance
			// checks if student even has an outstanding balance
			if (totalBalance > 0) {
				System.out.println("Would you like to make payment? (y/n) "); // asks student if they would like to make
																				// a payment at this time
				answer = input.next();
				// if student answers yes, gather payment from student and update total account
				// balance
				if (answer.equals("y") || answer.equals("Y")) {
					System.out.println("How much would you like to pay at this time: ");
					double amountPaid = input.nextDouble(); // stores the amount student would like to pay
					if (amountPaid > totalBalance) // if student pays more than they owe, then displays error message
													// and student is taken to beginning of loop
						System.out.println(
								"Error: Cannot pay an amount greater than the total balance. Please try again.\n");
					else {
						//totalBalance = totalBalance - amountPaid; 
						// total balance is updated after student chooses valid payment amount
						//Strategy design pattern #3					
						Context  context = new Context(new OperationSubstract());
						totalBalance = context.executeStrategy(totalBalance, amountPaid);
						System.out.println("Thank you for submitting your payment!");
					}

				} else if (answer.equals("n") || answer.equals("N")) // if student answers no, exits loop and ends
																		// function ends
					done = true;
				else // if student inputs anything other than 'y' or 'n', error message displayed and
						// loop restarts
					System.out.println("Error: Please try again and enter either \"y\" or \"n\"");
			}
			// else if student does not currently have an outstanding balance
			else {
				System.out.println("You have no outstanding balance at this time.");
				done = true; // exits loop and ends function
			}
		}
	}
	//
	public static void studentAccountRun() {
		enroll();
		viewAndPayBalance();
	}
}