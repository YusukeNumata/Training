package yusuke.numata.sort.bubble;

/**
 * バブルソート.
 * 隣り合う要素の大小を比較しながら整列を行う.
 * @author yusuke
 *
 */
public class BubbleSort {

	private static final String SEPARATER = ",";

	public static String execute(String param) {
		String data[] = param.split(SEPARATER);
		sort(data);
		String rtn = returnParam(data);
		return rtn;
	}

	private static void sort(String[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j + 1 < data.length; j++) {
				compare(data, j, j + 1);
			}
		}
	}

	private static void compare(String[] data, int i, int j) {
		String mae = data[i];
		String ato = data[j];
		int rtn = mae.compareTo(ato);
		if (rtn > 0) {
			data[i] = ato;
			data[j] = mae;
		}
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
				builder.append(SEPARATER);
			}
		}
		return builder.toString();
	}	
}
