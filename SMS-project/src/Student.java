
public class Student {
	
	private String first;
	private String last;
	private double GPA;
	private String username;
	private String password;
	private double totalBalance;
	
	public Student(String first, String last) {
		this.first = first;
		this.last = last;
	}
	
	public String getFirst() {
		return this.first;
	}
	
	public String getLast() {
		return this.last;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
}
