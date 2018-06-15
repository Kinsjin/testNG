package com.test.oracledataprovider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.util.OperateOracle;

public class EMCountSuoZhan {
	static List<Map<String,String>> list;
	Map<String, Integer> rmsitemap;
	//设置所站表数量
	public void setEMSiteCount(){
		String sql = "SELECT SUONAME \"SUOZHAN\",COUNT(*)\"COUNT\" FROM REMOTE_VIEW "
				+ "GROUP BY SUONAME "
				+ "UNION " 
				+ "SELECT ZHANNAME \"SUOZHAN\",COUNT(*)\"COUNT\" FROM REMOTE_VIEW "
				+ "GROUP BY ZHANNAME";
		list=new OperateOracle().selectData(sql);
	}
	//设置所站故障表数量
	public void setEMAlarmSiteCount(){
		String sql="SELECT SUONAME||'故障' \"SUOZHAN\",COUNT(*) \"COUNT\" "
				+ "FROM REMOTE_ALARM_VIEW GROUP BY SUONAME "
				+ "UNION "
				+ "SELECT ZHANNAME||'故障' \"SUOZHAN\",COUNT(*) \"COUNT\" "
				+ "FROM REMOTE_ALARM_VIEW GROUP BY ZHANNAME";
		list=new OperateOracle().selectData(sql);
	}
	//设置所站dma数量
	public void setEMDMACount(){
		String sql="SELECT SUONAME||'DMA' \"SUOZHANDMA\",COUNT(DISTINCT DMAASSO) "
				+ "\"DMACOUNT\" FROM REMOTE_VIEW GROUP BY SUONAME "
				+ "UNION SELECT ZHANNAME||'DMA' \"SUOZHANDMA\",COUNT(DISTINCT DMAASSO) \"DMACOUNT\" "
				+ "FROM REMOTE_VIEW GROUP BY ZHANNAME";
		list=new OperateOracle().selectData(sql);
	}
	//设置所有所站设备厂商数量
	public void setEMDeviceCount(){
		String sql="SELECT SUOZHAN || VENDOR \"SUOZHANVENDOR\",COUNT \"DEVICECOUNT\" FROM "
				+ "(SELECT SUONAME \"SUOZHAN\","
						+ "\"DECODE\"(DEVICEVENDOR,1, '山科',2,'拓安信',3,'立信',4,'宁波东海',5,'肯特') \"VENDOR\","
						+ "COUNT(*) \"COUNT\" FROM REMOTE_VIEW GROUP BY SUONAME,DEVICEVENDOR) "
						+ "UNION "
						+ "SELECT SUOZHAN || VENDOR \"SUOZHANVENDOR\",COUNT \"DEVICECOUNT\" FROM "
						+ "(SELECT ZHANNAME \"SUOZHAN\",\"DECODE\"(DEVICEVENDOR,1, '山科',2,'拓安信',3,'立信',4,'宁波东海',5,'肯特') \"VENDOR\","
								+ "COUNT(*) \"COUNT\" FROM REMOTE_VIEW GROUP BY ZHANNAME,DEVICEVENDOR)";
		list=new OperateOracle().selectData(sql);
	}
	////设置所有所站故障设备厂商数量
	public void setEMAlarmDeviceCount(){
		String sql="SELECT SUONAME||NAME||'故障' \"SUOZHANVENDOR\",count(*)\"ALARMDEVICECOUNT\" "
				+ "FROM REMOTE_ALARM_VIEW GROUP BY SUONAME,\"NAME\" "
				+ "UNION "
				+ "SELECT ZHANNAME ||NAME||'故障' \"SUOZHANVENDOR\",count(*)\"ALARMDEVICECOUNT\" "
				+ "FROM REMOTE_ALARM_VIEW GROUP BY ZHANNAME,\"NAME\"";
		list=new OperateOracle().selectData(sql);
	}
	//获得所有所站的数量
	public Map<String, Integer> getEMSiteCount(){
		rmsitemap=new HashMap<String,Integer>();
		new EMCountSuoZhan().setEMSiteCount();
		String count = null;
		String suozhan = null;
		for(int i=0;i<list.size();i++){
			Map<String,String> map=list.get(i);
			count=map.get("COUNT");
			suozhan=map.get("SUOZHAN");
			rmsitemap.put(suozhan, Integer.parseInt(count));
		}
		return rmsitemap;
	}
	//根据所站名获得数量
	public Integer getEMSiteCount(String str){
		rmsitemap=new HashMap<String,Integer>();
		new EMCountSuoZhan().setEMSiteCount();
		String count = null;
		String suozhan = null;
		for(int i=0;i<list.size();i++){
			Map<String,String> map=list.get(i);
			count=map.get("COUNT");
			suozhan=map.get("SUOZHAN");
			if(suozhan.equals(str)){
				return Integer.parseInt(count);
			}
		}
		return null;
	}
	//获得所有所站故障的数量
		public Map<String, Integer> getEMAlarmSiteCount(){
			rmsitemap=new HashMap<String,Integer>();
			new EMCountSuoZhan().setEMAlarmSiteCount();
			String count = null;
			String suozhan = null;
			for(int i=0;i<list.size();i++){
				Map<String,String> map=list.get(i);
				count=map.get("COUNT");
				suozhan=map.get("SUOZHAN");
				rmsitemap.put(suozhan, Integer.parseInt(count));
			}
			return rmsitemap;
		}
		//根据所站名故障获得数量
		public Integer getEMAlarmSiteCount(String str){
			rmsitemap=new HashMap<String,Integer>();
			new EMCountSuoZhan().setEMAlarmSiteCount();
			String count = null;
			String suozhan = null;
			for(int i=0;i<list.size();i++){
				Map<String,String> map=list.get(i);
				count=map.get("COUNT");
				suozhan=map.get("SUOZHAN");
				if(suozhan.equals(str)){
					return Integer.parseInt(count);
				}
			}
			return null;
		}
	//dmamap
	public Map<String, Integer> getEMDmaCount(){
		rmsitemap=new HashMap<String,Integer>();
		new EMCountSuoZhan().setEMDMACount();
		String count = null;
		String suozhandma = null;
		for(int i=0;i<list.size();i++){
			Map<String,String> map=list.get(i);
			count=map.get("DMACOUNT");
			suozhandma=map.get("SUOZHANDMA");
			rmsitemap.put(suozhandma, Integer.parseInt(count));
		}
		return rmsitemap;
	}
	public Integer getEMDmaCount(String str){
		rmsitemap=new HashMap<String,Integer>();
		new EMCountSuoZhan().setEMDMACount();
		String count = null;
		String suozhandma = null;
		for(int i=0;i<list.size();i++){
			Map<String,String> map=list.get(i);
			count=map.get("DMACOUNT");
			suozhandma=map.get("SUOZHANDMA");
			if(suozhandma.equals(str)){
				return Integer.parseInt(count);
			}
		}
		return null;
	}
	//设备MAP
	public Map<String, Integer> getEMDeviceCount(){
		rmsitemap=new HashMap<String,Integer>();
		new EMCountSuoZhan().setEMDeviceCount();
		String count = null;
		String suozhandevice = null;
		for(int i=0;i<list.size();i++){
			Map<String,String> map=list.get(i);
			count=map.get("DEVICECOUNT");
			suozhandevice=map.get("SUOZHANVENDOR");
			rmsitemap.put(suozhandevice, Integer.parseInt(count));
		}
		return rmsitemap;
	}
	public Integer getEMDeviceCount(String str){
		rmsitemap=new HashMap<String,Integer>();
		new EMCountSuoZhan().setEMDeviceCount();
		String count = null;
		String suozhandevice = null;
		for(int i=0;i<list.size();i++){
			Map<String,String> map=list.get(i);
			count=map.get("DEVICECOUNT");
			suozhandevice=map.get("SUOZHANVENDOR");
			if(suozhandevice.equals(str)){
				return Integer.parseInt(count);
			}
		}
		return null;
	}
	//设备故障map
	public Map<String, Integer> getEMAlarmDeviceCount(){
		rmsitemap=new HashMap<String,Integer>();
		new EMCountSuoZhan().setEMAlarmDeviceCount();
		String count = null;
		String suozhanalarmdevice = null;
		for(int i=0;i<list.size();i++){
			Map<String,String> map=list.get(i);
			count=map.get("ALARMDEVICECOUNT");
			suozhanalarmdevice=map.get("SUOZHANVENDOR");
			rmsitemap.put(suozhanalarmdevice, Integer.parseInt(count));
		}
		return rmsitemap;
	}
	public Integer getRMAlarmDeviceCount(String str){
		rmsitemap=new HashMap<String,Integer>();
		new EMCountSuoZhan().setEMAlarmDeviceCount();
		String count = null;
		String suozhanalarmdevice = null;
		for(int i=0;i<list.size();i++){
			Map<String,String> map=list.get(i);
			count=map.get("ALARMDEVICECOUNT");
			suozhanalarmdevice=map.get("SUOZHANVENDOR");
			if(suozhanalarmdevice.equals(str)){
				return Integer.parseInt(count);
			}
		}
		return null;
	}
}
