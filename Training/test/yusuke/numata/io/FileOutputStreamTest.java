package yusuke.numata.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileOutputStreamTest {

	/** テストで使用するファイルの名称 */
	private static final String TEST_FILE_NAME = "test.csv";

	@Before
	public void setUp() throws Exception {
		new File(TEST_FILE_NAME).delete();
	}

	@After
	public void tearDown() throws Exception {
		consoleFileData(TEST_FILE_NAME);
	}

	@Test
	public void test単一行の出力() throws Exception {
		FileOutputStream out = new FileOutputStream(TEST_FILE_NAME);
		out.write("test".getBytes());
		out.flush();
		out.close();
	}

	@Test
	public void test複数行の出力() throws Exception {
		FileOutputStream out = new FileOutputStream(TEST_FILE_NAME);
		out.write("test".getBytes());
		out.write("\r\n".getBytes());
		out.write("test".getBytes());
		out.flush();
		out.close();
	}

	private String consoleFileData(String fileName) throws FileNotFoundException, IOException {

		StringBuilder strbuild = new StringBuilder();

		FileInputStream in = new FileInputStream(fileName);
		int size = -1;
		while ((size = in.read()) != -1) {
			System.out.print((char)size);
			strbuild.append((char)size);
		}
		in.close();
		System.out.println();
		return strbuild.toString();
	}

}
