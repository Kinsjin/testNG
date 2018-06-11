package com.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.setting.GlobalSetting;

public class OperateOracle {
	Connection conn=null;
	PreparedStatement pstm=null;
	public ResultSet rs=null;
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
	//Select 获取所有内容
	public List<Map<String,String>> selectData(String sql){
		conn=getConnection();
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols_len=rsmd.getColumnCount();
			String value;
			int count=0;
			while(rs.next()){							
				Map<String, String> map = new HashMap<String, String>();
				for(int i=1;i<=cols_len;i++){				
					String columnName =rsmd.getColumnLabel(i);
					//System.out.println(rsmd.getColumnTypeName(i));
					if(rs.getString(columnName)!=null){
						value=rs.getString(columnName).replace(" ", "");
					}else {value=null;}
					map.put(columnName, value);
					//System.out.println("i: "+i);
				}
				list.add(count, map);
				count ++;
			}
			//System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			releaseResource();
		}
		return list;
	}
	//根据内容获取数量
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
	
	//查找列名+列类型
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
