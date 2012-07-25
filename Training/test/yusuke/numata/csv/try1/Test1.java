package yusuke.numata.csv.try1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void test_load() {
		CSVUtil csv = new CSVUtil();
		csv.load("./test/yusuke/numata/csv/try1/test1.csv");
		assertEquals(true,  csv.exists());
	}

	@Test
	public void test_write() {
		CSVUtil csv = new CSVUtil();
		csv.load("./test/yusuke/numata/csv/try1/test1.csv");
		csv.display();
		csv.write("aaa,bbb");
		csv.display();
	}
}
