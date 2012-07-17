package yusuke.numata.sort.bubble;

public class BubbleSort3 {

	public static String[] execute(String[] actuals) {

		// 引数チェック
		if (actuals == null || actuals.length <= 1) {
			return actuals;
		}

		// バブルソート実行
		for (int i = 0; i < actuals.length; i++) {
			for (int j = 0; j < actuals.length - 1; j++) {
				compare(actuals, j);
			}
		}

		return actuals;
	}

	/**
	 * 配列内の値を比較する.
	 * @param actuals 配列
	 * @param j 配列の比較前の値
	 */
	private static void compare(String[] actuals, int j) {
		String param1 = actuals[j    ];
		String param2 = actuals[j + 1];
		if (param1.compareTo(param2) >= 1) {
			actuals[j    ] = param2;
			actuals[j + 1] = param1;
		}
	}
}
