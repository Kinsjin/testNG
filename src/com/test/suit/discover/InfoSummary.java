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
		  //�������ļ��ж�ȡsql���
		rm_count_sql=OperateProperties.getValue("E:/test/workspace/testNG/config/SQLS", "remote_meter_count");
		rb_count_sql=OperateProperties.getValue("E:/test/workspace/testNG/config/SQLS", "revenue_meter_count");
		uasso_count_sql=OperateProperties.getValue("E:/test/workspace/testNG/config/SQLS", "uasso_count_sql");
		rmalarm_count_sql=OperateProperties.getValue("E:/test/workspace/testNG/config/SQLS", "rmalarm_count_sql");
		rbalarm_count_sql=OperateProperties.getValue("E:/test/workspace/testNG/config/SQLS", "rbalarm_count_sql");
		//�����ݿ��л�ÿ��˱�����
		rm_count=new OperateOracle().selectDataCount(rm_count_sql);
		rb_count=new OperateOracle().selectDataCount(rb_count_sql);
		uasso_count=new OperateOracle().selectDataCount(uasso_count_sql);
		rmalarm_count=new OperateOracle().selectDataCount(rmalarm_count_sql);
		rbalarm_count=new OperateOracle().selectDataCount(rbalarm_count_sql);
		//�ӽӿ��л�ȡ����
		String str=new HttpClient().doGet("http://192.168.0.40:9013/webInfo/All");
		list=JsonUtil.jsonElementValue(str,"khbNum",
				"unitNum","unallocatedNum","khbAlarm","unitAlarm");
		System.out.println(list.get(0)+"\t"+list.get(1)+"\t"+list.get(2)+"\t"+list.get(3)+"\t"+list.get(4));
	} 
	@Test
  	public void rmmeterCount() {
		//�ȶԿ��˱�����
	  Assert.assertEquals(rm_count, list.get(0));
	}
	@Test
	public void rbmeterCount() {
		//�ȶԵ�λ�û�����
	  Assert.assertEquals(rb_count, list.get(1));

	}
	@Test
	public void noareaCount(){
		//�ȶ�δ��������
		Assert.assertEquals(uasso_count,list.get(2));
		
	}
	@Test
	public void rmalarm_Count(){
		//�ȶԿ��˱��������
		Assert.assertEquals(rmalarm_count,list.get(3));
		
	}
	@Test
	public void rbalarm_Count(){
		//�ȶԵ�λ�û���������
		Assert.assertEquals(rbalarm_count,list.get(4));
	}
}
