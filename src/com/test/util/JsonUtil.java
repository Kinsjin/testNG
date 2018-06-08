package com.test.util;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JsonUtil {
	private static JsonParser jp;
	private static JsonObject jo;
	private static JsonArray subObject;
	private static JsonObject child;
	public static void setJson(String str){
		jp=new JsonParser();
		jo = (JsonObject) jp.parse(str);
	}
	//非数组根据title读取数据
	public static List<String> jsonElementValueHeader(String source,String title,String...strs){
		List<String> list=new ArrayList<String>();
		jp=new JsonParser();
		try {
			jo=((JsonObject) jp.parse(source)).get(title).getAsJsonObject();
			//System.out.println(jo);
			if(!jo.isJsonArray()){
				for(int i=0;i<strs.length;i++){
					list.add(jo.get(strs[i]).getAsString());
					//System.out.println(list.get(i));
				}
			}
			return list;
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//非数组无title读取数据
	public static List<String> jsonElementValue(String source,String...strs){
		List<String> list=new ArrayList<String>();
		jp=new JsonParser();
		try {
			jo=(JsonObject) jp.parse(source).getAsJsonObject();
			//System.out.println(jo);
			if(!jo.isJsonArray()){
				for(int i=0;i<strs.length;i++){
					list.add(jo.get(strs[i]).getAsString());
					//System.out.println(list.get(i));
				}
			}
			return list;
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//读取数组
	public static JsonArray getJsonArray(String source,String str){
			jp=new JsonParser();	
			try {
				jo = (JsonObject) jp.parse(source);
				if(jo.get(str).isJsonArray()){
					subObject=jo.get(str).getAsJsonArray();
					//System.out.println(subObject);
				}
				return subObject;
			} catch (JsonIOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonSyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	//��ȡ����json����
	public static JsonObject jsonArrayValue(JsonArray source,int index){
		//System.out.println(source.get(index).getAsJsonObject());
		try {
			child=source.get(index).getAsJsonObject();
			//System.out.println(child);
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return child;
	}
	public static int jsonArraySize(JsonArray source){
		int count=source.size();
		return count;		
	}
}
