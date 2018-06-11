package com.test.testdata;

import com.test.util.HttpClient;
import com.test.util.JsonUtil;
import com.test.util.OperateOracle;

public class DeviceListUrl {
	private  String  url_tree;
	private  String  url1_post;
	private  String  url2_post;
	private  String  url3_get;
	public   String treeResult;
	public   String url1ResultRmInfo;
	public  static String url2ResultEmInfo;
	public  static String url3ResultNAInfo;
	public  static int RM_count_CJ;//长江站考核表数量
	public  static int EM_count_CJ;//长江站单位用户数量
	public  static int NA_count;//未分配数量
	String rm_Ocount;//数据库长江站考核表数量
	String em_Ocount;//数据库长江站单位用户数量
	String na_Ocount;//数据库未分配数量
	
	//设备列表树结构
	public String  getDeviceListTree(){
		url_tree=new HttpClient().doGet("http://192.168.0.40:9013/web/hierarchy/view?ruleName=remotemeter_dailyreport");
		return url_tree;
	}
	//设备列表考核表列表
	public String getDeviceListUrl1(String post){
		url1_post=new HttpClient().doPost("http://192.168.0.40:9013/web/remote_meters/metered_area/data_ui/1", post);
		return url1_post;
	}
	//设备列表单位用户列表
	public String getDeviceListUrl2(String post){
		url2_post=new HttpClient().doPost("http://192.168.0.40:9013/web/remote_meters/metered_area/data_ui/2", post);
		return url2_post;
	}
	//设备列表未分配列表
	public String getDeviceListUrl3(){
		url3_get=new HttpClient().doGet("http://192.168.0.40:9013/web/remote_meters/data_ui/3");
		return url3_get;
	}
	public String setTreeInfo(){
		//树结构
		treeResult=new DeviceListUrl().getDeviceListTree().replaceAll("\n|\r| ","");
		//System.out.println(treeResult);	
		return treeResult;
	}
	public String setRMInfo(){
		//考核表
		url1ResultRmInfo=new DeviceListUrl().getDeviceListUrl1("[]").replaceAll("\n|\r| ","");
		//System.out.println(url1ResultRmInfo);
		//"[\"2abfccd0f01186a6223fa005a4f90f29\"]"长江站
		String url1ResultRmDetail=new DeviceListUrl().getDeviceListUrl1("[\"2abfccd0f01186a6223fa005a4f90f29\"]").replaceAll("\n|\r| ","");
		//System.out.println(url1ResultRmDetail);
		RM_count_CJ=JsonUtil.jsonArraySize(JsonUtil.getJsonArray(url1ResultRmDetail,"remoteMeters"));
		//System.out.println(RM_count_CJ);
		return url1ResultRmInfo;
	}
	public void setEMInfo(){
		//单位用户
		//new DeviceListUrl().getDeviceListUrl2("[]");
		url2ResultEmInfo=new DeviceListUrl().getDeviceListUrl2("[]").replaceAll("\n|\r| ","");
		//长江站
		String url2ResultEmDetail=new DeviceListUrl().getDeviceListUrl2("[\"2abfccd0f01186a6223fa005a4f90f29\"]").replaceAll("\n|\r| ","");
		EM_count_CJ=JsonUtil.jsonArraySize(JsonUtil.getJsonArray(url2ResultEmDetail,"remoteMeters"));
	}
	public void setNAInfo(){
		//未分配
		url3ResultNAInfo=new DeviceListUrl().getDeviceListUrl3().replaceAll("\n|\r| ","");
		
		System.out.println(url3ResultNAInfo);
		//new DeviceListUrl().getDeviceListUrl3("[\"2abfccd0f01186a6223fa005a4f90f29\"]");//长江站
		//String url3ResultEmDetail=url3_post.replaceAll("\n|\r| ","");
		//NA_count=JsonUtil.jsonArraySize(JsonUtil.getJsonArray(url3ResultEmDetail,"remoteMeters"));
	}
	public String[] getOracleInfo(){		
		String rm_Ocount = null;//长江站考核表数量
		String em_Ocount = null;//长江站单位用户数量
		String na_Ocount = null;//长江站未分配数量
		String sql1="SELECT * FROM REMOTE_VIEW WHERE ZHANNAME='长江站'";
		String sql2="SELECT * FROM CONT_VIEW WHERE ZHAN='长江站'";
		String sql3="SELECT * FROM HM_CEDIAN_AREA_ASSO JOIN RM_CEDIAN_DEVICE_ASSO "
				+ "ON HM_CEDIAN_AREA_ASSO.CEDIANID=RM_CEDIAN_DEVICE_ASSO.CEDIANID "
				+ "JOIN RM_METERASSERTDATALOGGERASSO "
				+ "ON RM_CEDIAN_DEVICE_ASSO.DEVICEID=RM_METERASSERTDATALOGGERASSO.DATALOGGER "
				+ "WHERE HM_CEDIAN_AREA_ASSO.MAID='0000000000000000' "
				+ "AND RM_CEDIAN_DEVICE_ASSO.STOPTIME IS NULL "
				+ "AND RM_METERASSERTDATALOGGERASSO.STOPTIME IS NULL";
		rm_Ocount=new OperateOracle().selectDataCount(sql1);
		//System.out.println(rm_Ocount);
		em_Ocount=new OperateOracle().selectDataCount(sql2);
		//System.out.println(em_Ocount);
		na_Ocount=new OperateOracle().selectDataCount(sql3);
		//System.out.println(na_Ocount);
		String[] str=new String[]{rm_Ocount,em_Ocount,na_Ocount};
		return str;		
	}
}
