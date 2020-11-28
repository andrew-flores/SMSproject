import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SmsTest {

	@Test
	void GetFirstTest() {
		Student student1 = new Student(0);
		Student student2 = new Student(1);
		Student student3 = new Student(2);
		Student student4 = new Student(3);
		Student student5 = new Student(4);
		Student student6 = new Student(5);
		
		assertEquals("Tamzin", student1.getFirst());
		assertEquals("Martin", student2.getFirst());
		assertEquals("Jenny", student3.getFirst());
		assertEquals("Zeeshan", student4.getFirst());
		assertEquals("Alfie-Lee", student5.getFirst());
		assertEquals("Ernest", student6.getFirst());
	}
	
	@Test
	void GetLastTest() {
		Student student1 = new Student(0);
		Student student2 = new Student(1);
		Student student3 = new Student(2);
		Student student4 = new Student(3);
		Student student5 = new Student(4);
		Student student6 = new Student(5);
		
		assertEquals("Tierney", student1.getLast());
		assertEquals("Head", student2.getLast());
		assertEquals("Sutherland", student3.getLast());
		assertEquals("Bevan", student4.getLast());
		assertEquals("Castillo", student5.getLast());
		assertEquals("Leigh", student6.getLast());
	}
	
	@Test
	void GetUsernameTest() {
		Student student1 = new Student(0);
		Student student2 = new Student(1);
		Student student3 = new Student(2);
		Student student4 = new Student(3);
		Student student5 = new Student(4);
		Student student6 = new Student(5);
		
		assertEquals("TamzinT92", student1.getUsername());
		assertEquals("MartinH40", student2.getUsername());
		assertEquals("JennyS31", student3.getUsername());
		assertEquals("ZeeshanB33", student4.getUsername());
		assertEquals("Alfie-LeeC87", student5.getUsername());
		assertEquals("ErnestL95", student6.getUsername());
	}
	
	@Test
	void GetGPATest() {
		Student student1 = new Student(0);
		Student student2 = new Student(1);
		Student student3 = new Student(2);
		Student student4 = new Student(3);
		Student student5 = new Student(4);
		Student student6 = new Student(5);
		
		assertEquals("3.607", student1.getGPA());
		assertEquals("2.963", student2.getGPA());
		assertEquals("3.555", student3.getGPA());
		assertEquals("1.666", student4.getGPA());
		assertEquals("2.987", student5.getGPA());
		assertEquals("2.006", student6.getGPA());
	}
	
	@Test
	public void constructor_StudentIndex() { 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Student student = new Student(-4);
		  });
	} 
}
