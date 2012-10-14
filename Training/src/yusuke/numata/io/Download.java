package yusuke.numata.io;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Download {

	public void start() throws Exception {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out, "Shift_JIS");
		osw.write("aiu");
		osw.write("eo");
		osw.close();

		ZipOutputStream zip = new ZipOutputStream(out);
		ZipEntry entry = new ZipEntry("test.csv");
		entry.setMethod(ZipOutputStream.DEFLATED);
		zip.putNextEntry(entry);

		byte[] b = out.toByteArray();
		zip.write(b, 0, b.length);
		zip.close();

	}

	public void start(OutputStream out) throws Exception {

		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(bout, "Shift_JIS");
		osw.write("aiu");
		osw.write("eo");
		osw.close();

		ZipOutputStream zip = new ZipOutputStream(out);
		ZipEntry entry = new ZipEntry("test.csv");
		entry.setMethod(ZipOutputStream.DEFLATED);
		zip.putNextEntry(entry);

		byte[] b = bout.toByteArray();
		zip.write(b, 0, b.length);
		zip.close();

	}
}
