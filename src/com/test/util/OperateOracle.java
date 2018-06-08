package com.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.test.setting.GlobalSetting;

public class OperateOracle {
	Connection conn=null;
	PreparedStatement pstm=null;
	ResultSet rs=null;
	//Connect to Oracle
	public Connection getConnection(){
		GlobalSetting gs=new GlobalSetting();
		try {
			Class.forName(gs.getOracleDriver());
			conn=DriverManager.getConnection(gs.getOracleUrl(), gs.getOracleUsername(), gs.getOraclePassWD());
			System.out.println("开始数据库连接");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//Select
	public ResultSet selectData(String sql){
		conn=getConnection();
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
		//	while(rs.next()){
		//		String OBJECTID=rs.getString("OBJECTID");
		//		String CODE=rs.getString("CODE");
		//		String NAME=rs.getString("NAME");
		//		System.out.println(OBJECTID + "\t" + CODE + "\t" + NAME);
		//	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			releaseResource();
		}
		return null;
	}
	public void getDataMeter(ResultSet rs){
		try {
			rs.getString("COUNT");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���ݿ����
	public String selectDataCount(String sql) {
		conn = getConnection();
		int count = 0;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResource();
        }
        return Integer.toString(count);
    }
	
	//��ȡ���ֶκͱ��ֶ�����
	public Map<String, String> getColumnsType(String sql){
		conn = getConnection();
		Map<String, String> map=new HashMap<String, String>();
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols_len=rsmd.getColumnCount();
			System.out.println("cols_len=" + cols_len);
	        for(int i=1;i<=cols_len;i++){      	
	        	map.put(rsmd.getColumnName(i), rsmd.getColumnTypeName(i));
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
		
	}
	//Insert
	public void insertData(String sql,String...strs){
		conn=getConnection();
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, Integer.parseInt(strs[0]));
			pstm.setString(2, strs[1]);
			pstm.setString(3, strs[2]);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			releaseResource();
		}
	}
	public void insertData2(String sql,String str[]){
		conn=getConnection();
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, Integer.parseInt(str[0]));
			pstm.setString(2, str[1]);
			pstm.setString(3, str[2]);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			releaseResource();
		}
	}
	//Update one recode
	public void updateData(String sql,String...strs){
		conn=getConnection();
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setInt(4, Integer.parseInt(strs[3]));
			pstm.setInt(1, Integer.parseInt(strs[0]));
			pstm.setString(2, strs[1]);
			pstm.setString(3, strs[2]);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			releaseResource();
		}
	}
	//Delete
	public void delData(String sql,String str){
		conn=getConnection();
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, Integer.parseInt(str));
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			releaseResource();
		}
	}
	//ReleaseRS
	public void releaseResource(){		 
		try{
			if(rs!=null){
				rs.close();
			}
			if(pstm!=null){
				pstm.close();
			}
			if(conn!=null){
				conn.close();
				System.out.println("结束数据库连接");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
}
