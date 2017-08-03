package com.tedu.Test;

import com.tedu.dao.EmpDao;
import com.tedu.entity.Emp;

public class TestCase {
    public static void main(String[] args){
    	Emp emp = new Emp();
    	emp.setId("6");
    	emp.setAge("40");
      	emp.setName("Ð¤Üç");
    	emp.setSalary("4000000");
    	EmpDao.addEmp(emp);
    }
}
