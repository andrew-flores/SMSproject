import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Authenticate {
	/* SUBJECT TO CHANGE
	 * Usernames and passwords should be taken from a database 
	 * aka some kind of external file such as .txt or .csv
	 */
	private static final int MAX_ATTEMPT = 5;
	private static int index = 0;
	
	/**
	 * This method prompts the user for username input
	 * @param s Scanner to get input
	 * @return user-entered username
	 */
	private static String getUser(Scanner s) {
		System.out.print("Username: ");
		String enter_username = s.nextLine();
		
		return enter_username;
	}
	
	/**
	 * This method prompts the user for password input
	 * @param s Scanner to get input
	 * @return user-entered password
	 */
	private static String getPassword(Scanner s) {
		System.out.print("Password: ");
		String enter_password = s.nextLine();
		
		return enter_password;
	}
	
	/**
	 * This method verifies username and password
	 * @param user user-entered username
	 * @param pass user-entered password
	 * @return if the user-entered credential is valid or not 
	 */
	private static boolean verify(String user, String pass) {
		String input = user + "," + pass; // username,password
		// read from file
		File myObj = new File("crdntl.csv");
		Scanner s;
		try {
			s = new Scanner(myObj);
			while (s.hasNext()) {
				if (s.next().equals(input))	
					return true;
				
				index++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred: data not found");
			e.printStackTrace();
		}

		return false;
	}
	
	public static int getIndex() {
		return index;
	}
	
	/**
	 * This method utilizes the above methods to run an authentication process
	 * @param s Scanner to get input
	 * @return number of login attempts made
	 */
	public static int run(Scanner s) {
		String user = getUser(s);
		String pass = getPassword(s);
		int attempt = 1;
		
		while(!verify(user,pass)) {			// if wrong credential , enter again
			System.out.println("Incorrect username/password. Please try again...\n");
			index = 0;
			user = getUser(s);
			pass = getPassword(s);
			attempt++;
			if (attempt == MAX_ATTEMPT)		// exit when maximum number of attempts reached 
				break;
		}
		
		return attempt;
	}
}