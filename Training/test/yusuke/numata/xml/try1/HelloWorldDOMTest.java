package yusuke.numata.xml.try1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.FileNotFoundException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class HelloWorldDOMTest {

	public static class 通常処理 {
		
		@Test
		public void domAnalysisでHelloWorldを取得する() throws Exception {
			String actual = HelloWorldDOM.domAnalysis("src/yusuke/numata/xml/try1/HelloWorld.xml");
			assertThat(actual, is("Hello World"));
		}
	}
	
	public static class 例外処理 {

		@Rule
		public ExpectedException exception = ExpectedException.none();
		
		@Test
		public void domAnalysisで引数がnullの場合はNullPointerExceptionを取得する() throws Exception {
			exception.expect(NullPointerException.class);
			HelloWorldDOM.domAnalysis(null);
		}
		
		@Test
		public void domAnalysisで引数がブランクの場合はIllegalArgumentExceptionを取得する() throws Exception {
			exception.expect(IllegalArgumentException.class);
			HelloWorldDOM.domAnalysis("");
		}
		
		@Test
		public void domAnalysisで存在しないファイルの場合はFileNotFoundExceptionを取得する() throws Exception {
			exception.expect(FileNotFoundException.class);
			HelloWorldDOM.domAnalysis(".xml");
		}
	}

}
