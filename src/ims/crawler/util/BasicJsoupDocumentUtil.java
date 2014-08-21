package ims.crawler.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class BasicJsoupDocumentUtil {

	public synchronized static Document getDocument(String url) {
		try {

			return Jsoup.connect(url).timeout(120000).ignoreHttpErrors(true)
					.ignoreContentType(true).get();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}
	}
}
