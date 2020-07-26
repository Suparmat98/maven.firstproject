package maven.firstproject;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.*; 

public class AppTest {

	@Test
	public void Test()
	{
		boolean b1 = true;
		boolean b2 = true;
		
		assertEquals(b1, b2);
	}
}
