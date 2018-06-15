package com.test.oracledataprovider;

import java.util.HashMap;
import java.util.Map;

import com.test.setting.GlobalSetting;
import com.test.util.OperateOracle;
import com.test.util.OperateProperties;

public class AllOracleData {
	public static AllOracleData instance;
	public static AllOracleData getInstance() {
		if (instance == null) {
			instance = new AllOracleData();
		}
		return instance;
	}
	protected AllOracleData(){}
	public Map<String, Integer> getAllTotalData(){
		//考核表数量统计sql
		String rm_count_sql=OperateProperties.getValue("E:/test/workspace/testNG/config/sqls.properties", "remote_meter_count");
		//单位用户数量sql
		String rb_count_sql=OperateProperties.getValue("E:/test/workspace/testNG/config/sqls.properties", "revenue_meter_count");
		//未分配数量sql
		String uasso_count_sql=OperateProperties.getValue("E:/test/workspace/testNG/config/sqls.properties", "uasso_count_sql");
		//考核表故障数量sql
		String rmalarm_count_sql=OperateProperties.getValue("E:/test/workspace/testNG/config/sqls.properties", "rmalarm_count_sql");
		//单位用户故障数量sql
		String emalarm_count_sql=OperateProperties.getValue("E:/test/workspace/testNG/config/sqls.properties", "rbalarm_count_sql");
		//从数据库考核表数量
		String rm_count=new OperateOracle().selectDataCount(rm_count_sql);
		//数据库单位用户数量
		String em_count=new OperateOracle().selectDataCount(rb_count_sql);
		//数据库未分配数量
		String uasso_count=new OperateOracle().selectDataCount(uasso_count_sql);
		//数据库考核表故障数量
		String rmalarm_count=new OperateOracle().selectDataCount(rmalarm_count_sql);
		//数据库单位用户故障数量
		String emalarm_count=new OperateOracle().selectDataCount(emalarm_count_sql);
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("考核表总量",Integer.parseInt(rm_count));
		map.put("单位用户总量",Integer.parseInt(em_count));
		map.put("未分配总量",Integer.parseInt(uasso_count));
		map.put("考核表故障总量",Integer.parseInt(rmalarm_count));
		map.put("单位用户故障总量",Integer.parseInt(emalarm_count));
		return map;
	}
}
