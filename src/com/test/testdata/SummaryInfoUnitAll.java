package com.test.testdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.test.util.HttpClient;
import com.test.util.JsonUtil;

public class SummaryInfoUnitAll {
	public static JsonArray headers;
	public ArrayList<Map<String, Object>> USlist;
	public ArrayList<Map<String, Object>> UZlist;	
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
		JsonArray ZHAN;	
		int count=0;
		int j=0;
		JsonArray entries;
		String UnitALLURL=new HttpClient().doGet("http://192.168.0.40:9013/webInfo/UnitAll");
		headers=JsonUtil.getJsonArray(UnitALLURL, "headers");
		entries=JsonUtil.getJsonArray(UnitALLURL, "entries");
		//SUO初始化
		Map<String, Object> SHPmap=new HashMap<String, Object>();//黄浦所
		Map<String, Object> SXHmap=new HashMap<String, Object>();//徐汇所
		Map<String, Object> SHKmap=new HashMap<String, Object>();//虹口所
		Map<String, Object> SPTmap=new HashMap<String, Object>();//普陀所
		Map<String, Object> SCNmap=new HashMap<String, Object>();//长宁所
		Map<String, Object> SZBmap=new HashMap<String, Object>();//闸北所
		Map<String, Object> SYPmap=new HashMap<String, Object>();//杨浦所
		Map<String, Object> SBSmap=new HashMap<String, Object>();//宝山所
		Map<String, Object> SMHmap=new HashMap<String, Object>();//闵行所
		Map<String, Object> SQDmap=new HashMap<String, Object>();//青东所
		Map<String, Object> SSBmap=new HashMap<String, Object>();//松北所
		USlist=new ArrayList<Map<String, Object>>(Arrays.asList(SHPmap,SXHmap,SHKmap,
				SPTmap,SCNmap,SZBmap,SYPmap,SBSmap,SMHmap,SQDmap,SSBmap));
		//ZHAN初始化
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
		Map<String, Object> ZXINZmap=new HashMap<String, Object>();//莘庄站
		Map<String, Object> ZWJmap=new HashMap<String, Object>();//吴泾站
		Map<String, Object> ZXJmap=new HashMap<String, Object>();//徐泾站
		Map<String, Object> ZHXmap=new HashMap<String, Object>();//华新站
		Map<String, Object> ZHCmap=new HashMap<String, Object>();//华漕站
		Map<String, Object> ZSJmap=new HashMap<String, Object>();//泗泾站
		Map<String, Object> ZJTmap=new HashMap<String, Object>();//九亭站
		Map<String, Object> ZXQmap=new HashMap<String, Object>();//新桥站
		UZlist=new ArrayList<Map<String, Object>>(Arrays.asList(ZQXmap,ZBSYmap,ZXZmap,
				ZSZmap,ZLHmap,ZTYQmap,ZHYmap,ZQYmap,ZSNmap,ZDCmap,ZWNmap,ZZBmap,ZYXmap,
				ZDZABmap,ZFRJmap,ZJAXCmap,ZPTmap,ZCJmap,ZPSmap,ZCZmap,ZHTmap,ZMYmap,
				ZJPmap,ZSGmap,ZGTmap,ZLDmap,ZBYmap,ZLJmap,ZJCmap,ZXINZmap,ZWJmap,ZXJmap,
				ZHXmap,ZHCmap,ZSJmap,ZJTmap,ZXQmap));		
		for(int i=0;i<entries.size();i++){
			//获取所有所的信息
			USlist.get(i).put("name", JsonUtil.jsonArrayValue(entries,i).get("name").getAsString());
			USlist.get(i).put("value", JsonUtil.jsonArrayValue(entries,i).get("value").getAsInt());
			USlist.get(i).put("dmaValue", JsonUtil.jsonArrayValue(entries,i).get("dmaValue").getAsInt());
			USlist.get(i).put("fvalue", JsonUtil.jsonArrayValue(entries,i).get("fvalue").getAsInt());
			USlist.get(i).put("svalue", JsonUtil.jsonArrayValue(entries,i).get("svalue").getAsInt());
			USlist.get(i).put("tvalue", JsonUtil.jsonArrayValue(entries,i).get("tvalue").getAsInt());
			USlist.get(i).put("lvalue", JsonUtil.jsonArrayValue(entries,i).get("lvalue").getAsInt());
			USlist.get(i).put("nvalue", JsonUtil.jsonArrayValue(entries,i).get("nvalue").getAsInt());
			USlist.get(i).put("kvalue", JsonUtil.jsonArrayValue(entries,i).get("kvalue").getAsInt());
			USlist.get(i).put("sfvalue", JsonUtil.jsonArrayValue(entries,i).get("sfvalue").getAsInt());
			USlist.get(i).put("tfvalue", JsonUtil.jsonArrayValue(entries,i).get("tfvalue").getAsInt());
			USlist.get(i).put("lfvalue", JsonUtil.jsonArrayValue(entries,i).get("lfvalue").getAsInt());
			USlist.get(i).put("nfvalue", JsonUtil.jsonArrayValue(entries,i).get("nfvalue").getAsInt());
			USlist.get(i).put("kfvalue", JsonUtil.jsonArrayValue(entries,i).get("kfvalue").getAsInt());
			//获取所有站点的信息
			for(ZHAN=JsonUtil.getJsonArray(JsonUtil.jsonArrayValue(entries,i).toString(),"children");;j++){
				UZlist.get(count).put("name", JsonUtil.jsonArrayValue(ZHAN,j).get("name").getAsString());
				UZlist.get(count).put("value", JsonUtil.jsonArrayValue(ZHAN,j).get("value").getAsInt());
				UZlist.get(count).put("dmaValue", JsonUtil.jsonArrayValue(ZHAN, j).get("dmaValue").getAsInt());
				UZlist.get(count).put("fvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("fvalue").getAsInt());
				UZlist.get(count).put("svalue", JsonUtil.jsonArrayValue(ZHAN, j).get("svalue").getAsInt());
				UZlist.get(count).put("tvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("tvalue").getAsInt());
				UZlist.get(count).put("lvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("lvalue").getAsInt());
				UZlist.get(count).put("nvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("nvalue").getAsInt());
				UZlist.get(count).put("kvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("kvalue").getAsInt());
				UZlist.get(count).put("sfvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("sfvalue").getAsInt());
				UZlist.get(count).put("tfvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("tfvalue").getAsInt());
				UZlist.get(count).put("lfvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("lfvalue").getAsInt());
				UZlist.get(count).put("nfvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("nfvalue").getAsInt());
				UZlist.get(count).put("kfvalue", JsonUtil.jsonArrayValue(ZHAN, j).get("kfvalue").getAsInt());
				count++;
				if(j==ZHAN.size()-1){
					j=0;
					break;
				}
			}
		}

	}
}
