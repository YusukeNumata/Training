package yusuke.numata.junit.tutorial;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * アサーション情報を拡張するカスタムルール.
 */
public class AssertionMessage implements TestRule {

	/**	メッセージ. */
	private StringBuilder msg = new StringBuilder();

	/** メッセージの追加. */
	public void append(String format, Object... params) {
		msg.append(String.format(format, params));
	}

	/**
	 * プロキシオブジェクトの作成.
	 * @param Statement JUnitテストを実行するオブジェクト
	 * @param Description テストケースのメタ情報を保持するオブジェクト
	 */
	@Override
	public Statement apply(final Statement base, Description description) {
		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				try {
					// ユニットテストの実行
					base.evaluate();
				} catch (AssertionError e) {
					msg.append('\n').append(e.getMessage());
					AssertionError e2 = new AssertionError(msg.toString());
					e2.setStackTrace(e.getStackTrace());
					throw e2;
				}
			}
		};
	}

	
}
