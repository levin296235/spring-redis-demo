package cn.springmvc.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;



public class TestHttpComponent {

	public static void main(String[] args) throws URISyntaxException, ClientProtocolException, IOException {
		
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//		String url = "http://www.google.com/search?hl=en&q=httpclient&btnG=Google+Search&aq=f&oq=";  
//		URI uri = new URIBuilder()  
//        .setScheme("http")  
//        .setHost("www.google.com")  
//        .setPath("/search")  
//        .setParameter("q", "httpclient")  
//        .setParameter("btnG", "Google Search")  
//        .setParameter("aq", "f")  
//        .setParameter("oq", "")  
//        .build();  
//		HttpGet httpGet = new HttpGet(uri);
//		System.out.println(httpGet.getURI());
//		
//		CloseableHttpResponse response = null;
//		
//		try {
//			response = httpClient.execute(httpGet);
//			HttpResponse resp = new BasicHttpResponse(HttpVersion.HTTP_1_1,HttpStatus.SC_OK, "OK");  
//			resp.addHeader("Set-Cookie","c1=a; path=/; domain=localhost");  
//			resp.addHeader("Set-Cookie","c2=b; path=\"/\", c3=c; domain=\"localhost\"");  
//			HeaderIterator it = response.headerIterator("Set-Cookie");  
//			while (it.hasNext()) {  
//			     System.out.println(it.next());  
//			}  
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				response.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		
		httpGet();
		
	}
	public static void httpGet() throws ClientProtocolException, IOException{
		//1.构建HttpClient
		CloseableHttpClient client = HttpClients.createDefault();
		//2.构建请求
		HttpGet get = new HttpGet("http://www.sina.com.cn");
		//3.请求首部
		get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:39.0) Gecko/20100101 Firefox/39.0");
		//4.执行请求
		CloseableHttpResponse resp = client.execute(get);
		System.out.println(resp.getStatusLine().toString()+"\n");
		//获取首部
		Header[] hd = resp.getAllHeaders();
		for(Header h : hd){
			System.out.println(h.getName()+":\t"+h.getValue());
		}
		System.out.println("=======================================");
		System.out.println("=======================================");
		//6.获取实体
		HttpEntity entity = resp.getEntity();
		System.out.println(EntityUtils.toString(entity,"UTF-8"));
		EntityUtils.consume(entity);
		resp.close();
		client.close();
		
		
	}
	public static void httpPost() throws ClientProtocolException, IOException{
		CloseableHttpClient client = HttpClients.createDefault();
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
		formparams.add(new BasicNameValuePair("param1", "value1"));  
		formparams.add(new BasicNameValuePair("param2", "value2"));  
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(formparams,  
		                                                          Consts.UTF_8);  
		HttpPost httppost = new HttpPost("http://localhost/handler.do");  
		httppost.setEntity(formEntity); 
		CloseableHttpResponse resp = client.execute(httppost);
		HttpEntity entity = resp.getEntity();
		ContentType contentType = ContentType.getOrDefault(entity);  
        Charset charset = contentType.getCharset();  
        Reader reader = new InputStreamReader(entity.getContent(), charset); 
		
	}
}
