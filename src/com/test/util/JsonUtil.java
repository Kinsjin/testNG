package com.test.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

public class JsonUtil {
	private static JsonParser jp;
	private static JsonObject jo;
	private static JsonArray ja;
	public static List<String> jsonElementValueHeader(String source,String title,String...strs){
		List<String> list=new ArrayList<String>();
		jp=new JsonParser();
		try {
			jo=((JsonObject) jp.parse(source)).get(title).getAsJsonObject();
			System.out.println(jo);
			if(!jo.isJsonArray()){
				for(int i=0;i<strs.length;i++){
					list.add(jo.get(strs[i]).getAsString());
					System.out.println(list.get(i));
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
	public static List<String> jsonElementValue(String source,String...strs){
		List<String> list=new ArrayList<String>();
		jp=new JsonParser();
		try {
			jo=(JsonObject) jp.parse(source).getAsJsonObject();
			System.out.println(jo);
			if(!jo.isJsonArray()){
				for(int i=0;i<strs.length;i++){
					list.add(jo.get(strs[i]).getAsString());
					System.out.println(list.get(i));
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
	public static void jsonArrayValue(String path,String str){
		//Map map=new HashMap();
		jp=new JsonParser();
		try {
			jo = (JsonObject) jp.parse(new FileReader(path));
			ja=jo.get("languages").getAsJsonArray();
			if(ja.isJsonArray()){
			for (int i = 0; i < ja.size(); i++) {
				System.out.println("-----------------");
				//创建一个JsonObject，从array的下标获取，get() 返回JsonElement类型
				//这里不用强转，而用 getAsJsonObject() 进行转换
				JsonObject subObject=ja.get(i).getAsJsonObject();
				System.out.println("id="+subObject.get("id").getAsInt());
				//System.out.println("name="+subObject.get("name").getAsString());
				//System.out.println("ide="+subObject.get("ide").getAsString());
			}}
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return null;
	}
	public static void main(String args[]){
		JsonUtil.jsonElementValueHeader("{\"header\":{\"category\": \"it\",\"languages\": \"id\",\"pop\": \"null\"}}","header","category","pop","languages");
		JsonUtil.jsonElementValue("{\"category\": \"it\",\"languages\": \"id\",\"pop\": \"null\"}","category","pop","languages");
		//JsonUtil.jsonArrayValue("C:/Users/jinwx.ICITY/Desktop/new4.json","languages");
	}
}
