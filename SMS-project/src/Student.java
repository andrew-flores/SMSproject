import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author trank
 *
 */
public class Student {
	private String first;
	private String last;	
	private String username;	
	private String password;
	private String GPA;
	private double totalBalance;
	
	public Student(int index) {
		if (index < 0)
			throw new IllegalArgumentException();
		
		File file1 = new File("names.txt");
		File file2 = new File("crdntl.txt");
		Scanner s;
		
		try {
			s = new Scanner(file1);
			int i = 0;
			
			while (s.hasNextLine()) {
				if (i == index) {
					this.first = s.next();
					this.last = s.next();
					break;
				} else
					s.nextLine();
				
				i++;
			}
			
			// auto generate username 
			// write username to an external file (.csv or .txt)
			
			i = 0;
			s = new Scanner(file2).useDelimiter(",|\\s");
			while (s.hasNextLine()) {
				if (i == index) {
					this.username = s.next();
					this.password = s.next();
					this.GPA = s.next();
					break;
				} else
					s.nextLine();
				
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred: data not found");
			e.printStackTrace();
		}
	}
	
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
