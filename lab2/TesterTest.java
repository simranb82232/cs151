package lab1;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TesterTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int[] a = new int[] { 5, 4, 1, 9, 2, 6 };
		Arrays.swapLargestAndSmallest(a);
		assertEquals(a[2], 9);
		assertEquals(a[3], 1);
		
		 a = new int[] {1, 4, 1, 9, 2, 6};
	     Arrays.swapLargestAndSmallest(a);
	     assertEquals(a[0], 9);
		 assertEquals(a[3], 1);
		 
		 a = new int[] {1, 4, 2, 9, 9, 6};
	     Arrays.swapLargestAndSmallest(a);
	     assertEquals(a[0], 9);
		 assertEquals(a[3], 1);
		 
		 a = new int[] {1};
	     Arrays.swapLargestAndSmallest(a);
	     assertEquals(a[0], 1);
	     
	}

}
