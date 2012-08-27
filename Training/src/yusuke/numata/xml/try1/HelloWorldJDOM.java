package yusuke.numata.xml.try1;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * JDOMを利用してXMLを解析するクラス.
 * URL:<code>http://digitechlog.com/2009/02/25/4-ways-to-read-and-write-xml.html</code>を参考.
 * JDOMを利用する為には、JDOMライブラリが必要.<code>http://www.jdom.org/downloads/index.html</code>
 */
public class HelloWorldJDOM {

	public static String jdomAnalysis(String filepath) throws Exception {

		// 引数チェック
		if (filepath == null) {
			throw new NullPointerException();
		} else if ("".equals(filepath) ) {
			throw new IllegalArgumentException();
		}

		try {

			// SAXBuilderクラスを利用してXMLDocumentを取得します.
			Document doc = new SAXBuilder().build(new File(filepath));

			// Documentのルート要素を取得します.
			Element root = doc.getRootElement();

			// ルート要素のテキストを取得します.
			String msg = root.getText();
			
			return msg;

		} catch (JDOMException e) {
			e.printStackTrace();
			throw e;

		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
