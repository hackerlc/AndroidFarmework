/**
 * 数据提交方式工具类，HttpServer Get or Post model
 * @author YichenZ
 */
package com.example.hackerlcandroidfarmework.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class HttpGetOrPost {

	public static String getHttpGet() {
		return "";
	}

	/**
	 * 
	 * @param Url
	 * @param Content
	 * @return String
	 * @throws UnsupportedEncodingException
	 */
	public static String getHttpPost(String Url, String Content)
			throws UnsupportedEncodingException {
		Log.i("http post", Content);
		return getHttpPost("application/json", "UTF-8", Url, Content);
	}

	/**
	 * 
	 * @param ContentType
	 *            格式 application/json application/rdf+xml application/xml
	 *            text/html text/plain
	 * @param Charset
	 * @param Url
	 * @param Content
	 * @return result 数据内容
	 * @throws UnsupportedEncodingException
	 */
	public static String getHttpPost(String ContentType, String Charset,
			String Url, String Content) throws UnsupportedEncodingException {
		// Log.i("HttpGetOrPost", Content);
		String result = "";
		HttpPost request = new HttpPost(Url);
		request.setHeader("Accept", ContentType);
		request.setHeader("Content-type", ContentType);
		StringEntity entity = new StringEntity(Content, Charset);
		request.setEntity(entity);
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpResponse response = null;
		try {
			// response = httpClient.execute(request);
			response = httpClient.execute(request);
			result = EntityUtils.toString(response.getEntity());
			// Log.i("HttpGetOrPost", result.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
