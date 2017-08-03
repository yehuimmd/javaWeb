package com.tedu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tedu.entity.Emp;
import com.tedu.utils.DBTools;

/**
 * �������ݿ����
 * @author Administrator
 *
 */
public class EmpDao {
/*	private static Connection conn;
	private static Statement statement;
	static{
		try {
			conn = DBTools.getConnection();
			statement = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*
	 * ���Ա������Ϣ
	 */
    public static void addEmp(Emp emp){
    	 StringBuffer sql =  new 
    	 StringBuffer("insert into Emp(id, name, salary, age) values(");
    	 sql.append("'").append(emp.getId()).append("',");
    	 sql.append("'").append(emp.getName()).append("',");
    	 sql.append("'").append(emp.getSalary()).append("',");
    	 sql.append("'").append(emp.getAge()).append("')");
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
    
    /**
     * �޸ı�����ȫ���޸ģ�
     */
//    public static void update(Emp emp){
//    	String sql = "update Emp set id='"+emp.getId()+"'";
//    }
    /**
     * �޸ı���������id��
     */
    public static void updateName(String id, String name){
    	String sql = "update Emp set name='"+name+"'where id='"+id+"'";
    	 Connection conn = null;
    	 try {
    		conn = DBTools.getConnection();
    		Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
    }
    /**
     * ͨ�^���f������ԓÿ�N����
     * @param sql
     */
    public static void update(String sql){
    	 Connection conn = null;
    	 try {
    		conn = DBTools.getConnection();
    		Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
    }
    /**
     * �޸ı���������������
     */ 
//    public static void updateByName(String name){
//    	
//    }
    
    /**
     * ����id��ԃ
     */
    public static Emp findById(String id){
    	String sql = "Select * from Emp where id='"+id+"'";
    	Emp emp = new Emp();
    	 Connection conn = null;
    	 try {
    		conn = DBTools.getConnection();
    		Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			//��ֹ�l����ָᘣ��Д�
			if(set.next()==false){
			//	return null;
			}else{
				emp.setId(set.getString("id"));
				emp.setName(set.getString("name"));
				emp.setAge(set.getString("age"));
				emp.setSalary(set.getString("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
		return emp;
    }
    /**
     * �������ֲ�ԃ
     * @param name
     */
    public static List<Emp> findByName(String name){
    	String sql = "select * from Emp where name='"+name+"'";
    	List<Emp> emps = new ArrayList<Emp>();
    	Connection conn = null;
    	try {
			conn = DBTools.getConnection();
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			//��v�Y��ȡ�������Ĕ��������u����
			while(set.next()){
				Emp emp = new Emp();
				emp.setId(set.getString("id"));
				emp.setName(set.getString("name"));
				emp.setAge(set.getString("age"));
				emp.setSalary(set.getString("salary"));
				emps.add(emp);
			}
			if(emps.size()==0){
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
		return emps;
    }
    /**
     * ��ԃ����
     */
    public static List<Emp> findAll(String sql){
    	//����һ�����ϰ�����emp��������e��
    	List<Emp> emps = new ArrayList<Emp>();
    	Connection conn = null;
    	try {
			conn = DBTools.getConnection();
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			//��v�Y��ȡ�������Ĕ��������u����
			while(set.next()){
				Emp emp = new Emp();
				emp.setId(set.getString("id"));
				emp.setName(set.getString("name"));
				emp.setAge(set.getString("age"));
				emp.setSalary(set.getString("salary"));
				emps.add(emp);
			}
			if(emps.size()==0){
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
		return emps;
    }
    
    /**
     * �h������
     * @param args
     */
    public static void deleteAll(){
    	
    }
    /**
     * �������քh��
     * @param name
     */
	public static void deleteByName(String name){
	    	
	}
	/**
	 * ����id�h��
	 * @param id
	 */
	public static void deleteById(String id){
		String sql = "delete from Emp where id='"+id+"'";
		Connection conn = null;
    	try {
			conn = DBTools.getConnection();
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
	}
	
	/**
	 * ���{����
	 * @param args
	 */
    public static void main(String[] args){
    	EmpDao dao = new EmpDao();
    	Emp emp = new Emp();
    	emp.setAge("20");
    	emp.setId("1");
    	emp.setName("yehui");
    	emp.setSalary("30000");
    	dao.addEmp(emp);
    }
}
