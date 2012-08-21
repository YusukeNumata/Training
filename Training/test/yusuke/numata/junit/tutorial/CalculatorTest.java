package yusuke.numata.junit.tutorial;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class CalculatorTest {

	@RunWith(Theories.class)
	public static class 乗算メソッドのパラメータ化テスト {
		
//		@DataPoint public static Fixture DATA1 = new Fixture(3, 4, 12);
//		@DataPoint public static Fixture DATA2 = new Fixture(5, 7, 35);
		
		@DataPoints
		public static Fixture[] DATAS = {
			new Fixture(3, 4, 12),
			new Fixture(5, 7, 35)
		};
		
		@Theory
		public void multiplyで乗算結果が取得できる(Fixture fx) {
			System.out.println(fx.x + "*" + fx.y + "=" + fx.expected);
			Calculator calc = new Calculator();
			int expected = fx.expected;
			int actual = calc.multiply(fx.x, fx.y);
			assertThat(actual, is(expected));
		}
		
		// データクラス
		static class Fixture {
			int x, y, expected;
			Fixture(int x, int y, int expected) {
				this.x = x;
				this.y = y;
				this.expected = expected;
			}
		}
	}
	
	@RunWith(Theories.class)
	public static class 除算メソッドのパラメータ化テスト {
		
		@DataPoints
		public static Fixture[] DATAS = {
			new Fixture(3, 2, 1.5f),
			new Fixture(10, 2, 5f),
			new Fixture(3, 0, null),
			new Fixture(10, 0, null)
		};
		
		@Rule
		public ExpectedException exception = ExpectedException.none();
		
		@Theory
		public void divideで除算結果が取得できる(Fixture fx) {
			Assume.assumeTrue(fx.y != 0);	// 0以外なら以降の処理を実行
			System.out.println(fx.x + "/" + fx.y + "=" + fx.expected);
			Calculator calc = new Calculator();
			float expected = fx.expected;
			float actual = calc.divide(fx.x, fx.y);
			assertThat(actual, is(expected));
		}

		@Theory
		public void divideの第２引数に0を指定した場合はIllegalArgumentExceptionを送出する(Fixture fx) {
			Assume.assumeTrue(fx.y == 0);	// 0なら以降の処理を実行
			System.out.println(fx.x + "/" + fx.y + "=" + fx.expected + " 0で割っちゃだめ？");
			exception.expect(IllegalArgumentException.class);
			Calculator calc = new Calculator();
			calc.divide(fx.x, fx.y);
		}

		// データクラス
		static class Fixture {
			int x, y;
			Float expected;
			Fixture(int x, int y, Float expected) {
				this.x = x;
				this.y = y;
				this.expected = expected;
			}
		}
	}

}
