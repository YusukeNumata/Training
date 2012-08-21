package yusuke.numata.junit.tutorial;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
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
	
	
	@Test
	public void divideで3と2の除算結果が取得できる() {
		Calculator calc = new Calculator();
		float expected = 1.5f;
		float actual = calc.divide(3, 2);
		assertThat(actual, is(expected));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void divideの第２引数に0を指定した場合はIllegalArgumentExceptionを送出する() {
		Calculator calc = new Calculator();
		calc.divide(3, 0);
	}

}
