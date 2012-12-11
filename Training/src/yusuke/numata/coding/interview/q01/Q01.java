package yusuke.numata.coding.interview.q01;

import java.util.Set;

public class Q01 {

	public boolean isUnice(String str) {
		Char[] chr = str.toChars();
		Set s = new Set();
		for (Char c : chr) {
			boolean b = s.contains(c);
			if (b) {
				return false;
			} else {
				s.set(c);
			}
		}
		return true;
	}
}
