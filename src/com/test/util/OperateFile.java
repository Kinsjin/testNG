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
	//�����ļ���
	public static void mkdir(){
		
	}
	//�����ļ�
	public static void mkfile(){}
	//��ȡ�ļ�����
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
	//д�ļ�
	public static void fileWrite(){
	}
	//�����ļ�
	public static void fileCopy(){}
	//�ļ�������
	public static void fileRename(){}
	//ɾ���ļ�
	public static void fileDel(){}
	//ת���ļ�
	public static void fileMv(){}
	//ɾ���ļ���
	public static void dirDel(){}
	public static void main(String args[]){
		System.out.println(fileRead("C:/Users/jinwx.ICITY/Desktop/new5.json"));
	}
}
