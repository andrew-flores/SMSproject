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
	private String GPA;
	private File file1 = new File("names.txt");
	private File file2 = new File("crdntl.txt");
	public Student(int index) {
		if (index < 0)
			throw new IllegalArgumentException();
		
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
		
			i = 0;
			s = new Scanner(file2).useDelimiter(",|\\s");
			while (s.hasNextLine()) {
				if (i == index) {
					this.username = s.next();
					s.next();
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
