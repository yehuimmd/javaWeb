package com.tedu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tedu.entity.Emp;
import com.tedu.entity.userInfo;
import com.tedu.utils.DBTools;

public class UserDao {
    
	public static List<userInfo> findAll(String sql){
		List<userInfo> list = new ArrayList<userInfo>();
		Connection conn = null;
		try {
			conn = DBTools.getConnection();
			Statement st = conn.createStatement();
			ResultSet set = st.executeQuery(sql);
			while(set.next()){
				userInfo user = new userInfo();
				user.setId(set.getString("id"));
				user.setUser(set.getString("user"));
				user.setPassword(set.getString("password"));
				user.setPhone(set.getString("phone"));
				user.setIdentity(set.getString("identity"));
				list.add(user);
			}
			if(list.size()==0){
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
		return list;
	}
	
	
	public static userInfo findByName(String name){
		userInfo user = new userInfo();
		Connection conn = null;
		String sql = "select * from userinfo where user='"+name+"'";
		try {
			conn = DBTools.getConnection();
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			if(set.next()==false){
				return null;
			}else{
				//userInfo user = new userInfo();
				user.setId(set.getString("id"));
				user.setUser(set.getString("user"));
				user.setPassword(set.getString("password"));
				user.setPhone(set.getString("phone"));
				user.setIdentity(set.getString("identity"));
			    //list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
		return user;
	}
	
	public static void addUser(userInfo user){
   	 StringBuffer sql =  new 
   	 StringBuffer("insert into userinfo(id, user, password, identity, phone) values(");
   	 sql.append("'").append(user.getId()).append("',");
   	 sql.append("'").append(user.getUser()).append("',");
   	 sql.append("'").append(user.getPassword()).append("',");
   	 sql.append("'").append(user.getIdentity()).append("',");
   	 sql.append("'").append(user.getPhone()).append("')");
   	 Connection conn = null;
   	 try {
   		conn = DBTools.getConnection();
   		Statement statement = conn.createStatement();
			statement.executeUpdate(sql.toString());
			//statement.executeUpdate(sql.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
        //System.out.println(sql.toString());
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
