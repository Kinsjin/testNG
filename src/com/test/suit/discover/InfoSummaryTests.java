package com.test.suit.discover;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.dataprovider.CountSuoZhan;
import com.test.testdata.SummaryInfoAll;
import com.test.testdata.SummaryInfoDmaAll;
import com.test.util.OperateProperties;

public class InfoSummaryTests {
	public static SummaryInfoDmaAll dmaALL;
	@BeforeTest
	public void declare(){
		new SummaryInfoAll();
		SummaryInfoAll.setInfoAll();
		dmaALL=new SummaryInfoDmaAll();
		dmaALL.setInfoDmaAll();
		System.out.println("");
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
		//比对考核表故障数量
		Assert.assertEquals(SummaryInfoAll.rmalarm_count,SummaryInfoAll.listAll.get(3));
		
	}
	@Test(enabled = false)
	public void rbalarm_Count(){
		//比对单位用户故障数量
		Assert.assertEquals(SummaryInfoAll.rbalarm_count,SummaryInfoAll.listAll.get(4));
	}
	@Test(enabled = false)
	public void dmaAllHeaders(){
		//比对考核表表头
		String dmaallheaders=OperateProperties.getValue("E:/test/workspace/testNG/config/applilcation.properties","dmaallheaders");
		Assert.assertEquals(SummaryInfoDmaAll.headers.toString(), dmaallheaders);
	}
	@Test//(enabled = false)//比较所
	public void dmaAllHPCheck(){
		Assert.assertEquals(dmaALL.DSlist.get(0).get("name"), "黄浦");
		Assert.assertEquals(dmaALL.DSlist.get(0).get("value"),new CountSuoZhan().getSuoZhan("黄浦供水管理所"));		
		Assert.assertEquals(dmaALL.DSlist.get(1).get("name"), "徐汇");
		Assert.assertEquals(dmaALL.DSlist.get(1).get("value"),new CountSuoZhan().getSuoZhan("徐汇供水管理所"));	
		Assert.assertEquals(dmaALL.DSlist.get(2).get("name"), "虹口");
		Assert.assertEquals(dmaALL.DSlist.get(2).get("value"),new CountSuoZhan().getSuoZhan("虹口供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(3).get("name"), "普陀");
		Assert.assertEquals(dmaALL.DSlist.get(3).get("value"),new CountSuoZhan().getSuoZhan("普陀供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(4).get("name"), "长宁");
		Assert.assertEquals(dmaALL.DSlist.get(4).get("value"),new CountSuoZhan().getSuoZhan("长宁供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(5).get("name"), "闸北");
		Assert.assertEquals(dmaALL.DSlist.get(5).get("value"),new CountSuoZhan().getSuoZhan("闸北供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(6).get("name"), "杨浦");
		Assert.assertEquals(dmaALL.DSlist.get(6).get("value"),new CountSuoZhan().getSuoZhan("杨浦供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(7).get("name"), "宝山");
		Assert.assertEquals(dmaALL.DSlist.get(7).get("value"),new CountSuoZhan().getSuoZhan("宝山供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(8).get("name"), "闵行");
		Assert.assertEquals(dmaALL.DSlist.get(8).get("value"),new CountSuoZhan().getSuoZhan("闵行供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(9).get("name"), "青东");
		Assert.assertEquals(dmaALL.DSlist.get(9).get("value"),new CountSuoZhan().getSuoZhan("青东供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(10).get("name"), "松北");
		Assert.assertEquals(dmaALL.DSlist.get(10).get("value"),new CountSuoZhan().getSuoZhan("松北供水管理所"));
		
	}
	@Test(enabled = false) //比较站点
	public static void dmaAllHP_SITE_Check(){
		Assert.assertEquals(dmaALL.DZlist.get(0).get("name"), "长江站");
		Assert.assertEquals(dmaALL.DZlist.get(0).get("value"),356);
		Assert.assertEquals(dmaALL.DZlist.get(0).get("name"), "长江站");
		Assert.assertEquals(dmaALL.DZlist.get(0).get("value"),356);
		Assert.assertEquals(dmaALL.DZlist.get(0).get("name"), "长江站");
		Assert.assertEquals(dmaALL.DZlist.get(0).get("value"),356);
		Assert.assertEquals(dmaALL.DZlist.get(0).get("name"), "长江站");
		Assert.assertEquals(dmaALL.DZlist.get(0).get("value"),356);
	}
}
