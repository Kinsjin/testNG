package com.test.suit.discover;

import java.util.List;

import org.testng.annotations.Test;

import com.test.util.HttpClient;
import com.test.util.JsonUtil;

import junit.framework.Assert;

public class InfoSummary {
  @Test
  public void meterCount() {
	  String str=new HttpClient().doGet("http://192.168.0.40:9013/webInfo/All");
	  new JsonUtil();
	//System.out.println(str);
	  List<String> list=JsonUtil.jsonElementValue(str,"khbNum",
			  "unitNum","unallocatedNum","khbAlarm","unitAlarm");
	 // System.out.println(list)
	  Assert.assertEquals("6647", list.get(0));
	  System.out.println("¿¼ºË±íÊýÁ¿£º"+list.get(0));
	  new JsonUtil();
	JsonUtil.jsonArrayValue("C:/Users/jinwx.ICITY/Desktop/new2.json","languages");
  }
}
