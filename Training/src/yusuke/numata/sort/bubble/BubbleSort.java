package yusuke.numata.sort.bubble;

/**
 * バブルソート.
 * 隣り合う要素の大小を比較しながら整列を行う.
 * @author yusuke
 *
 */
public class BubbleSort {

	public static String execute(String param) {
		String data[] = param.split(",");
		for (int i = 0; i < data.length; i++) {
			sort(data);
		}
		String rtn = returnParam(data);
		return rtn;
	}

	private static String[] sort(String[] data) {
		for (int i = 0; i + 1 < data.length; i++) {
			data = compare(data, i , i + 1);
		}
		return data;
	}

	private static String[] compare(String[] data, int valBefore, int valAfter) {
		String mae = data[valBefore];
		String ato = data[valAfter];
		int rtn = mae.compareTo(ato);
		if (rtn > 0) {
			data[valBefore] = ato;
			data[valAfter] = mae;
		}
		return data;
	}

	/**
	 * ソート結果の返却する為に使用する
	 * @param data
	 * @return
	 */
	private static String returnParam(String[] data) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			builder.append(data[i]);
			if (i + 1 != data.length) {
				builder.append(",");
			}
		}
		return builder.toString();
	}	
}
