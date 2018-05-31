package com.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class OperateOracle {
	private static String USERNAME="jinwx";
	private static String PASSWORD="jinwx";
	private static String DRIVER="oracle.jdbc.OracleDriver";
	private static String URL="jdbc:oracle:thin:@192.168.0.31:1521/wmpdb";
	Connection conn=null;
	PreparedStatement pstm=null;
	ResultSet rs=null;
	//Connect to Oracle
	public Connection getConnection(){
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("成功连接数据库");
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
	public void selectData(String sql){
		conn=getConnection();
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				String OBJECTID=rs.getString("OBJECTID");
				String CODE=rs.getString("CODE");
				String NAME=rs.getString("NAME");
				System.out.println(OBJECTID + "\t" + CODE + "\t" + NAME);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			releaseResource();
		}
	}
	
	public void SelectData2(String sql) {
		conn = getConnection();
		int count = 0;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                count++;
            }
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols_len = rsmd.getColumnCount();
            System.out.println("count=" + count + "\tcols_len=" + cols_len);
            for(int i=1;i<=cols_len;i++){      	
            	System.out.print(rsmd.getColumnName(i)+"("+rsmd.getColumnTypeName(i)+")"+"\t");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResource();
        }
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
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
}
