package com.test.suit.discover;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.dataprovider.RMCountSuoZhan;
import com.test.testdata.SummaryInfoAll;
import com.test.testdata.SummaryInfoDmaAll;
import com.test.util.OperateProperties;

public class InfoSummaryTests {
	SummaryInfoDmaAll dmaALL;
	Map<String,Integer>mapAll;
	@BeforeGroups
	public void beforeGroup(){}
	@BeforeTest
	public void declare(){
		new SummaryInfoAll();
		SummaryInfoAll.setInfoAll();
		dmaALL=new SummaryInfoDmaAll();
		dmaALL.setInfoDmaAll();
		System.out.println("");
		mapAll=new HashMap<String,Integer>();
		//所有所站表数量
		mapAll.putAll(new RMCountSuoZhan().getRMSiteCount());
		//所有所站故障表数量
		mapAll.putAll(new RMCountSuoZhan().getRMAlarmSiteCount());
		//所有所站dma数量
		mapAll.putAll(new RMCountSuoZhan().getRMDmaCount());
		//所欲所站设备数量
		mapAll.putAll(new RMCountSuoZhan().getRMDeviceCount());
		//所有所站故障设备数量
		mapAll.putAll(new RMCountSuoZhan().getRMAlarmDeviceCount());
	}
	@Test(enabled = false,groups= "CountAll" )
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
	@Test//(enabled = false)//比较闸北所
	public void dmaAllHPCheck(){
		/*名称：name
		 * 表数量：value
		 * dma数量：dmaValue
		 * 故障数量：fvalue
		 * 山科数量：svalue
		 * 拓安信数量:tvalue
		 * 立信数量:lvalue
		 * 宁波东海考核表数量:nvalue
		 * 肯特数量:kvalue
		 * 山科故障数量sfvalue
		 * 拓安信故障数量tfvalue
		 * 立信故障数量:lfvalue
		 * 宁波东海故障数量:nfvalue
		 * 肯特故障数量:kfvalue
		 */
		//System.out.println(mapAll.get("黄浦供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("name"), "黄浦");
		Assert.assertEquals(dmaALL.DSlist.get(0).get("value"),mapAll.get("黄浦供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("dmaValue"),mapAll.get("黄浦供水管理所DMA"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("fvalue"),mapAll.get("黄浦供水管理所故障"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("svalue"),mapAll.get("黄浦供水管理所山科"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("tvalue"),mapAll.get("黄浦供水管理所拓安信"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("lvalue"),mapAll.get("黄浦供水管理所立信"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("nvalue"),mapAll.get("黄浦供水管理所宁波东海"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("kvalue"),mapAll.get("黄浦供水管理所肯特"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("sfvalue"),mapAll.get("黄浦供水管理所故障山科"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("tfvalue"),mapAll.get("黄浦供水管理所故障拓安信"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("lfvalue"),mapAll.get("黄浦供水管理所故障立信"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("nfvalue"),mapAll.get("黄浦供水管理所故障宁波东海"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("kfvalue"),mapAll.get("黄浦供水管理所故障肯特"));
	}
	public void dmaAllXHCheck(){
		/*Assert.assertEquals(dmaALL.DSlist.get(1).get("name"), "徐汇");
		Assert.assertEquals(dmaALL.DSlist.get(1).get("value"),new CountSuoZhan().getRMSiteCount("徐汇供水管理所"));	
		Assert.assertEquals(dmaALL.DSlist.get(2).get("name"), "虹口");
		Assert.assertEquals(dmaALL.DSlist.get(2).get("value"),new CountSuoZhan().getRMSiteCount("虹口供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(3).get("name"), "普陀");
		Assert.assertEquals(dmaALL.DSlist.get(3).get("value"),new CountSuoZhan().getRMSiteCount("普陀供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(4).get("name"), "长宁");
		Assert.assertEquals(dmaALL.DSlist.get(4).get("value"),new CountSuoZhan().getRMSiteCount("长宁供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(5).get("name"), "闸北");
		Assert.assertEquals(dmaALL.DSlist.get(5).get("value"),new CountSuoZhan().getRMSiteCount("闸北供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(6).get("name"), "杨浦");
		Assert.assertEquals(dmaALL.DSlist.get(6).get("value"),new CountSuoZhan().getRMSiteCount("杨浦供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(7).get("name"), "宝山");
		Assert.assertEquals(dmaALL.DSlist.get(7).get("value"),new CountSuoZhan().getRMSiteCount("宝山供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(8).get("name"), "闵行");
		Assert.assertEquals(dmaALL.DSlist.get(8).get("value"),new CountSuoZhan().getRMSiteCount("闵行供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(9).get("name"), "青东");
		Assert.assertEquals(dmaALL.DSlist.get(9).get("value"),new CountSuoZhan().getRMSiteCount("青东供水管理所"));
		Assert.assertEquals(dmaALL.DSlist.get(10).get("name"), "松北");
		Assert.assertEquals(dmaALL.DSlist.get(10).get("value"),new CountSuoZhan().getRMSiteCount("松北供水管理所"));
		*/	
	}
	@Test(enabled = false)
	public void dmaAllHKCheck(){}
	@Test(enabled = false)
	public void dmaAllPTCheck(){}
	@Test(enabled = false) //比较长江站站点
	public void dmaAllHP_SITE_Check(){
		Assert.assertEquals(dmaALL.DZlist.get(0).get("name"), "长江站");
		Assert.assertEquals(dmaALL.DZlist.get(0).get("value"),mapAll.get("长江站"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("dmaValue"),mapAll.get("长江站DMA"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("fvalue"),mapAll.get("长江站故障"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("svalue"),mapAll.get("长江站山科"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("tvalue"),mapAll.get("长江站安信"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("lvalue"),mapAll.get("长江站立信"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("nvalue"),mapAll.get("长江站宁波东海"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("kvalue"),mapAll.get("长江站肯特"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("sfvalue"),mapAll.get("长江站故障山科"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("tfvalue"),mapAll.get("长江站故障拓安信"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("lfvalue"),mapAll.get("长江站故障立信"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("nfvalue"),mapAll.get("长江站故障宁波东海"));
		Assert.assertEquals(dmaALL.DSlist.get(0).get("kfvalue"),mapAll.get("长江站故障肯特"));
	}
}
