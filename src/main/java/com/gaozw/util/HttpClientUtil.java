package com.gaozw.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
	
	public static void doGet(String url) {
        try {
            // 创建HttpClient实例
        	CloseableHttpClient httpClient = HttpClients.createDefault();
            // 创建Get方法实例
            HttpGet httpGet = new HttpGet(url);
            // 设置请求和传输超时时间  
             //RequestConfig requestConfig =  
             //RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();  
             //httpGet.setConfig(requestConfig);
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instreams = entity.getContent();
                String str = convertStreamToString(instreams);
                System.out.println("Do something");
                System.out.println(str);
                // Do not need the rest
                httpGet.abort();
            }
        } catch (Exception e) {
        }
    }

    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String doPost(String url, Map<String, String> map) {

    	CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost method = new HttpPost(url);
        method.setHeader("accept",
            "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");

        int status = 0;
        String body = null;

        if (method != null & map != null) {
            try {
                //建立一个NameValuePair数组，用于存储欲传送的参数
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                //添加参数
                method.setEntity(new UrlEncodedFormEntity(params));

                long startTime = System.currentTimeMillis();

                HttpResponse response = httpClient.execute(method);

                System.out.println("the http method is:" + method.getEntity());
                long endTime = System.currentTimeMillis();
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != HttpStatus.SC_OK) {
//                    LOGGER.error("请求失败:" + response.getStatusLine());
                    status = 1;
                }

                //Read the response body
                body = EntityUtils.toString(response.getEntity(), "UTF-8");

            } catch (IOException e) {
                //发生网络异常
//                LOGGER.error("exception occurred!\n");
                //网络错误
                status = 3;
            } finally {
//                LOGGER.info("调用接口状态：" + status);
            }

        }
        return body;
    }
}
