package com.tedu.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBTools {
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	
	//静态块进行成员初始化
	static{
		//专门用于读取.properties配置文件
		Properties ps = new Properties();
		try {
 			//FileInputStream:读取文件的I/O流
			ps.load(DBTools.class.getClassLoader().getResourceAsStream("db.properties"));
			driverClass = ps.getProperty("driverClass");
			url = ps.getProperty("url");
			user = ps.getProperty("user");
			password = ps.getProperty("password");
			//加载mysql驱动
			Class.forName(driverClass);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	 * 获取链接
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
    /**
     * 利用jdbc连接数据库
     */
    public static void main(String[] args){
    	Connection conn = null;
    	try {
    		String sql = "select * from userinfo";
    		//获取数据库的链接
    		conn = getConnection();
    		Statement st = conn.createStatement();
    		//执行查询之后慧返回一个结果
    		ResultSet set= st.executeQuery(sql);
    		while(set.next()){
    			String user = set.getString("User");
    			System.out.println(user);
    		}
    		//st.executeUpdate(sql);
    		//st.executeBatch();
			//System.out.println(getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//释放链接
			close(conn);
		}
    }    
    
    /*
     * 释放链接
     */
    public static void close(Connection conn){
    	if(conn!=null){
    		try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }
    
    
     
    
    
}
