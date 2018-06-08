package com.test.api;


import java.io.IOException; 
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler; 
import org.apache.commons.httpclient.Header; 
import org.apache.commons.httpclient.HttpClient; 
import org.apache.commons.httpclient.HttpException; 
import org.apache.commons.httpclient.HttpStatus; 
import org.apache.commons.httpclient.UsernamePasswordCredentials; 
import org.apache.commons.httpclient.auth.AuthScope; 
import org.apache.commons.httpclient.methods.GetMethod; 
import org.apache.commons.httpclient.params.HttpMethodParams; 

public class Common_API { 
	public static void main(String[] args) throws HttpException, IOException { 
		/*HttpClient httpClient = new HttpClient(); 
		//需要验证 
		UsernamePasswordCredentials creds = new UsernamePasswordCredentials("test", "123");
	    System.out.println(creds.getUserName());
	    System.out.println(creds.getPassword());
		//UsernamePasswordCredentials creds = new UsernamePasswordCredentials("test", "123");
		httpClient.getState().setCredentials(AuthScope.ANY, creds); 
		//设置http头 
		List <Header> headers = new ArrayList <Header>(); 
		headers.add(new Header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36"));
		headers.add(new Header("Cookie","UISESSION=E452BA4243666D5F369E31A74A941E71"));
		httpClient.getHostConfiguration().getParams().setParameter("http.default-headers", headers); 
		GetMethod method = new GetMethod("http://192.168.0.40:9013/webInfo/All");
		method.setDoAuthentication(true);
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
				new DefaultHttpMethodRetryHandler(3, false)); 
		try { 
			int statusCode = httpClient.executeMethod(method); 
			if (statusCode != HttpStatus.SC_OK) { 
				System.out.println("Method failed code="+statusCode+": " + method.getStatusLine()); 

			} else { 
				System.out.println(new String(method.getResponseBody(), "utf-8")); 
			} 
		} finally { 
			method.releaseConnection(); 
		} */
		int i,j,k=0;
		String a="abcde",b="cedfghp";
		String c="";
		for(i=0;i<a.length();i++){
			for(j=0;j<b.length();j++){
				if(a.charAt(i)==b.charAt(j)){ 
					a=a.replace(a.charAt(i),'0');
					b=b.replace(b.charAt(j),'0');
				}
			}
		}//找出两个字符串中相同的字符，改为0
		for(i=0;i<a.length();i++){ 
			if(a.charAt(i)!='0'){
				c+="0";
				c=c.replace(c.charAt(k),a.charAt(i));
				k++;
				}
			}
		for(j=0;j<b.length();j++){ 
			if(b.charAt(j)!='0'){
				c+="0";
				c=c.replace(c.charAt(k),b.charAt(j));
				k++;
				}
			}
		//将余下的不同的字符添加到字符串c中，c即为你想要的字符串。
		System.out.println(c);//输出：abfghp
	} 
}