package yusuke.numata.coding.interview.q01;

import java.util.HashSet;
import java.util.Set;

/**
 * Chapter 1 配列と文字列 問題1.1
 * @author yusuke
 */
public class Q01 {

	/**
	 * ある文字列がすべてユニークである(重複する文字がない)かどうか判定する.
	 * @param str 文字列
	 * @return true:すべてユニーク、false:重複文字あり
	 */
	public boolean isUnique(String str) {
		char[] chr = str.toCharArray();
		Set<Character> s = new HashSet<Character>();
		for (char c : chr) {
			boolean b = s.contains(c);
			if (b) {
				return false;
			} else {
				s.add((Character) c);
			}
		}
		return true;
	}

	/**
	 * 本の解答１.
	 * <p>ただし、アルファベットの小文字限定.
	 * <p>ビットベクトルを用いて消費メモリを<code>isUniqueChars2</code>の8分の1に抑える
	 * @param str 文字列(アルファベット小文字限定)
	 * @return true:すべてユニーク、false:重複文字あり
	 */
	public boolean isUniqueChars(String str) {
		if (str.length() > 256)
			return false;
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

	/**
	 * 本の解答2.
	 * <p>ただし、文字の種類が256しかない前提.
	 * @param str 文字列
	 * @return true:すべてユニーク、false:重複文字あり
	 */
	public boolean isUniqueChars2(String str) {
		if (str.length() > 256)
			return false;
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val])		// この文字がすでに文字列中で現れている
				return false;
			char_set[val] = true;
		}
		return true;
	}
}
