package com.test.testdata;

import java.util.List;

import com.test.util.HttpClient;
import com.test.util.JsonUtil;
import com.test.util.OperateOracle;
import com.test.util.OperateProperties;

public class SummaryInfoAll {
	public static String rm_count;
	private static String rm_count_sql="";
	public static String rb_count;
	private static String rb_count_sql="";
	public static String uasso_count;
	private static String uasso_count_sql="";
	public static String rmalarm_count;
	private static String rmalarm_count_sql="";
	public static String rbalarm_count;
	private static String rbalarm_count_sql="";
	public static List<String> listAll;
	public static void setInfoAll(){
		  //从配置文件中读取sql语句
		rm_count_sql=OperateProperties.getValue("E:/test/workspace/testNG/config/SQLS", "remote_meter_count");
		rb_count_sql=OperateProperties.getValue("E:/test/workspace/testNG/config/SQLS", "revenue_meter_count");
		uasso_count_sql=OperateProperties.getValue("E:/test/workspace/testNG/config/SQLS", "uasso_count_sql");
		rmalarm_count_sql=OperateProperties.getValue("E:/test/workspace/testNG/config/SQLS", "rmalarm_count_sql");
		rbalarm_count_sql=OperateProperties.getValue("E:/test/workspace/testNG/config/SQLS", "rbalarm_count_sql");
		//从数据库中获得考核表数量
		rm_count=new OperateOracle().selectDataCount(rm_count_sql);
		rb_count=new OperateOracle().selectDataCount(rb_count_sql);
		uasso_count=new OperateOracle().selectDataCount(uasso_count_sql);
		rmalarm_count=new OperateOracle().selectDataCount(rmalarm_count_sql);
		rbalarm_count=new OperateOracle().selectDataCount(rbalarm_count_sql);
		//从接口中获取数量
		String strall=new HttpClient().doGet("http://192.168.0.40:9013/webInfo/All");
		listAll=JsonUtil.jsonElementValue(strall,"khbNum",
				"unitNum","unallocatedNum","khbAlarm","unitAlarm");
		System.out.println(listAll.get(0)+"\t"+listAll.get(1)+"\t"+listAll.get(2)+"\t"+listAll.get(3)+"\t"+listAll.get(4));
	} 
}
