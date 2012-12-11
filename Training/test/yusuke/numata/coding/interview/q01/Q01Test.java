package yusuke.numata.coding.interview.q01;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class Q01Test {

	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() throws Exception {
		System.out.println("start:" + Runtime.getRuntime().freeMemory() + " " + name.getMethodName());
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("end  :" + Runtime.getRuntime().freeMemory() + " " + name.getMethodName());
	}

	@Test
	public void testIsUnique() {
		Q01 q = new Q01();
		assertThat(q.isUnique("a"),   is(true));
		assertThat(q.isUnique("aa"),  is(false));
		assertThat(q.isUnique("ab"),  is(true));
		assertThat(q.isUnique("abc"), is(true));
		assertThat(q.isUnique("abca"), is(false));
		assertThat(q.isUnique("ああ"), is(false));
	}
	
	@Test
	public void testIsUniceChars() {
		Q01 q = new Q01();
		assertThat(q.isUniqueChars("a"),   is(true));
		assertThat(q.isUniqueChars("aa"),  is(false));
		assertThat(q.isUniqueChars("ab"),  is(true));
		assertThat(q.isUniqueChars("abc"), is(true));
		assertThat(q.isUniqueChars("abca"), is(false));
	}
	
	@Test
	public void testIsUniceChars2() {
		Q01 q = new Q01();
		assertThat(q.isUniqueChars2("a"),   is(true));
		assertThat(q.isUniqueChars2("aa"),  is(false));
		assertThat(q.isUniqueChars2("ab"),  is(true));
		assertThat(q.isUniqueChars2("abc"), is(true));
		assertThat(q.isUniqueChars2("abca"), is(false));
	}

	@Test(timeout=1000)
	public void testIsUnique負荷テスト() {
		for (int i = 0; i < 1000000; i++) {
			Q01 q = new Q01();
			boolean actual = q.isUnique("アダムスbcde");
			assertThat(actual, is(true));
		}
	}
	
	@Test(timeout=1000)
	public void testIsUniqueChar負荷テスト() {
		for (int i = 0; i < 1000000; i++) {
			Q01 q = new Q01();
			boolean actual = q.isUniqueChars("abcdefghijk");
			assertThat(actual, is(true));
		}
	}
	
	@Test(timeout=1000)
	public void testIsUniqueChars2負荷テスト() {
		for (int i = 0; i < 1000000; i++) {
			Q01 q = new Q01();
			boolean actual = q.isUniqueChars2("abcdefghijk");
			assertThat(actual, is(true));
		}
	}
}
