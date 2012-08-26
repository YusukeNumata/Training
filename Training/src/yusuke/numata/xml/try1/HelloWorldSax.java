package yusuke.numata.xml.try1;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HelloWorldSax extends DefaultHandler {

	public static void saxAnalysis(String filepath) {

		// SAXParserFactoryの新しいインスタンスを取得する.
		SAXParserFactory spfactory = SAXParserFactory.newInstance();

		try {

			// 現在設定されているパラメータを使用して、SAXParserの新しいインスタンスを取得する.
			SAXParser parser = spfactory.newSAXParser();

			// 指定されたファイルのコンテンツを、指定されたDefaultHandlerを使用してXMLとして構文解析します.
			parser.parse(new File(filepath), new HelloWorldSax());

			// 要求された構成を満たすパーサーが生成できない場合
		} catch (ParserConfigurationException e) {
			e.printStackTrace();

			// SAXエラーの場合
		} catch (SAXException e) {
			e.printStackTrace();

			// 入出力エラーが発生した場合
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	// ドキュメント開始時に呼ばれる
	@Override
	public void startDocument() {
		System.out.println("START Document");
	}
	
	// 要素の開始タグ読み込み時に呼ばれる
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		System.out.println("START ELEMENT");
	}
	
	// テキストデータ読み込み時に呼ばれる
	@Override
	public void characters(char[] ch, int offset, int length) {
		System.out.println("LOAD  DATA:" + new String(ch, offset, length));
	}
	
	// 要素の終了タグ読み込み時に呼ばれる
	@Override
	public void endElement(String uri, String localName, String qName) {
		System.out.println("END   ELEMENT");
	}
	
	// ドキュメント終了時に呼ばれる
	@Override
	public void endDocument() {
		System.out.println("END   DOCUMENT");
	}
}
