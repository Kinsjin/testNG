package com.test.testdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.test.util.HttpClient;
import com.test.util.JsonUtil;

public class SummaryInfoDmaAll {
	public static JsonArray headers;
	public Map<String, Object> SHPmap;
	public Map<String, Object> SXHmap;
	public Map<String, Object> SHKmap;
	public Map<String, Object> SPTmap;
	public Map<String, Object> SCNmap;
	public Map<String, Object> SZBmap;
	public Map<String, Object> SYPmap;
	public Map<String, Object> SBSmap;
	public Map<String, Object> SMHmap;
	public Map<String, Object> SQDmap;
	public Map<String, Object> SSBmap;
	public ArrayList<Map<String, Object>> Slist;
	public ArrayList<Map<String, Object>> Zlist;
	public JsonArray ZHAN;
	public Map<String, Object> ZQXmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;
	//public Map<String, Object> SSBmap;


	/*suo：name
	 * 表个数：value
	 * dma个数 ：dmaValue
	 * 故障个数：fvalue
	 * 山科表数量：svalue
	 * 拓安信表个数:tvalue
	 * 立信表个数:lvalue
	 * 宁波东海表个数:nvalue
	 * 肯特表个数:kvalue
	 * 山科故障表个数：sfvalue
	 * 拓安信故障表个数tfvalue
	 * 立信故障表个数:lfvalue
	 * 宁波东海故障表个数:nfvalue
	 * 肯特故障表个数:kfvalue
	 */
	public  void setInfoDmaAll(){
		int j=0;
		JsonArray entries;
		String DMAALLURL=new HttpClient().doGet("http://192.168.0.40:9013/webInfo/DmaAll");
		headers=JsonUtil.getJsonArray(DMAALLURL, "headers");
		entries=JsonUtil.getJsonArray(DMAALLURL, "entries");
		Slist=new ArrayList<Map<String, Object>>();
		SHPmap=new HashMap<String, Object>();
		SXHmap=new HashMap<String, Object>();
		SHKmap=new HashMap<String, Object>();
		SPTmap=new HashMap<String, Object>();
		SCNmap=new HashMap<String, Object>();
		SZBmap=new HashMap<String, Object>();
		SYPmap=new HashMap<String, Object>();
		SBSmap=new HashMap<String, Object>();
		SMHmap=new HashMap<String, Object>();
		SQDmap=new HashMap<String, Object>();
		SSBmap=new HashMap<String, Object>();
		Slist.add(SHPmap);
		Slist.add(SXHmap);
		Slist.add(SHKmap);
		Slist.add(SPTmap);
		Slist.add(SCNmap);
		Slist.add(SZBmap);
		Slist.add(SYPmap);
		Slist.add(SBSmap);
		Slist.add(SMHmap);
		Slist.add(SQDmap);
		Slist.add(SSBmap);
		ZQXmap=new HashMap<String, Object>();
		Zlist.add(ZQXmap);
		for(int i=0;i<entries.size();i++){
			//获取所有所的信息
			Slist.get(i).put("name", JsonUtil.jsonArrayValue(entries,i).get("name").getAsString());
			Slist.get(i).put("value", JsonUtil.jsonArrayValue(entries,i).get("value").getAsInt());
			Slist.get(i).put("dmaValue", JsonUtil.jsonArrayValue(entries,i).get("dmaValue").getAsInt());
			Slist.get(i).put("fvalue", JsonUtil.jsonArrayValue(entries,i).get("fvalue").getAsInt());
			Slist.get(i).put("svalue", JsonUtil.jsonArrayValue(entries,i).get("svalue").getAsInt());
			Slist.get(i).put("tvalue", JsonUtil.jsonArrayValue(entries,i).get("tvalue").getAsInt());
			Slist.get(i).put("lvalue", JsonUtil.jsonArrayValue(entries,i).get("lvalue").getAsInt());
			Slist.get(i).put("nvalue", JsonUtil.jsonArrayValue(entries,i).get("nvalue").getAsInt());
			Slist.get(i).put("kvalue", JsonUtil.jsonArrayValue(entries,i).get("kvalue").getAsInt());
			Slist.get(i).put("sfvalue", JsonUtil.jsonArrayValue(entries,i).get("sfvalue").getAsInt());
			Slist.get(i).put("tfvalue", JsonUtil.jsonArrayValue(entries,i).get("tfvalue").getAsInt());
			Slist.get(i).put("lfvalue", JsonUtil.jsonArrayValue(entries,i).get("lfvalue").getAsInt());
			Slist.get(i).put("nfvalue", JsonUtil.jsonArrayValue(entries,i).get("nfvalue").getAsInt());
			Slist.get(i).put("kfvalue", JsonUtil.jsonArrayValue(entries,i).get("kfvalue").getAsInt());
			//获取所有站点的信息
			for(ZHAN=JsonUtil.getJsonArray(JsonUtil.jsonArrayValue(entries,i).toString(),"children");;j++){
				JsonObject QUXIZHAN=JsonUtil.jsonArrayValue(ZHAN, j);
				System.out.println(QUXIZHAN.toString());
				//String ZQXNAME=QUXIZHAN.get("name").getAsString();
				int ZQXvalueCount = JsonUtil.jsonArrayValue(ZHAN, j).get("value").getAsInt();
				int ZQXdmaValueCount = QUXIZHAN.get("dmaValue").getAsInt();
				int ZQXfvalueCount = QUXIZHAN.get("fvalue").getAsInt();
				int ZQXsvalueCount = QUXIZHAN.get("svalue").getAsInt();
				int ZQXtvalueCount = QUXIZHAN.get("tvalue").getAsInt();
				int ZQXlvalueCount = QUXIZHAN.get("lvalue").getAsInt();
				int ZQXnvalueCount = QUXIZHAN.get("nvalue").getAsInt();
				int ZQXkvalueCount = QUXIZHAN.get("kvalue").getAsInt();
				int ZQXsfvalueCount = QUXIZHAN.get("sfvalue").getAsInt();
				int ZQXtfvalueCount = QUXIZHAN.get("tfvalue").getAsInt();
				int ZQXlfvalueCount = QUXIZHAN.get("lfvalue").getAsInt();
				int ZQXnfvalueCount = QUXIZHAN.get("nfvalue").getAsInt();
				int ZQXkfvalueCount = QUXIZHAN.get("kfvalue").getAsInt();
				Zlist.get(j).put("name", JsonUtil.jsonArrayValue(ZHAN,j).get("value").getAsInt());
				ZQXmap.put("value", JsonUtil.jsonArrayValue(ZHAN,j).get("value").getAsInt());
				ZQXmap.put("dmaValue", ZQXdmaValueCount);
				ZQXmap.put("fvalue", ZQXfvalueCount);
				ZQXmap.put("svalue", ZQXsvalueCount);
				ZQXmap.put("tvalue", ZQXtvalueCount);
				ZQXmap.put("lvalue", ZQXlvalueCount);
				ZQXmap.put("nvalue", ZQXnvalueCount);
				ZQXmap.put("kvalue", ZQXkvalueCount);
				ZQXmap.put("sfvalue", ZQXsfvalueCount);
				ZQXmap.put("tfvalue", ZQXtfvalueCount);
				ZQXmap.put("lfvalue", ZQXlfvalueCount);
				ZQXmap.put("nfvalue", ZQXnfvalueCount);
				ZQXmap.put("kfvalue", ZQXkfvalueCount);
				if(j==ZHAN.size()-1){
					j=0;
					break;
				}
			}
		}
		
		
		//String ZQXNAME=QUXIZHAN.get("name").getAsString();
		//int ZQXvalueCount = QUXIZHAN.get("value").getAsInt();
		//int ZQXdmaValueCount = QUXIZHAN.get("dmaValue").getAsInt();
		//int ZQXfvalueCount = QUXIZHAN.get("fvalue").getAsInt();
		//int ZQXsvalueCount = QUXIZHAN.get("svalue").getAsInt();
		//int ZQXtvalueCount = QUXIZHAN.get("tvalue").getAsInt();
		//int ZQXlvalueCount = QUXIZHAN.get("lvalue").getAsInt();
	//	int ZQXnvalueCount = QUXIZHAN.get("nvalue").getAsInt();
		//int ZQXkvalueCount = QUXIZHAN.get("kvalue").getAsInt();
		//int ZQXsfvalueCount = QUXIZHAN.get("sfvalue").getAsInt();
		//int ZQXtfvalueCount = QUXIZHAN.get("tfvalue").getAsInt();
		//int ZQXlfvalueCount = QUXIZHAN.get("lfvalue").getAsInt();
		//int ZQXnfvalueCount = QUXIZHAN.get("nfvalue").getAsInt();
		//int ZQXkfvalueCount = QUXIZHAN.get("kfvalue").getAsInt();
		//ZQXmap=new HashMap<String, Object>();
		//ZQXmap.put("name", ZQXNAME);
		//ZQXmap.put("value", ZQXvalueCount);
		//ZQXmap.put("dmaValue", ZQXdmaValueCount);
		//ZQXmap.put("fvalue", ZQXfvalueCount);
		//ZQXmap.put("svalue", ZQXsvalueCount);
		//ZQXmap.put("tvalue", ZQXtvalueCount);
		//ZQXmap.put("lvalue", ZQXlvalueCount);
		//ZQXmap.put("nvalue", ZQXnvalueCount);
		//ZQXmap.put("kvalue", ZQXkvalueCount);
		//ZQXmap.put("sfvalue", ZQXsfvalueCount);
		//ZQXmap.put("tfvalue", ZQXtfvalueCount);
		//ZQXmap.put("lfvalue", ZQXlfvalueCount);
		//ZQXmap.put("nfvalue", ZQXnfvalueCount);
		//ZQXmap.put("kfvalue", ZQXkfvalueCount);
		//ZQXmap.put("children", ZQXchildern);
	}
}
