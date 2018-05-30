package com.test.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class OperateProperties {
	private static String path;
	public static void getAllProperties(String path){
		Properties prop= new Properties();
		try {
			InputStream input= new BufferedInputStream(new FileInputStream(path));
			prop.load(input);
			Enumeration en=prop.propertyNames();
			while(en.hasMoreElements()){
				String keyWord=(String) en.nextElement();
				String valueWord=prop.getProperty(keyWord);
				System.out.println(keyWord+"="+valueWord);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void getProperties(String path,String keyWord){
		Properties prop=null;
		String value=null;
	}
}
