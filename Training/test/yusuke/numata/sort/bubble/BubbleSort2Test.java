package yusuke.numata.sort.bubble;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BubbleSort2Test {

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
	public void test1() {
		String[] actual   = {"b", "a"};
		String[] expected = {"a", "b"};
		assertArrayEquals(expected, BubbleSort2.execute(actual));
	}
	
	@Test
	public void test2() {
		String[] actual   = {"a"};
		String[] expected = {"a"};
		assertArrayEquals(expected, BubbleSort2.execute(actual));
	}
	
	@Test
	public void test3() {
		String[] actual   = {"b", "1", "a"};
		String[] expected = {"1", "a", "b"};
		assertArrayEquals(expected, BubbleSort2.execute(actual));
	}
	
	@Test
	public void test4() {
		String[] actual   = {"c", "b", "a"};
		String[] expected = {"a", "b", "c"};
		assertArrayEquals(expected, BubbleSort2.execute(actual));
	}
	
	@Test
	public void test5() {
		String[] actual   = {"c", "b", "a", "b"};
		String[] expected = {"a", "b", "b", "c"};
		assertArrayEquals(expected, BubbleSort2.execute(actual));
	}
	
}
