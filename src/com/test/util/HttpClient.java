package com.test.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClient {
	public String doGet(String httpurl){
		HttpURLConnection conn=null;
		InputStream is = null;
		BufferedReader br = null;
		String result = null;
		try{
			//new a url insistance;
			URL url = new URL(httpurl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Cookie","UISESSION=E452BA4243666D5F369E31A74A941E71");
			//connection.setConnectTimeout(15000);
			//connection.setReadTimeout(60000);
			conn.connect();
			if (conn.getResponseCode()==200){
				is = conn.getInputStream();
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
			conn.disconnect();
		}
		
		return result;
	}
	public String doPost(String httpurl,String param){
		HttpURLConnection conn = null;
		InputStream is=null;
		OutputStream os=null;
		BufferedReader br = null;
		String result=null;
		try {
			URL url=new URL(httpurl);
			conn=(HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(15000);
			conn.setReadTimeout(60000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Accept", "application/json, text/plain, */*");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 "
					+ "(KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");
			conn.setRequestProperty("Cookie","UISESSION=E452BA4243666D5F369E31A74A941E71");
			//conn.setRequestProperty("", value);
			os=conn.getOutputStream();
			os.write(param.getBytes());
			if(conn.getResponseCode()==200){
				is=conn.getInputStream();
				br=new BufferedReader(new InputStreamReader(is, "UTF-8"));
				StringBuffer sbf=new StringBuffer();
				String temp=null;
				while((temp=br.readLine())!=null){
					sbf.append(temp);
					sbf.append("\r\n");
				}
				result=sbf.toString();
			}else {
				result=conn.getErrorStream().toString();
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
			conn.disconnect();
		}
		return result;
	}
}
