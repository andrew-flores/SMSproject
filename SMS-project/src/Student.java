import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * This class handles the student object
 * @author Team Energy
 */
public class Student {
	private String first;
	private String last;	
	private String username;
	private String GPA;
	private File file1 = new File("names.txt");		// Students' names file
	private File file2 = new File("crdntl.txt");	// Students' credential/GPA file
	
	public Student(int index) {
		if (index < 0)
			throw new IllegalArgumentException();
		
		Scanner s;
		
		try {
			s = new Scanner(file1);		// read from name file
			int i = 0;
			while (s.hasNextLine()) {
				if (i == index) {	// if index is found, put first and last name into the fields
					this.first = s.next();	
					this.last = s.next();
					break;
				} else
					s.nextLine();	// else, move to the next line of the file
				
				i++;
			}
		
			s = new Scanner(file2).useDelimiter(",|\\s");	// read from credential file, parse fields separated by commas
			i = 0;
			while (s.hasNextLine()) {
				if (i == index) {	// if index is found, put username and GPA into the fields
					this.username = s.next();
					s.next();
					this.GPA = s.next();
					break;
				} else				// else, move to the next line of the file
					s.nextLine();
				
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred: data not found");
			e.printStackTrace();
		}
	}
	
	/**
	 * Getters for the Student's fields
	 */
	public String getFirst() {
		return this.first;
	}
	
	public String getLast() {
		return this.last;
	}
	
	public String getGPA() {
		return this.GPA;
	}
	
	public String getUsername() {
		return this.username;
	}
}
