package com.test.suit.discover;

import java.util.List;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.util.HttpClient;
import com.test.util.JsonUtil;
import com.test.util.OperateOracle;
import com.test.util.OperateProperties;

import junit.framework.Assert;

public class InfoSummary {
	private static String rm_count;
	private static String rm_count_sql="";
	private static String rb_count;
	private static String rb_count_sql="";
	private static String uasso_count;
	private static String uasso_count_sql="";
	private static String rmalarm_count;
	private static String rmalarm_count_sql="";
	private static String rbalarm_count;
	private static String rbalarm_count_sql="";
	private static List<String> list;
	@BeforeTest
	public void setInfo(){
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
		String str=new HttpClient().doGet("http://192.168.0.40:9013/webInfo/All");
		list=JsonUtil.jsonElementValue(str,"khbNum",
				"unitNum","unallocatedNum","khbAlarm","unitAlarm");
		System.out.println(list.get(0)+"\t"+list.get(1)+"\t"+list.get(2)+"\t"+list.get(3)+"\t"+list.get(4));
	} 
	@Test
  	public void rmmeterCount() {
		//比对考核表数量
	  Assert.assertEquals(rm_count, list.get(0));
	}
	@Test
	public void rbmeterCount() {
		//比对单位用户数量
	  Assert.assertEquals(rb_count, list.get(1));

	}
	@Test
	public void noareaCount(){
		//比对未分配数量
		Assert.assertEquals(uasso_count,list.get(2));
		
	}
	@Test
	public void rmalarm_Count(){
		//比对考核表故障总数
		Assert.assertEquals(rmalarm_count,list.get(3));
		
	}
	@Test
	public void rbalarm_Count(){
		//比对单位用户故障总数
		Assert.assertEquals(rbalarm_count,list.get(4));
	}
}
