package yusuke.numata.cmd.exist;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.Test;

public class ExistTest {


	@Before
	public void setUp() throws Exception {

	}


	@Test
	public void test() {
		String[] cmds = {"cmd.exe", "/c", "EXIST.bat"};
		try {
			ProcessBuilder pb = new ProcessBuilder(cmds);
			pb.redirectErrorStream(true);
			Process process = pb.start();
			InputStream in = null;
			BufferedReader br = null;

			in = process.getInputStream();
			br = new BufferedReader(new InputStreamReader(in, "MS932"));

			String stdout = "";
			while ((stdout = br.readLine()) != null) {
				System.out.println(stdout);
			}
			System.out.println("rtn=" + process.waitFor());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
