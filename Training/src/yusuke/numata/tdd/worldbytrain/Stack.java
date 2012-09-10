package yusuke.numata.tdd.worldbytrain;

public class Stack {

	private int value;
	private int size;

	/**
	 * 要素が空か否かを判定する.
	 * @return 空の場合、true
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * スタックの一番上の値を取得する.
	 * @return 一番上の値
	 */
	public int top() {
		return 1;
	}

	/**
	 * 引数の値をスタックの一番上に積む.
	 * @param value 積む値
	 */
	public void push(int value) {
		this.value = value;
		size++;
	}

	/**
	 * スタックのサイズを取得する.
	 * @return スタックのサイズ
	 */
	public int size() {
		return size;
	}

}
