package com.konrad.rest;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

@SuppressWarnings("deprecation")
public class SimpleHttpGet {
		  @SuppressWarnings("resource")
		public void getDataFromWeb() throws IOException {
			  DefaultHttpClient httpclient = new DefaultHttpClient();
			    try {
			      // specify the host, protocol, and port
			      HttpHost target = new HttpHost("weather.yahooapis.com", 80, "http");

			      // specify the get request
			      HttpGet getRequest = new HttpGet("/forecastrss?w=505120");

//			      System.out.println("executing request to " + target);

			      HttpResponse httpResponse = httpclient.execute(target, getRequest);
			      HttpEntity entity = httpResponse.getEntity();

//			      System.out.println("----------------------------------------");
//			      System.out.println(httpResponse.getStatusLine());
			      Header[] headers = httpResponse.getAllHeaders();
			      for (int i = 0; i < headers.length; i++) {
//			        System.out.println(headers[i]);
			      }
//			      System.out.println("----------------------------------------");

			      if (entity != null) {

			    	  PrintStream out = null;
			    	  try {
			    	      out = new PrintStream(new FileOutputStream("source\\weather.xml"));
			    	      out.print(EntityUtils.toString(entity));
			    	  }
			    	  finally {
			    	      if (out != null) out.close();
			    	  }
			      }

			    } catch (Exception e) {
			      e.printStackTrace();
			    } finally {
			      // When HttpClient instance is no longer needed,
			      // shut down the connection manager to ensure
			      // immediate deallocation of all system resources
			      httpclient.getConnectionManager().shutdown();	 
			     
			   
		  }
		  }	  
}
