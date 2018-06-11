package com.test.dataprovider;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.test.util.OperateOracle;

public class CountSuoZhan {
	static List<Map<String,String>> list;
	Map<String, Integer> rmmap;
	public void setrmSuoZhanCount(){
		String sql = "SELECT SUONAME \"SUOZHAN\",COUNT(*)\"COUNT\" FROM REMOTE_VIEW "
				+ "GROUP BY SUONAME "
				+ "UNION "
				+ "SELECT ZHANNAME \"SUOZHAN\",COUNT(*)\"COUNT\" FROM REMOTE_VIEW "
				+ "GROUP BY ZHANNAME";
		list=new OperateOracle().selectData(sql);
	}
	//获得所有所站的数量
	public Map<String, Integer> getSuoZhan(){
		rmmap=new HashMap<String,Integer>();
		new CountSuoZhan().setrmSuoZhanCount();
		String count = null;
		String suozhan = null;
		for(int i=0;i<list.size();i++){
			Map<String,String> map=list.get(i);
			Iterator<String> it=map.keySet().iterator();
			count=map.get("COUNT");
			suozhan=map.get("SUOZHAN");
			rmmap.put(suozhan, Integer.parseInt(count));
		}
		return rmmap;
	}
	//根据所站名获得数量
	public Integer getSuoZhan(String str){
		rmmap=new HashMap<String,Integer>();
		new CountSuoZhan().setrmSuoZhanCount();
		String count = null;
		String suozhan = null;
		for(int i=0;i<list.size();i++){
			Map<String,String> map=list.get(i);
			Iterator<String> it=map.keySet().iterator();
			count=map.get("COUNT");
			suozhan=map.get("SUOZHAN");
			if(suozhan.equals(str)){
				return Integer.parseInt(count);
			}
		}
		return null;
	}
}
