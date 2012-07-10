package yusuke.numata.datacleansing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import yusuke.numata.datacleansing.DataCleansing;

public class DataCleansingTest {

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
		assertEquals("ア", DataCleansing.execute("ァ"));
		assertEquals("イ", DataCleansing.execute("ィ"));
		assertEquals("アイウエオアイウエオ", DataCleansing.execute("ァィゥェォｱｲｳｴｵ"));
	}

	@Test
	public void testExecute() {
		for(int i = 0; i < 100000; i++) {
			assertEquals("アイウエオアイウエオ", DataCleansing.execute("ァィゥェォｱｲｳｴｵ"));
		}
	}

	@Test
	public void testExecuteFast() {
		for(int i = 0; i < 100000; i++) {
			assertEquals("アイウエオアイウエオ", DataCleansing.executeFast("ァィゥェォｱｲｳｴｵ"));
		}
	}
}
