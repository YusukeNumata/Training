package yusuke.numata.sort.bubble;

public class BubbleSort2 {

	public static String[] execute(String[] params) {
		
		if (params == null || params.length <= 1) {
			return params;
		}

		String[] copyParams = params.clone();

		for (int i = 0; i < copyParams.length - 1; i++) {
			for (int j = 0; j + 1 < copyParams.length; j++) {
				compare(copyParams, j);
			}
		}

		return copyParams;
	}

	private static void compare(String[] copyParams, int args) {
		String param_1 = copyParams[args    ];
		String param_2 = copyParams[args + 1];
		int compare_result = param_1.compareTo(param_2);
		if (compare_result > 0) {
			copyParams[args    ] = param_2;
			copyParams[args + 1] = param_1;
		}
	}

}
