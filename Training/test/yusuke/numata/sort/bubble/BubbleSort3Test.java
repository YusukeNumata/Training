package yusuke.numata.sort.bubble;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BubbleSort3Test {

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
		assertArrayEquals($("a"        ), BubbleSort3.execute($("a"        )));
		assertArrayEquals($("a","b"    ), BubbleSort3.execute($("b","a"    )));
		assertArrayEquals($("a","b","c"), BubbleSort3.execute($("c","b","a")));
		assertArrayEquals($("a","b","c"), BubbleSort3.execute($("c","a","b")));
	}

	/**
	 * 設定した引数の状態で、配列を作成する.
	 * @param params
	 * @return
	 */
	private String[] $(String... params) {
		String[] rtn = new String[params.length];
		for (int i = 0; i < params.length; i++) {
			rtn[i] = params[i];
		}
		return rtn;
	}
}
