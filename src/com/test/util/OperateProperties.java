package com.test.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class OperateProperties {
	public static void main(String args[]){
		String path="F:/Ë®¹Ü¼Ò/mengma/config/application.properties";
		getAllProperties(path);
		System.out.println(getValue(path,"mengma.sftp.path"));
	}
	public static void getAllProperties(String path){
		Properties prop= new Properties();
		try {
			InputStream input= new BufferedInputStream(new FileInputStream(path));
			prop.load(input);
			Enumeration<?> en=prop.propertyNames();
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
	public static String getValue(String path,String keyWord){
		String value=null;
		Properties prop=null;
		prop=new Properties();
		try {
			InputStream input= new BufferedInputStream(new FileInputStream(path));
			prop.load(input);
			value=prop.getProperty(keyWord);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return value;
	}
}
