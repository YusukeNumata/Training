package yusuke.numata.datacleansing;

import java.util.HashMap;

public class DataCleansing {

	/**
	 * 文字列を整形する.
	 * 置換毎にStringが生成されるので、遅い.
	 * @param param
	 * @return
	 */
	public static String execute(String param) {
		param = param.replace("ァ", "ア");
		param = param.replace("ィ", "イ");
		param = param.replace("ゥ", "ウ");
		param = param.replace("ェ", "エ");
		param = param.replace("ォ", "オ");
		param = param.replace("ｱ", "ア");
		param = param.replace("ｲ", "イ");
		param = param.replace("ｳ", "ウ");
		param = param.replace("ｴ", "エ");
		param = param.replace("ｵ", "オ");
		return param;
	}

	private static HashMap<Character, Character> replaceMap;

	static {
		replaceMap = new HashMap<Character, Character>();
		replaceMap.put('ァ', 'ア');
		replaceMap.put('ィ', 'イ');
		replaceMap.put('ゥ', 'ウ');
		replaceMap.put('ェ', 'エ');
		replaceMap.put('ォ', 'オ');
		replaceMap.put('ｱ', 'ア');
		replaceMap.put('ｲ', 'イ');
		replaceMap.put('ｳ', 'ウ');
		replaceMap.put('ｴ', 'エ');
		replaceMap.put('ｵ', 'オ');
	}

	/**
	 * 文字列を整形する.
	 * いったん、char[]に変換して動作するのである程度早いはず！
	 * @param param
	 * @return
	 */
	public static String executeFast(String param) {
		char[] chars = param.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			Character ch = replaceMap.get(chars[i]);
			if (ch != null) {
				chars[i] = ch;
			}
		}
		return new String(chars);
	}
}
