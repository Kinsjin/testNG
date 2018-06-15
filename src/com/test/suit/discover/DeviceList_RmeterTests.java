package com.test.suit.discover;

import org.testng.annotations.Test;

import com.test.pagedataprovidor.DeviceListUrl;
import com.test.util.OperateProperties;

import java.io.UnsupportedEncodingException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class DeviceList_RmeterTests {
	DeviceListUrl deviceListUrl;
  @Test(enabled=false)
  public void treeList() {
	  //deviceListUrl.setTreeInfo();
	  System.out.println(deviceListUrl.setTreeInfo());
	  String treeList_Str=OperateProperties.getValue("E:/test/workspace/testNG/config/applilcation.properties", "deviceList_Tree");
	  Assert.assertEquals(deviceListUrl.setTreeInfo(), treeList_Str);
  }
  @Test(enabled=false)
  public void rmList() {
	  //比对长江站下考核表数量和表卡信息title
	  deviceListUrl.setRMInfo();
	  //System.out.println(Integer.toString(DeviceListUrl.RM_count_CJ));
	  Assert.assertEquals(Integer.toString(DeviceListUrl.RM_count_CJ), deviceListUrl.getOracleInfo()[0]);
	  String rmList_Str=OperateProperties.getValue("E:/test/workspace/testNG/config/applilcation.properties", "deviceList_RmInfo");
	  Assert.assertEquals(deviceListUrl.setRMInfo(),rmList_Str);
  }
  @Test(enabled=false)
  public void emList(){
	  //比对长江站下单位用户数量和表卡信息title
	  deviceListUrl.setEMInfo();
	  Assert.assertEquals(Integer.toString(DeviceListUrl.EM_count_CJ), deviceListUrl.getOracleInfo()[1]);
	  String emList_Str=OperateProperties.getValue("E:/test/workspace/testNG/config/applilcation.properties", "deviceList_EmInfo");
	  Assert.assertEquals(DeviceListUrl.url2ResultEmInfo,emList_Str);
	  //System.out.println(deviceListUrl.EM_count_CJ);
  }
  @Test//(enabled=false)
  public void noasso(){
	  deviceListUrl.setNAInfo();
	  //Assert.assertEquals(Integer.toString(DeviceListUrl.NA_count), deviceListUrl.getOracleInfo()[2]);
	  //String naList_Str=OperateProperties.getValue("E:/test/workspace/testNG/config/applilcation.properties", "deviceList_NAInfo");
	  //Assert.assertEquals(DeviceListUrl.url3ResultNAInfo,naList_Str);
	  //System.out.println(deviceListUrl.NA_count_CJ);
  }
  @BeforeTest
  public void beforeTest() {
	  deviceListUrl = new DeviceListUrl(); 
  }

}
