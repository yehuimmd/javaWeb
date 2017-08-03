package com.tedu.Test;

import java.util.List;

import org.junit.Test;

import com.tedu.dao.EmpDao;
import com.tedu.entity.Emp;
public class Test01 {
	@Test
    public void query(){
		String sql = "select * from Emp";
    	List<Emp> list = EmpDao.findAll(sql);
    	for(Emp e : list){
    		System.out.println(e);
    	}
    }
	
	@Test
	public void update(){
		EmpDao.updateName("1", "Ð¤¹·×Ó");
	}
	
	@Test
	public void delete(){
		EmpDao.deleteById("3");
	}
	
	@Test
	public void addEmp(){
		Emp emp = new Emp();
		emp.setId("4");
		emp.setName("Ò¶»á");
		emp.setSalary("40000");
		emp.setAge("18");
		EmpDao.addEmp(emp);
	}
}
