import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FeesTest {

	@Test
	void feesTest() {
		Fees fees = Fees.getInstance();
		fees.enroll();
		
		String courses = fees.getCourses();
		assertEquals("\nMath\nArt", courses);
		
		double balance = fees.getTotalBalance();
		assertEquals(400, balance);
		
		fees.viewAndPayBalance();
		
	
		assertEquals(400, balance);
		
		double balanceAfter = fees.getTotalBalance();
		
		assertEquals(100, balanceAfter);
		
		double amountPaid = balance - balanceAfter;
		
		assertEquals(300, amountPaid);
		
		
	}

}
