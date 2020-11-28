import java.util.*;

/**
 * Program Preamble: Lorem Ipsum
 * @author Team
 *
 */
public class Sms {
	private static final int MAX_ATTEMPT = 5; // maximum attempt allowed for login

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);

		System.out.print("Are you a new student? (YES/NO) >_ ");
		String newstudent = s.next();
		if (newstudent.equalsIgnoreCase("yes") | newstudent.equalsIgnoreCase("y")) {		// for new students
			// call AddStudent method
			AddStudent.addStudentRun();
			
		} else {		// for existing students
			try {
				if (Authenticate.run(s) == MAX_ATTEMPT)
					throw new Exception();

				Student student = new Student(Authenticate.getIndex());

				// menu goes here
				System.out.println("Welcome, " + student.getFirst());
				menu(s, student);
				System.out.println("Goodbye, " + student.getFirst());
				System.out.println("\n==========================================================");
			} catch (Exception e) {
				// I'm bored do whatever here I guess idc sry if it lags your system
				System.out.println("=====*** Authentication Timeout ***=====");
			}
		}
	}

	/**
	 * This method runs the menu option in a loop until the user wants to log off
	 * @param s Scanner for user input
	 */
	public static void menu(Scanner s, Student student) {
		boolean exit = false; // exit flag to log off
		while (!exit) {
			System.out.println("---------------------------------------------");
			System.out.println("Please select a menu option:");
			System.out.println("1) View GPA");
			System.out.println("2) Add courses");
			System.out.println("3) View courses");
			System.out.println("4) Account inquiry");
			System.out.println("q) Logout");
			System.out.print(">_ ");

			String menu_input = s.next();
			switch (menu_input) { 	// method calls down here
			case "1": 
				System.out.println(student.getFirst() + " " + student.getLast() 
										+ "'s GPA: " + student.getGPA());
				break;
			case "2": Fees.enroll();
				break;
			case "3": System.out.println("Your class(es): \n" + Fees.getCourses());
				break;
			case "4": Fees.viewAndPayBalance();
				break;
			case "q":
			case "Q":
				System.out.println("Are you sure you want to log out? (YES/NO) "); // confirm log off
				System.out.print(">_ ");
				String confirm = s.next();
				if (confirm.equalsIgnoreCase("YES")) {
					exit = true; // raise flag
					System.out.println("Logging you out now...");
				}
				break;
			default:
				System.out.println("ERROR! Please enter a correct option."); // show error for every other input
			}
		}
	}
}