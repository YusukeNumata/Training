package yusuke.numata.csv.try1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class CSVUtil {

	private File file;

	/**
	 * ファイルをロードする.
	 * @param filePath
	 */
	void load(String filePath) {
		File file = new File(filePath);
		this.file = file;
	}

	/**
	 * ファイルの存在を確認する.
	 * @return true:存在する
	 */
	boolean exists() {
		return file.exists();
	}

	/**
	 * ファイルに引数の文字列を追加書込みする.
	 * @param param
	 */
	void write(String param) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(this.file, true));
			bw.write(param);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ファイルの中身を標準出力する.
	 */
	void display() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(this.file));

			String line = "";
			while ((line = br.readLine()) != null) {

				StringTokenizer st = new StringTokenizer(line, ",");

				while (st.hasMoreTokens()) {
					System.out.print(st.nextToken() + "\t");
				}
				System.out.println();
			}

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
