package yusuke.numata.coding.interview.q01;

import java.util.HashSet;
import java.util.Set;

public class Q01 {

	public boolean isUnice(String str) {
		char[] chr = str.toCharArray();
		Set s = new HashSet();
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
}
