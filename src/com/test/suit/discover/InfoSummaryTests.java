package com.test.suit.discover;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.testdata.SummaryInfoAll;
import com.test.testdata.SummaryInfoDmaAll;
import com.test.util.OperateProperties;

import junit.framework.Assert;

public class InfoSummaryTests {
	public static SummaryInfoDmaAll dmaALL;
	@BeforeTest
	public void declare(){
		//new SummaryInfoAll();
		//SummaryInfoAll.setInfoAll();
		dmaALL=new SummaryInfoDmaAll();
		dmaALL.setInfoDmaAll();
		System.out.println("校验信息汇总页面---------------------------");
	}
	@Test(enabled = false)
  	public void rmmeterCount() {
		//比对考核表数量
	  Assert.assertEquals(SummaryInfoAll.rm_count, SummaryInfoAll.listAll.get(0));
	}
	@Test(enabled = false)
	public void rbmeterCount() {
		//比对单位用户数量
	  Assert.assertEquals(SummaryInfoAll.rb_count, SummaryInfoAll.listAll.get(1));

	}
	@Test(enabled = false)
	public void noareaCount(){
		//比对未分配数量
		Assert.assertEquals(SummaryInfoAll.uasso_count,SummaryInfoAll.listAll.get(2));
		
	}
	@Test(enabled = false)
	public void rmalarm_Count(){
		//比对考核表故障总数
		Assert.assertEquals(SummaryInfoAll.rmalarm_count,SummaryInfoAll.listAll.get(3));
		
	}
	@Test(enabled = false)
	public void rbalarm_Count(){
		//比对单位用户故障总数
		Assert.assertEquals(SummaryInfoAll.rbalarm_count,SummaryInfoAll.listAll.get(4));
	}
	//检查dmaall接口
	@Test//检查表头
	public void dmaAllHeaders(){
		//比对接口dmaALL获取到的headers
		String dmaallheaders=OperateProperties.getValue("E:/test/workspace/testNG/config/applilcation.properties","dmaallheaders");
		Assert.assertEquals(SummaryInfoDmaAll.headers.toString(), dmaallheaders);
	}
	@Test//黄埔所
	public void dmaAllHPCheck(){
		Assert.assertEquals(dmaALL.Slist.get(0).get("name"), "黄浦");
		Assert.assertEquals(dmaALL.Slist.get(0).get("value"),1017);
		Assert.assertEquals(dmaALL.Slist.get(1).get("name"), "徐汇");
		Assert.assertEquals(dmaALL.Slist.get(1).get("value"),905);
	}
	@Test(enabled = false) //站
	public static void dmaAllHP_SITE_Check(){
		Assert.assertEquals(dmaALL.ZQXmap.get("name"), "瞿溪站");
		Assert.assertEquals(dmaALL.ZQXmap.get("value"),356);
	}
}
