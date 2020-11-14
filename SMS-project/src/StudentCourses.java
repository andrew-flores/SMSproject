import java.util.Scanner;

public class StudentCourses {
	private String courses = "";
	private int tuitionBalance = 0;
	private int costOfCourse = 200;
	
	//Constructor
	public StudentCourses() {
		Scanner console = new Scanner(System.in);
		
	}
	//Enroll Student in class and update tuition 
	public void enroll() {
		do {
			Scanner console = new Scanner(System.in);
			System.out.print("Enter a course to enroll in (enter quit to exit): ");
			String course = console.nextLine();
			if(!course.equals("quit")) {
				courses = courses + "\n" + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			}else {break;}
		}while (1 != 0);
		
		System.out.println("Enrolled in: " + courses);
		System.out.println("Tuition Balance: " + tuitionBalance);
	}
}
