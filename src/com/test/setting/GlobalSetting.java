package com.test.setting;

import java.util.Map;

import com.test.util.OperateProperties;

public class GlobalSetting {
	private static String hostname;
	private static String port;
	private static String baseURL;
	private static int timeout;
	private static String OracleUSERNAME;
	private static String OraclePASSWORD;
	private static String OracleDRIVER;
	private static String OracleURL;
	public GlobalSetting(){
		Map <String,String>map;
		map=OperateProperties.getAllProperties("E:/test/workspace/testNG/config/applilcation.properties");
		hostname=map.get("hostname");
		port=map.get("port");
		OracleUSERNAME=map.get("datasource.username");
		OraclePASSWORD=map.get("datasource.password");
		OracleDRIVER=map.get("datasource.driver-class-name");
		OracleURL=map.get("datasource.url");
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
	public static int timeOut(){
		return timeout;
	}
}
