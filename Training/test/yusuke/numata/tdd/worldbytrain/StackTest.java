package yusuke.numata.tdd.worldbytrain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StackTest {

	private Stack stack;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		stack = new Stack();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		assertThat(stack.isEmpty(), is(true));
	}

	@Test
	public void testPushAndTop() {
		stack.push(1);
		assertThat(stack.isEmpty(), is(false));
		assertThat(stack.top(), is(1));
	}

	@Test
	public void testPushAndSize() {
		stack.push(1);
		assertThat(stack.size(), is(1));
		stack.push(2);
		assertThat(stack.size(), is(2));
	}

	@Test(expected=EmptyStackException.class)
	public void testEmptyPop() {
		stack.pop();
	}
	
	@Test(expected=EmptyStackException.class)
	public void testEmptyTop() {
		stack.top();
	}

	@Test
	public void testPushAndPop() {
		stack.push(1);
		stack.pop();
		assertThat(stack.size(), is(0));
	}
	
	@Test
	public void testPushPushPopTop() {
		stack.push(1);
		stack.push(2);
		assertThat(stack.size(), is(2));
		stack.pop();
		assertThat(stack.top(), is(1));
	}
}
