package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientSample2 {
	public static void main(String[] args){
		HttpPost postMethod = new HttpPost("www.google.com");
		HttpClientSample2.printBody(postMethod);
		
		ArrayList<NameValuePair> paramList = new ArrayList<>();
		paramList.add(new BasicNameValuePair("name","benjamin"));
		paramList.add(new BasicNameValuePair("age","33"));
		try{
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "UTF-8");
			postMethod.setEntity(entity);
			HttpClientSample2.printBody(postMethod);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
	}

	private static void printBody(HttpPost httpPost) {
		InputStream is = null;
		InputStreamReader reader = null;
		BufferedReader br = null;
		try{
			System.out.println(httpPost.toString());
			if(httpPost.getEntity() == null)
				System.out.println("Body is null");
			else{
				is = httpPost.getEntity().getContent();
				br = new BufferedReader(new InputStreamReader(is));
				
				String line = null;
				while((line = br.readLine())!=null)
					System.out.println(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(br!=null)
					br.close();
				if(is!=null)
					is.close();
				if(reader!=null)
					reader.close();
			}catch(IOException ignorable){}
		}
	}
}
