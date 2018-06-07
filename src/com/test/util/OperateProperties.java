package com.test.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public  class OperateProperties {
	//获取所有的配置内容
	public static Map<String,String> getAllProperties(String path){
		Properties prop= new Properties();
		Map<String,String> map=new HashMap<String, String>();
		try {
			InputStream input= new BufferedInputStream(new FileInputStream(path));
			prop.load(new InputStreamReader(input,"UTF-8"));
			Enumeration<?> en=prop.propertyNames();
			while(en.hasMoreElements()){
				String keyWord=(String) en.nextElement();
				String valueWord=prop.getProperty(keyWord);
				map.put(keyWord, valueWord);
				//System.out.println(keyWord+"="+valueWord);
			}
			return map;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//根据key获取value
	public static String getValue(String path,String keyWord){
		String value=null;
		Properties prop=null;
		prop=new Properties();
		try {
			InputStream input= new BufferedInputStream(new FileInputStream(path));
			prop.load(new InputStreamReader(input,"UTF-8"));
			value=prop.getProperty(keyWord);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return value;
	}
}
