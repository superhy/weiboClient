package org.superhy.weibo.httpclient;

import java.util.Map;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class SinaMobile {
	
	public Map<String, String> grabFormValue(String loginUrl) {
		return null;
		
	}

	public static WeiBoUser loginMobile(String u, String p, String loginUrl) {

		WeiBoUser user = null;

		DefaultHttpClient client = new DefaultHttpClient();

		try {

			HttpPost post = new HttpPost(loginUrl);

			// 设置请求消息头
			post
					.setHeader("User-Agent",
							"Mozilla/5.0 (Windows NT 6.1; rv:31.0) Gecko/20100101 Firefox/31.0");
			post
					.setHeader("Accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			post.setHeader("Accept-Language",
					"zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
			post.setHeader("Accept-Encoding", "gzip, deflate");
			post
					.setHeader(
							"Referer",
							"http://login.weibo.cn/login/?ns=1&revalid=2&backURL=http%3A%2F%2Fweibo.cn%2F&backTitle=%CE%A2%B2%A9&vt=");
			post.setHeader("Connection", "keep-alive");
			post.setHeader("Content-Type", "application/x-www-form-urlencoded");
			post.setHeader("Content-Length", "183");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
