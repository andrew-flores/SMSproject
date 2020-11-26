import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Student {
	
	private String first;
	private String last;
	private String username;
	private String password;
	private double GPA;
	private double totalBalance;
	
	/*public Student(String first, String last) {
		this.first = first;
		this.last = last;
		
		Random random = new Random();
		int num = random.nextInt(90) + 10;
		this.username = first + last.substring(0,1) + num;
	}*/
	
	public Student(int index) {
		if (index < 0)
			throw new IllegalArgumentException();
		
		File file1 = new File("names.txt");
		File file2 = new File("crdntl.csv");
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
			
			// gauto generate username 
			// write username to an external file (.csv or .txt)
			
			i = 0;
			s = new Scanner(file2).useDelimiter(",|\\s");
			while (s.hasNextLine()) {
				if (i == index) {
					this.username = s.next();
					this.password = s.next();
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
	
	public String getUsername() {
		return this.username;
	}
	/*
	public static void setUsername(Student student) {
		firstName = student.getFirst();
		lastName = student.getLast();

		// username = first name + first letter of last name + 2 random numbers
		Random random = new Random();
		int num = random.nextInt(90) + 10;
		student.setUsername(firstName + lastName.substring(0, 1) + num);
		System.out.println("UserName: " + student.getUsername());
	}*/
}
