import java.util.Scanner;

public class Authenticate {
	/* SUBJECT TO CHANGE
	 * Usernames and passwords should be taken from a database 
	 * aka some kind of external file such as .txt or .csv
	 */
	private static final int MAX_ATTEMPT = 5;
	private static String username = "JohnWood";		
	private static String password = "H@xx0r_420";
	
	/**
	 * This method prompts the user for username input
	 * @param s Scanner to get input
	 * @return user-entered username
	 */
	public static String getUser(Scanner s) {
		System.out.print("Username: ");
		String enter_username = s.nextLine();
		
		return enter_username;
	}
	
	/**
	 * This method prompts the user for password input
	 * @param s Scanner to get input
	 * @return user-entered password
	 */
	public static String getPassword(Scanner s) {
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
	public static boolean verify(String user, String pass) {
		return user.equals(username) && pass.equals(password);
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
			user = getUser(s);
			pass = getPassword(s);
			attempt++;
			if (attempt == MAX_ATTEMPT)		// exit when maximum number of attempts reached 
				break;
		}
		
		return attempt;
	}
}