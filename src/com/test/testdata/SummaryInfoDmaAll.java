package com.test.testdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.test.util.HttpClient;
import com.test.util.JsonUtil;

public class SummaryInfoDmaAll {
	public static JsonArray headers;
	public ArrayList<Map<String, Object>> DSlist;
	//public Map<String,Map<String, Object>> Zlist;
	public ArrayList<Map<String, Object>> DZlist;	
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
	public void setInfoDmaAll(){
		JsonArray ZHAN;	
		int count=0;
		int j=0;
		JsonArray entries;
		String DMAALLURL=new HttpClient().doGet("http://192.168.0.40:9013/webInfo/DmaAll");
		headers=JsonUtil.getJsonArray(DMAALLURL, "headers");
		entries=JsonUtil.getJsonArray(DMAALLURL, "entries");
		//SUO
		Map<String, Object> SHPmap=new HashMap<String, Object>();//黄浦
		Map<String, Object> SXHmap=new HashMap<String, Object>();//徐汇
		Map<String, Object> SHKmap=new HashMap<String, Object>();//虹口
		Map<String, Object> SPTmap=new HashMap<String, Object>();//普陀
		Map<String, Object> SCNmap=new HashMap<String, Object>();//长宁
		Map<String, Object> SZBmap=new HashMap<String, Object>();//闸北
		Map<String, Object> SYPmap=new HashMap<String, Object>();//杨浦
		Map<String, Object> SBSmap=new HashMap<String, Object>();//宝山
		Map<String, Object> SMHmap=new HashMap<String, Object>();//闵行
		Map<String, Object> SQDmap=new HashMap<String, Object>();//青东
		Map<String, Object> SSBmap=new HashMap<String, Object>();//松北
		DSlist=new ArrayList<Map<String, Object>>(Arrays.asList(SHPmap,SXHmap,SHKmap,
				SPTmap,SCNmap,SZBmap,SYPmap,SBSmap,SMHmap,SQDmap,SSBmap));
		//ZHAN		
		Map<String, Object> ZQXmap=new HashMap<String, Object>();//瞿溪站
		Map<String, Object> ZBSYmap=new HashMap<String, Object>();//半淞园站
		Map<String, Object> ZXZmap=new HashMap<String, Object>();//新闸站
		Map<String, Object> ZSZmap=new HashMap<String, Object>();//上中站
		Map<String, Object> ZLHmap=new HashMap<String, Object>();//龙华站
		Map<String, Object> ZTYQmap=new HashMap<String, Object>();//天钥桥站
		Map<String, Object> ZHYmap=new HashMap<String, Object>();//汉阳站
		Map<String, Object> ZQYmap=new HashMap<String, Object>();//曲阳站
		Map<String, Object> ZSNmap=new HashMap<String, Object>();//淞南站
		Map<String, Object> ZDCmap=new HashMap<String, Object>();//大场站
		Map<String, Object> ZWNmap=new HashMap<String, Object>();//武宁站
		Map<String, Object> ZZBmap=new HashMap<String, Object>();//真北站
		Map<String, Object> ZYXmap=new HashMap<String, Object>();//银杏站
		Map<String, Object> ZDZABmap=new HashMap<String, Object>();//东诸安浜站
		Map<String, Object> ZFRJmap=new HashMap<String, Object>();//芙蓉江站
		Map<String, Object> ZJAXCmap=new HashMap<String, Object>();//静安新城站
		Map<String, Object> ZPTmap=new HashMap<String, Object>();//平塘站
		Map<String, Object> ZCJmap=new HashMap<String, Object>();//长江站
		Map<String, Object> ZPSmap=new HashMap<String, Object>();//普善站
		Map<String, Object> ZCZmap=new HashMap<String, Object>();//场中站
		Map<String, Object> ZHTmap=new HashMap<String, Object>();//沪太站
		Map<String, Object> ZMYmap=new HashMap<String, Object>();//密云站
		Map<String, Object> ZJPmap=new HashMap<String, Object>();//江浦站
		Map<String, Object> ZSGmap=new HashMap<String, Object>();//市光站
		Map<String, Object> ZGTmap=new HashMap<String, Object>();//顾太站
		Map<String, Object> ZLDmap=new HashMap<String, Object>();//罗店站
		Map<String, Object> ZBYmap=new HashMap<String, Object>();//宝杨站
		Map<String, Object> ZLJmap=new HashMap<String, Object>();//罗泾站
		Map<String, Object> ZJCmap=new HashMap<String, Object>();//江川站
		Map<String, Object> ZXINZmap=new HashMap<String, Object>();//ݷ莘庄站
		Map<String, Object> ZWJmap=new HashMap<String, Object>();//吴泾站
		Map<String, Object> ZXJmap=new HashMap<String, Object>();//徐泾站
		Map<String, Object> ZHXmap=new HashMap<String, Object>();//华新站
		Map<String, Object> ZHCmap=new HashMap<String, Object>();//华漕站
		Map<String, Object> ZSJmap=new HashMap<String, Object>();//泗泾站
		Map<String, Object> ZJTmap=new HashMap<String, Object>();//九亭站
		Map<String, Object> ZXQmap=new HashMap<String, Object>();//新桥站
		DZlist=new ArrayList<Map<String, Object>>(Arrays.asList(ZQXmap,ZBSYmap,ZXZmap,
				ZSZmap,ZLHmap,ZTYQmap,ZHYmap,ZQYmap,ZSNmap,ZDCmap,ZWNmap,ZZBmap,ZYXmap,
				ZDZABmap,ZFRJmap,ZJAXCmap,ZPTmap,ZCJmap,ZPSmap,ZCZmap,ZHTmap,ZMYmap,
				ZJPmap,ZSGmap,ZGTmap,ZLDmap,ZBYmap,ZLJmap,ZJCmap,ZXINZmap,ZWJmap,ZXJmap,
				ZHXmap,ZHCmap,ZSJmap,ZJTmap,ZXQmap));		
		//Zlist.add(ZQXmap);
		for(int i=0;i<entries.size();i++){
			//所的表和数量信息
			DSlist.get(i).put("name", JsonUtil.jsonArrayValue(entries,i).get("name").getAsString());
			DSlist.get(i).put("value", JsonUtil.jsonArrayValue(entries,i).get("value").getAsInt());
			DSlist.get(i).put("dmaValue", JsonUtil.jsonArrayValue(entries,i).get("dmaValue").getAsInt());
			DSlist.get(i).put("fvalue", JsonUtil.jsonArrayValue(entries,i).get("fvalue").getAsInt());
			DSlist.get(i).put("svalue", JsonUtil.jsonArrayValue(entries,i).get("svalue").getAsInt());
			DSlist.get(i).put("tvalue", JsonUtil.jsonArrayValue(entries,i).get("tvalue").getAsInt());
			DSlist.get(i).put("lvalue", JsonUtil.jsonArrayValue(entries,i).get("lvalue").getAsInt());
			DSlist.get(i).put("nvalue", JsonUtil.jsonArrayValue(entries,i).get("nvalue").getAsInt());
			DSlist.get(i).put("kvalue", JsonUtil.jsonArrayValue(entries,i).get("kvalue").getAsInt());
			DSlist.get(i).put("sfvalue", JsonUtil.jsonArrayValue(entries,i).get("sfvalue").getAsInt());
			DSlist.get(i).put("tfvalue", JsonUtil.jsonArrayValue(entries,i).get("tfvalue").getAsInt());
			DSlist.get(i).put("lfvalue", JsonUtil.jsonArrayValue(entries,i).get("lfvalue").getAsInt());
			DSlist.get(i).put("nfvalue", JsonUtil.jsonArrayValue(entries,i).get("nfvalue").getAsInt());
			DSlist.get(i).put("kfvalue", JsonUtil.jsonArrayValue(entries,i).get("kfvalue").getAsInt());
			//站表和数量信息
			for(ZHAN=JsonUtil.getJsonArray(JsonUtil.jsonArrayValue(entries,i).toString(),"children");;j++){
				//JsonObject QUXIZHAN=JsonUtil.jsonArrayValue(ZHAN, j);
				//System.out.println(QUXIZHAN.toString());
				DZlist.get(count).put("name", JsonUtil.jsonArrayValue(ZHAN,j).get("name").getAsString());
				DZlist.get(count).put("value", JsonUtil.jsonArrayValue(ZHAN,j).get("value").getAsInt());
				DZlist.get(count).put("dmaValue", JsonUtil.jsonArrayValue(ZHAN, j).get("dmaValue").getAsInt());
				DZlist.get(count).put("fvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("fvalue").getAsInt());
				DZlist.get(count).put("svalue", JsonUtil.jsonArrayValue(ZHAN, j).get("svalue").getAsInt());
				DZlist.get(count).put("tvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("tvalue").getAsInt());
				DZlist.get(count).put("lvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("lvalue").getAsInt());
				DZlist.get(count).put("nvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("nvalue").getAsInt());
				DZlist.get(count).put("kvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("kvalue").getAsInt());
				DZlist.get(count).put("sfvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("sfvalue").getAsInt());
				DZlist.get(count).put("tfvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("tfvalue").getAsInt());
				DZlist.get(count).put("lfvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("lfvalue").getAsInt());
				DZlist.get(count).put("nfvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("nfvalue").getAsInt());
				DZlist.get(count).put("kfvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("kfvalue").getAsInt());
				count++;
				if(j==ZHAN.size()-1){
					j=0;
					break;
				}
				//System.out.println(count);
			}
			//System.out.println(count);
		}
		//String ZQXNAME=QUXIZHAN.get("name").getAsString();
		//int ZQXvalueCount = QUXIZHAN.get("value").getAsInt();
		//ZQXmap=new HashMap<String, Object>();
		//ZQXmap.put("name", ZQXNAME);

	}
}
