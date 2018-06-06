package com.test.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OperateFile {
	private static String reader;
	//创建文件夹
	public static void mkdir(){
		
	}
	//创建文件
	public static void mkfile(){}
	//读取文件内容
	public static String fileRead(String path){
		String coding="UTF-8";
		File file=new File(path);
		if(file.exists()&&!file.isDirectory()){
			try {
				FileInputStream fi=new FileInputStream(file);
				InputStreamReader read= new InputStreamReader(fi,coding);
				BufferedReader br=new BufferedReader(read);
				String lineTxt = null;   
		        StringBuilder sb = new StringBuilder(); 
		        while ((lineTxt = br.readLine()) != null) {  
		        	sb.append(lineTxt).append("\n");  
		        }  
		        read.close();
		        return sb.toString();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	//写文件
	public static void fileWrite(){
	}
	//复制文件
	public static void fileCopy(){}
	//文件重命名
	public static void fileRename(){}
	//删除文件
	public static void fileDel(){}
	//转移文件
	public static void fileMv(){}
	//删除文件夹
	public static void dirDel(){}
	public static void main(String args[]){
		System.out.println(fileRead("C:/Users/jinwx.ICITY/Desktop/new5.json"));
	}
}
