package com.test.setting;

import java.util.Map;

import com.test.util.OperateProperties;

public class GlobalSetting {
	private  String hostname;
	private  String port;
	private  String baseURL;
	private  int timeout;
	private  String OracleUSERNAME;
	private  String OraclePASSWORD;
	private  String OracleDRIVER;
	private  String OracleURL;
	private  String Cookie;
	public static GlobalSetting instance;
	public static GlobalSetting getInstance(){
		if (instance == null) {
			instance = new GlobalSetting();
		}
		return instance;
	}
	private GlobalSetting(){
		Map <String,String>map;
		map=OperateProperties.getAllProperties("E:/test/workspace/testNG/config/applilcation.properties");
		hostname=map.get("hostname");
		port=map.get("port");
		OracleUSERNAME=map.get("datasource.username");
		OraclePASSWORD=map.get("datasource.password");
		OracleDRIVER=map.get("datasource.driver-class-name");
		OracleURL=map.get("datasource.url");
		Cookie=map.get("cookie");
	}
	public  String getHostname(){
		return hostname;
	}
	public  String getPort(){
		return port;
	}
	public  String getbaseURL(){
		return baseURL;
	}
	public  String getOracleUsername(){
		return OracleUSERNAME;
	}
	public  String getOraclePassWD(){
		return OraclePASSWORD;
	}
	public String getOracleDriver(){
		return OracleDRIVER;
	}
	public  String getOracleUrl(){
		return OracleURL;
	}
	public  int timeOut(){
		return timeout;
	}
	public  String getCookie(){
		return Cookie;
	}
}
