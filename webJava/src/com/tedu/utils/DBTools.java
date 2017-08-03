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
	
	//��̬����г�Ա��ʼ��
	static{
		//ר�����ڶ�ȡ.properties�����ļ�
		Properties ps = new Properties();
		try {
 			//FileInputStream:��ȡ�ļ���I/O��
			ps.load(DBTools.class.getClassLoader().getResourceAsStream("db.properties"));
			driverClass = ps.getProperty("driverClass");
			url = ps.getProperty("url");
			user = ps.getProperty("user");
			password = ps.getProperty("password");
			//����mysql����
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
	 * ��ȡ����
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
    /**
     * ����jdbc�������ݿ�
     */
    public static void main(String[] args){
    	Connection conn = null;
    	try {
    		String sql = "select * from userinfo";
    		//��ȡ���ݿ������
    		conn = getConnection();
    		Statement st = conn.createStatement();
    		//ִ�в�ѯ֮��۷���һ�����
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
			//�ͷ�����
			close(conn);
		}
    }    
    
    /*
     * �ͷ�����
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
