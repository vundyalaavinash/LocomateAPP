package com.locomate.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class NetworkUtils {

	public static String postData(ArrayList<BasicNameValuePair> params , String url) {
		// Create a new HttpClient and Post Header
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);

		try {
			// Add your data
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(params.size());
			for (BasicNameValuePair param : params)
				nameValuePairs.add(param);
			
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			// Execute HTTP Post Request
			HttpResponse response = httpclient.execute(httppost);
			
			
			//System.out.println(".................Response Code: "+response.getStatusLine().getStatusCode());
			
			String result = EntityUtils.toString(response.getEntity());
			
			System.out.println(result);
			return result;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
