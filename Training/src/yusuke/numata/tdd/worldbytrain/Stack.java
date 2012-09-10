package yusuke.numata.tdd.worldbytrain;

import java.util.EmptyStackException;

public class Stack {

	private int[] values = new int[10];
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
		emptyCheck();
		return values[size - 1];
	}

	/**
	 * 引数の値をスタックの一番上に積む.
	 * @param value 積む値
	 */
	public void push(int value) {
		this.values[size] = value;
		size++;
	}

	/**
	 * スタックのサイズを取得する.
	 * @return スタックのサイズ
	 */
	public int size() {
		return size;
	}

	/**
	 * スタックの一番上の値を取り除く.
	 */
	public void pop() {
		emptyCheck();
		size--;
	}

	/**
	 * 空判定処理.
	 */
	private void emptyCheck() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
	}

}
