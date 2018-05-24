package com.test.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpClient {
	public static String doGet(String httpurl){
		HttpURLConnection connection=null;
		InputStream is = null;
		BufferedReader br = null;
		String result = null;
		try{
			//new a url insistance;
			URL url = new URL(httpurl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(15000);
			connection.setReadTimeout(60000);
			connection.connect();
			if (connection.getResponseCode()==200){
				is = connection.getInputStream();
				br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				StringBuffer sbf = new StringBuffer();
				String temp = null;
				while ((temp = br.readLine())!=null){
					sbf.append(temp);
					sbf.append("\r\n");
				}
				result = sbf.toString();
			}
		}catch (MalformedURLException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (null != br){
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
			connection.disconnect();
		}
		
		return result;
	}
	public static String doPost(String httpurl,String param){
		HttpURLConnection connection = null;
		InputStream is=null;
		OutputStream os=null;
		BufferedReader br = null;
		String result=null;
		try {
			URL url=new URL(httpurl);
			connection=(HttpURLConnection)url.openConnection();
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(15000);
			connection.setReadTimeout(60000);
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
			os=connection.getOutputStream();
			os.write(param.getBytes());
			if(connection.getResponseCode()==200){
				is=connection.getInputStream();
				br=new BufferedReader(new InputStreamReader(is, "UTF-8"));
				StringBuffer sbf=new StringBuffer();
				String temp=null;
				while((temp=br.readLine())!=null){
					sbf.append(temp);
					sbf.append("\r\n");
				}
				result=sbf.toString();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
			if(null!=os){
				try {
					os.close();
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
			connection.disconnect();
		}
		return result;
	}
}
