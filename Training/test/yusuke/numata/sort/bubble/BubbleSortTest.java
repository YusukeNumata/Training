package yusuke.numata.sort.bubble;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BubbleSortTest {

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
		assertEquals("1,1"    , BubbleSort.execute("1,1"));
		assertEquals("1,2"    , BubbleSort.execute("1,2"));
		assertEquals("1,2"    , BubbleSort.execute("2,1"));
		assertEquals("1,2,3"  , BubbleSort.execute("2,1,3"));
		assertEquals("1,2,3,4", BubbleSort.execute("4,3,2,1"));
		assertEquals("1,1,1,5", BubbleSort.execute("1,1,5,1"));
		assertEquals("-1,0,1" , BubbleSort.execute("-1,0,1"));
		assertEquals("-1,0,1" , BubbleSort.execute("1,-1,0"));
		
		assertEquals("a,e,z"  , BubbleSort.execute("z,e,a"));
		
	}
}
