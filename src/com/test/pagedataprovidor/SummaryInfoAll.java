package com.test.pagedataprovidor;

import java.util.List;

import com.test.setting.GlobalSetting;
import com.test.util.HttpClient;
import com.test.util.JsonUtil;

public class SummaryInfoAll {
	public static List<String> listAll;
    private static GlobalSetting globalSetting = GlobalSetting.getInstance();
	public  void setInfoAll(){
		//从接口获取实际值
		String strall=new HttpClient().doGet("http://192.168.0.40:9013/webInfo/All",globalSetting.getCookie());
		listAll=JsonUtil.jsonElementValue(strall,"khbNum",
				"unitNum","unallocatedNum","khbAlarm","unitAlarm");
	} 
}
