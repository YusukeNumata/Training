package yusuke.numata.io;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.Test;

public class ZipOutputStreamTest {

	@Test
	public void test() throws Exception {

		ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream("test.zip"));
		ZipEntry entry = new ZipEntry("test.csv");
		zipout.putNextEntry(entry);

		FileInputStream in = new FileInputStream("test.csv");
		int size = -1;
		while ((size = in.read()) != -1) {
			zipout.write(size);
		}
		in.close();

		zipout.closeEntry();
		zipout.close();
	}

	@Test
	public void test文字列の場合() throws Exception {

		ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream("test.zip"));
		ZipEntry entry = new ZipEntry("test.csv");
		zipout.putNextEntry(entry);

		zipout.write("test".getBytes());
		zipout.write("numata".getBytes());

		zipout.closeEntry();
		zipout.close();
	}

}
