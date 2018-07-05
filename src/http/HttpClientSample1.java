package http;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpClientSample1 {
	public static void main(String[] args){
		HttpClientSample1 sample = new HttpClientSample1();
		sample.getResult();
	}

	private void getResult() {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet("http://www.google.com");
		InputStream is = null;
		BufferedInputStream bis = null;
		try{
			HttpResponse response = httpClient.execute(httpGet);
			System.out.println(response.getStatusLine().toString());
			
			is = response.getEntity().getContent();
			bis = new BufferedInputStream(is);
			
			byte[] buffer = new byte[1024];
			
			while((bis.read(buffer))!=-1){
				String str = new String(buffer, "utf-8");
				System.out.println(str);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(bis != null)
					bis.close();
				if(is != null)
					is.close();
			}catch(IOException ignorable){}
		}
	}
}
