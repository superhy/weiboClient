package test.superhy.weibo.httpclient;

import org.junit.Test;
import org.superhy.weibo.httpclient.Sina;

public class SinaTest {

	@Test
	public void testLogin() {

		String u = "superhy199148@gmail.com";
		String p = "232323";

		System.out.println(Sina.login(u, p).toString());
	}
}
