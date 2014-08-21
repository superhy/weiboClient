package test.superhy.weibo.httpclient;

import org.junit.Test;
import org.superhy.weibo.httpclient.SinaMobile;

public class SinaMobileTest {

	@Test
	public void testLoginMobile() throws Exception {
		SinaMobile sinaMobile = new SinaMobile();

		String u = "superhy199148@gmail.com";
		String p = "232323";
		String loginUrl = "http://login.weibo.cn/login/";

		sinaMobile.loginMobile(u, p, loginUrl);
	}
}
