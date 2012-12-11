package yusuke.numata.coding.interview.q01;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Q01Test {

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
	public void testIsUnice() {
		Q01 q = new Q01();
		assertThat(q.isUnice("a"),   is(true));
		assertThat(q.isUnice("aa"),  is(false));
		assertThat(q.isUnice("ab"),  is(true));
		assertThat(q.isUnice("abc"), is(true));
		assertThat(q.isUnice("abca"), is(false));
		assertThat(q.isUnice("ああ"), is(false));
	}

	@Test(timeout=1000)
	public void testIsUnice負荷テスト() {
		for (int i = 0; i < 1000000; i++) {
			Q01 q = new Q01();
			boolean actual = q.isUnice("アダムスbcde");
			assertThat(actual, is(true));
		}
	}
}
