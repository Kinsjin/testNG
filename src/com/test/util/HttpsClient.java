package com.test.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class HttpsClient {
	public static String doGet(String requestUrl){
		HttpsURLConnection conn=null;
		InputStream is=null;
		BufferedReader br=null;
		String result=null;
	    try{  
	    	//创建SSLContext  
	    	SSLContext sslContext=SSLContext.getInstance("SSL");  
	    	TrustManager[] tm={new MyX509TrustManager()};  
	    	//初始化  
	    	sslContext.init(null, tm, new java.security.SecureRandom());;  
	    	//获取SSLSocketFactory对象  
	    	SSLSocketFactory ssf=sslContext.getSocketFactory();  
	    	URL url=new URL(requestUrl);  
	    	conn=(HttpsURLConnection)url.openConnection();
	    	conn.setHostnameVerifier(new HostnameVerifier(){
			@Override
			public boolean verify(String hostname, SSLSession session) {
				// TODO Auto-generated method stub
				return true;
				}	    	
	    	});
	    	conn.setDoOutput(true);  
	    	conn.setDoInput(true);  
	    	conn.setUseCaches(false);  
	    	conn.setRequestMethod("GET"); 	    
	    	//设置当前实例使用的SSLSoctetFactory  
	    	conn.setSSLSocketFactory(ssf);  
	    	conn.connect();  
	    	if (conn.getResponseCode()==200){
	    		is=conn.getInputStream();
	    		br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	    		StringBuffer sbf = new StringBuffer();
	    		String temp = null;
	    		//读取服务器端返回的内容  
	    		while ((temp = br.readLine())!=null){
					sbf.append(temp);
					sbf.append("\r\n");
				}
	    		result=sbf.toString();
	    	}	    
	    } catch(MalformedURLException e){  
	        e.printStackTrace();  
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    } catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	    	if(null!=br){
	    		try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(null!=is){
	    		try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	conn.disconnect();
	    }
	    //System.out.println("23");
	    return result;
	}
	
	public static String doPost(String requestUrl,String param){
		HttpsURLConnection conn=null;
		InputStream is=null;
		OutputStream os=null;
		BufferedReader br=null;
		String result=null; 
	    try{  
	    	//创建SSLContext  
	    	SSLContext sslContext=SSLContext.getInstance("SSL");  
	    	TrustManager[] tm={new MyX509TrustManager()};  
	    	//初始化  
	    	sslContext.init(null, tm, new java.security.SecureRandom());;  
	    	//获取SSLSocketFactory对象  
	    	SSLSocketFactory ssf=sslContext.getSocketFactory();  
	    	URL url=new URL(requestUrl);  
	    	conn=(HttpsURLConnection)url.openConnection();
	    	conn.setHostnameVerifier(new HostnameVerifier(){
			@Override
			public boolean verify(String hostname, SSLSession session) {
				// TODO Auto-generated method stub
				return true;
				}	    	
	    	});
	    	conn.setDoOutput(true);  
	    	conn.setDoInput(true);  
	    	conn.setUseCaches(false);  
	    	conn.setRequestMethod("POST");
	    	conn.setConnectTimeout(15000);
			conn.setReadTimeout(60000);
			conn.setRequestProperty("Accept", "application/json, text/plain, */*");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 "
					+ "(KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");
	    	//设置当前实例使用的SSLSoctetFactory  
	    	conn.setSSLSocketFactory(ssf);  
	    	os=conn.getOutputStream();
			os.write(param.getBytes());
	    	if (conn.getResponseCode()==200){
	    		is=conn.getInputStream();
	    		br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	    		StringBuffer sbf = new StringBuffer();
	    		String temp = null;
	    		//读取服务器端返回的内容  
	    		while ((temp = br.readLine())!=null){
					sbf.append(temp);
					sbf.append("\r\n");
				}
	    		result=sbf.toString();
	    	}else {
				result=conn.getErrorStream().toString();
	    	}
	    } catch(MalformedURLException e){  
	        e.printStackTrace();  
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    } catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	    	if(null!=br){
	    		try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(null!=is){
	    		try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	conn.disconnect();
	    }
	    //System.out.println("23");
	    return result;
	}
}
