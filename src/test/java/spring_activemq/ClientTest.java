package spring_activemq;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;


public class ClientTest {
	@Test
	public void test(){
		
	}
	
}

class Sender implements Runnable{
	public static AtomicInteger count=new AtomicInteger(0);
	private HttpClient httpClient;
	
	public Sender(HttpClient httpClient) {
		this.httpClient=httpClient;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+"---send messge--"+count.incrementAndGet());
			PostMethod post=new PostMethod("http://localhost:9999/spring_activemq/test/send.do");
			post.addParameter("msg","hello world");
			httpClient.executeMethod(post);
			System.out.println(Thread.currentThread().getName()+"---send message success-"+count.intValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}