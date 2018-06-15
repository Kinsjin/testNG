package com.test.pagedataprovidor;

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
	public  void setInfoDmaAll(){
		JsonArray ZHAN;	
		int count=0;
		int j=0;
		JsonArray entries;
		String UnitALLURL=new HttpClient().doGet("http://192.168.0.40:9013/webInfo/UnitAll","");
		headers=JsonUtil.getJsonArray(UnitALLURL, "headers");
		entries=JsonUtil.getJsonArray(UnitALLURL, "entries");
		//SUO��ʼ��
		Map<String, Object> SHPmap=new HashMap<String, Object>();//黄浦
		Map<String, Object> SXHmap=new HashMap<String, Object>();//徐汇
		Map<String, Object> SHKmap=new HashMap<String, Object>();//�����
		Map<String, Object> SPTmap=new HashMap<String, Object>();//������
		Map<String, Object> SCNmap=new HashMap<String, Object>();//������
		Map<String, Object> SZBmap=new HashMap<String, Object>();//բ����
		Map<String, Object> SYPmap=new HashMap<String, Object>();//������
		Map<String, Object> SBSmap=new HashMap<String, Object>();//��ɽ��
		Map<String, Object> SMHmap=new HashMap<String, Object>();//������
		Map<String, Object> SQDmap=new HashMap<String, Object>();//�ණ��
		Map<String, Object> SSBmap=new HashMap<String, Object>();//�ɱ���
		USlist=new ArrayList<Map<String, Object>>(Arrays.asList(SHPmap,SXHmap,SHKmap,
				SPTmap,SCNmap,SZBmap,SYPmap,SBSmap,SMHmap,SQDmap,SSBmap));
		//ZHAN��ʼ��
		Map<String, Object> ZQXmap=new HashMap<String, Object>();//��Ϫվ
		Map<String, Object> ZBSYmap=new HashMap<String, Object>();//����԰վ
		Map<String, Object> ZXZmap=new HashMap<String, Object>();//��բվ
		Map<String, Object> ZSZmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZLHmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZTYQmap=new HashMap<String, Object>();//��Կ��վ
		Map<String, Object> ZHYmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZQYmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZSNmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZDCmap=new HashMap<String, Object>();//��վ
		Map<String, Object> ZWNmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZZBmap=new HashMap<String, Object>();//�汱վ
		Map<String, Object> ZYXmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZDZABmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZFRJmap=new HashMap<String, Object>();//ܽ�ؽ�վ
		Map<String, Object> ZJAXCmap=new HashMap<String, Object>();//�����³�վ
		Map<String, Object> ZPTmap=new HashMap<String, Object>();//ƽ��վ
		Map<String, Object> ZCJmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZPSmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZCZmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZHTmap=new HashMap<String, Object>();//��̫վ
		Map<String, Object> ZMYmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZJPmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZSGmap=new HashMap<String, Object>();//�й�վ
		Map<String, Object> ZGTmap=new HashMap<String, Object>();//��̫վ
		Map<String, Object> ZLDmap=new HashMap<String, Object>();//�޵�վ
		Map<String, Object> ZBYmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZLJmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZJCmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZXINZmap=new HashMap<String, Object>();//ݷׯվ
		Map<String, Object> ZWJmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZXJmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZHXmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZHCmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZSJmap=new HashMap<String, Object>();//����վ
		Map<String, Object> ZJTmap=new HashMap<String, Object>();//��ͤվ
		Map<String, Object> ZXQmap=new HashMap<String, Object>();//����վ
		UZlist=new ArrayList<Map<String, Object>>(Arrays.asList(ZQXmap,ZBSYmap,ZXZmap,
				ZSZmap,ZLHmap,ZTYQmap,ZHYmap,ZQYmap,ZSNmap,ZDCmap,ZWNmap,ZZBmap,ZYXmap,
				ZDZABmap,ZFRJmap,ZJAXCmap,ZPTmap,ZCJmap,ZPSmap,ZCZmap,ZHTmap,ZMYmap,
				ZJPmap,ZSGmap,ZGTmap,ZLDmap,ZBYmap,ZLJmap,ZJCmap,ZXINZmap,ZWJmap,ZXJmap,
				ZHXmap,ZHCmap,ZSJmap,ZJTmap,ZXQmap));		
		for(int i=0;i<entries.size();i++){
			//��ȡ����������Ϣ
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
			//��ȡ����վ�����Ϣ
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
