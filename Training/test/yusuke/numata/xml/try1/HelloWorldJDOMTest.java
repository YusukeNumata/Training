package yusuke.numata.xml.try1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HelloWorldJDOMTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void jdomAnalysisでHelloWorldを取得する() throws Exception {
		String actual = HelloWorldJDOM.jdomAnalysis("src/yusuke/numata/xml/try1/HelloWorld.xml");
		assertThat(actual, is("Hello World"));
	}

	@Test
	public void jdomAnalysisで引数がnullの場合にNullPointerExceptionが発生する() throws Exception {
		exception.expect(NullPointerException.class);
		HelloWorldJDOM.jdomAnalysis(null);
	}
	
	@Test
	public void jdomAnalysisで引数がブランクの場合にIllegalArgumentExceptionが発生する() throws Exception {
		exception.expect(IllegalArgumentException.class);
		HelloWorldJDOM.jdomAnalysis("");
	}
	
}
