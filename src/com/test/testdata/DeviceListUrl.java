package com.test.testdata;

import com.test.util.HttpClient;
import com.test.util.JsonUtil;
import com.test.util.OperateProperties;

public class DeviceListUrl {
	private static String  url_tree;
	private static String  url1_post;
	private static String  url2_post;
	private static String  url3_post;
	public static String treeResult;
	public static String url1ResultRmInfo;
	public static String url2ResultEmInfo;
	public static int RM_count_CJ;
	public static int EM_count_CJ; 
	
	//树结构
	public void getDeviceListTree(){
		url_tree=new HttpClient().doGet("http://192.168.0.40:9013/web/hierarchy/view?ruleName=remotemeter_dailyreport");
	}
	//考核表
	public void getDeviceListUrl1(String post){
		url1_post=new HttpClient().doPost("http://192.168.0.40:9013/web/remote_meters/metered_area/data_ui/1", post);
	}
	//单位用户
	public void getDeviceListUrl2(String post){
		url2_post=new HttpClient().doPost("http://192.168.0.40:9013/web/remote_meters/metered_area/data_ui/2", post);
	}
	//未分配
	public void getDeviceListUrl3(String post){
		url3_post=new HttpClient().doPost("http://192.168.0.40:9013/web/remote_meters/metered_area/data_ui/3", post);
	}
	public static void setInfo(){
		//树结构内容
		new DeviceListUrl().getDeviceListTree();
		treeResult=url_tree.replaceAll("\n|\r| ","");
		//System.out.println(treeResult);
		//考核表显示列表
		new DeviceListUrl().getDeviceListUrl1("[]");
		url1ResultRmInfo=url1_post.replaceAll("\n|\r| ","");
		//System.out.println(url1ResultRmInfo);
		//考核表长江站
		new DeviceListUrl().getDeviceListUrl1("[\"2abfccd0f01186a6223fa005a4f90f29\"]");//长江站
		String url1ResultRmDetail=url1_post.replaceAll("\n|\r| ","");
		RM_count_CJ=JsonUtil.jsonArraySize(JsonUtil.getJsonArray(url1ResultRmDetail,"remoteMeters"));
		//单位用户
		new DeviceListUrl().getDeviceListUrl2("[]");
		url2ResultEmInfo=url2_post.replaceAll("\n|\r| ","");
		System.out.println(url1ResultRmInfo);
		//考核表长江站
		new DeviceListUrl().getDeviceListUrl2("[\"2abfccd0f01186a6223fa005a4f90f29\"]");//长江站
		String url21ResultEmDetail=url2_post.replaceAll("\n|\r| ","");
		EM_count_CJ=JsonUtil.jsonArraySize(JsonUtil.getJsonArray(url21ResultEmDetail,"remoteMeters"));
		

	}
}
