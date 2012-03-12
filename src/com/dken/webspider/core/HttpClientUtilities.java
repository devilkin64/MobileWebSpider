package com.dken.webspider.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpClientUtilities implements Runnable {
	HttpClient httpclient;
    HttpGet httpget;
    HttpResponse response;
    StringBuffer strBuf = new StringBuffer();
    public HttpClientUtilities(){
        httpclient = new DefaultHttpClient();
    }
    public boolean sendHTTPRequest(){
    	httpget = new HttpGet("http://www.baidu.com");
		//Exectue the http get method
    	try {
            response = httpclient.execute(httpget);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	//Check the fetched contents
    	if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode() ){
    		HttpEntity entity = response.getEntity();
    		if (entity != null) {     
                BufferedReader reader;
                
                try {
                    reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }     
                String line = null;     
                if (entity.getContentLength() > 0) {     
                    strBuf = new StringBuffer((int) entity.getContentLength());     
                    while ((line = reader.readLine()) != null) {     
                        strBuf.append(line);     
                    }     
                }     
            }
    		System.out.print(strBuf);
            if (entity != null) {     
                entity.consumeContent();
                return true; 
            }
    	}
    	
    	
    	return false;    	
    }
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

}
