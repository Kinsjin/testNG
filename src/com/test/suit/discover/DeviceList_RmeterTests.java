package com.test.suit.discover;

import org.testng.annotations.Test;

import com.test.testdata.DeviceListUrl;

import org.testng.annotations.BeforeTest;

public class DeviceList_RmeterTests {
  @Test
  public void rmList() {
	  System.out.println(DeviceListUrl.RM_count_CJ);
  }
  @Test
  public void emList(){
	  System.out.println(DeviceListUrl.EM_count_CJ);
  }
  public void noasso(){
	  
  }
  @BeforeTest
  public void beforeTest() {
	  new DeviceListUrl();
	  DeviceListUrl.setInfo();  
  }

}
