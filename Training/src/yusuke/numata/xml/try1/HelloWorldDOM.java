package yusuke.numata.xml.try1;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * XMLのDOMツリーを解析するクラス.
 * URL:<code>http://digitechlog.com/2009/02/25/4-ways-to-read-and-write-xml.html</code>を参考.
 */
public class HelloWorldDOM {

	public static String domAnalysis(String filepath) throws Exception {

		System.out.println("START HelloWorldDOM.domAnalysis");

		// 引数チェック
		if (filepath == null) {
			throw new NullPointerException();
		} else if (filepath == "") {
			throw new IllegalArgumentException();
		}

		try {

			// DocumentBuilderFactoryクラスの新しいインスタンスを取得する.
			DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();

			// 現在設定されているパラメータを使用して、DocumentBuilderクラスの新しいインスタンスを生成する.
			DocumentBuilder builder = dbfactory.newDocumentBuilder();

			// 指定されたファイルの内容をXMLドキュメントとして構文解析し、新しいDOMオブジェクトを生成する.
			Document doc = builder.parse(new File(filepath));

			// 文章の文章要素となっている子ノードへの直接アクセスを可能とする.
			Element root = doc.getDocumentElement();

			// 最初の子ノードの値を返します.
			System.out.println("END   HelloWorldDOM.domAnalysis");
			return root.getFirstChild().getNodeValue();

			// 設定されたパラメータでDocumentBuilderクラスを生成できない場合に実行する.
		} catch (ParserConfigurationException e) {
			throw e;

			// DocumentBuilder.parseで構文解析エラーが発生した場合に実行する.
		} catch (SAXException e) {
			throw e;

			// DocumentBuilder.parseで入出力エラーが発生した場合に実行する.
		} catch (IOException e) {
			throw e;
		}
	}
}
