package org.superhy.weibo.httpclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SinaMobile {

	// 从登录页面中获得一些固定参数
	public Map<String, String> grabFormValue(String loginUrl) throws Exception {
		// 准备要返回的数据
		Map<String, String> formParams = new HashMap<String, String>();

		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(loginUrl);
		HttpResponse response = client.execute(get);
		String loginHtml = EntityUtils.toString(response.getEntity());
		Document docLogin = Jsoup.parse(loginHtml);

		// System.out.println(docLogin);

		Element eleForm = docLogin.select("form").first();
		String passwordName = eleForm.select("input[name^=password]").first()
				.attr("name");
		String backTitle = eleForm.select("input[name=backTitle]").first()
				.attr("value");
		String tryCount = eleForm.select("input[name=tryCount]").first().attr(
				"value");
		String vk = eleForm.select("input[name=vk]").first().attr("value");
		String action = eleForm.select("form[method=post]").first().attr(
				"action");
		String submit = eleForm.select("input[name=submit]").first().attr(
				"value");

		formParams.put("passwordName", passwordName);
		formParams.put("backTitle", backTitle);
		formParams.put("tryCount", tryCount);
		formParams.put("vk", vk);
		formParams.put("action", action);
		formParams.put("submit", submit);

		System.out.println(formParams.toString());

		return formParams;
	}

	public void loginMobile(String u, String p, String loginUrl) {

		DefaultHttpClient client = new DefaultHttpClient();

		// System.out.println(client.getCookieStore().getCookies().size());

		try {

			HttpPost post = new HttpPost(loginUrl);

			// 设置请求消息头
			post
					.setHeader("User-Agent",
							"Mozilla/5.0 (Windows NT 5.1; rv:9.0.1) Gecko/20100101 Firefox/9.0.1");
			post
					.setHeader("Accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			post.setHeader("Accept-Language",
					"zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
			post.setHeader("Host", "login.weibo.cn");
			post.setHeader("Content-Type", "application/x-www-form-urlencoded");

			// 设置请求发送参数
			Map<String, String> formParams = this.grabFormValue(loginUrl);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("mobile", u));
			nvps.add(new BasicNameValuePair(formParams.get("passwordName"), p));
			nvps
					.add(new BasicNameValuePair("backURL",
							"http%3A%2F%2Fweibo.cn"));
			nvps.add(new BasicNameValuePair("backTitle", formParams
					.get("backTitle")));
			nvps.add(new BasicNameValuePair("tryCount", formParams
					.get("tryCount")));
			nvps
					.add(new BasicNameValuePair("submit", formParams
							.get("submit")));
			nvps.add(new BasicNameValuePair("remenber", "off"));
			nvps.add(new BasicNameValuePair("vk", formParams.get("vk")));
			nvps.add(new BasicNameValuePair("url", "http://weibo.cn/"
					+ formParams.get("action")));
			post.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));

			// 获得返回页面并取出nickName作为验证
			HttpResponse response = client.execute(post);
			String entity = EntityUtils.toString(response.getEntity());

			// System.out.println(entity);

			HttpGet get = new HttpGet("http://weibo.cn/");
			HttpResponse response2 = client.execute(get);
			String entity2 = EntityUtils.toString(response2.getEntity());

			System.out.println(entity2);

			Document doc = Jsoup.parse(entity2);
			String nickName = doc.select("div.ut").first().ownText();

			System.out.println(nickName);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
