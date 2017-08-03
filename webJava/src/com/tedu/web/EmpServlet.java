package com.tedu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.EmpDao;
import com.tedu.dao.UserDao;
import com.tedu.entity.Emp;
import com.tedu.entity.userInfo;
import com.tedu.utils.UUIDUtil;
public class EmpServlet extends HttpServlet{
	
	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException ,IOException {
		//设置响应类型
		request.setCharacterEncoding("utf-8");
		//获取请求路径
		String uri = request.getRequestURI();
		//System.out.print(uri);
		String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		//System.out.print(action);
		if("/login".equals(action)){
			loginService(request, response);
			//System.out.print(user+":"+password);
		}else if("/add".equals(action)){
			addService(request, response);
		}else if("/addEmp".equals(action)){
			addEmpService(request, response);
		}else if("/list".equals(action)){
			listEmp(request, response);
		}else if("/del".equals(action)){
			deleteEmp(request, response);
		}else if("/load".equals(action)){
			loadEmpService(request, response);
		}else if("/modify".equals(action)){
			modifyEmpService(request, response);
		}
	}
    
	/**
	 * 修改员工信息
	 * @param request
	 * @param response
	 */
	private void modifyEmpService(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			String id = request.getParameter("id");
			String age = request.getParameter("age");
			String salary = request.getParameter("salary");
			String name = request.getParameter("name");
			
			Emp emp = new Emp();
			emp.setAge(age);
			emp.setName(name);
			emp.setSalary(salary);
			//插入数据
			String sql = "update emp set "
			              +"name='"+name
			              +"',age='"+age
			              +"',salary='"+salary
			              +"' where id='"+id
			              +"'";
            EmpDao.update(sql);
            response.sendRedirect("/Emp/list.do");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    /**
     * 查询一个员工的信息交给modifyEmpService
     * @param request
     * @param response
     */
	private void loadEmpService(HttpServletRequest request,
			HttpServletResponse response) {
		
		try{
	        String id = request.getParameter("id");
			//插入数据
			Emp emp = EmpDao.findById(id);
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("/html/updateEmp.jsp")
			.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除员工信息
	 */
	public void deleteEmp(HttpServletRequest request,
			HttpServletResponse response){
		try{
	        String id = request.getParameter("id");
			//插入数据
			EmpDao.deleteById(id);
			response.sendRedirect("/Emp/list.do");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 添加员工
	 * @param request
	 * @param response
	 */
	public void addEmpService(HttpServletRequest request,
			HttpServletResponse response){
		try{
	        String age = request.getParameter("age");
			String salary = request.getParameter("salary");
			String name = request.getParameter("name");
			
			Emp emp = new Emp();
			emp.setAge(age);
			emp.setName(name);
			emp.setSalary(salary);
			emp.setId(UUIDUtil.getUuid32());
			//插入数据
			EmpDao.addEmp(emp);
			response.sendRedirect("/Emp/list.do");
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	public void listEmp(HttpServletRequest request,
			HttpServletResponse response){
		try {
			//查询员工信息表，把信息显示在网页上
			String empSql = "select * from emp";
			List<Emp> emps = EmpDao.findAll(empSql);
			//利用函数将数据展现在前端页面
			request.setAttribute("emps", emps);
			//转发
			request.getRequestDispatcher(
					"/html/listEmp.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 注册
	 * @param request
	 * @param response
	 */
	public void addService(HttpServletRequest request,
			HttpServletResponse response){
		String user = request.getParameter("yh");
		String pass = request.getParameter("m");
		String password = request.getParameter("mm");
		String phone = request.getParameter("phone");
		String identity = request.getParameter("ide");
		
		if(!pass.equals(password)){
			System.out.println("密码错误,请重新出入");
			return;
		}
        //检查数据库的是否已经注册
		userInfo info = UserDao.findByName(user);
		if(info == null){
			userInfo userinfo = new userInfo();
			userinfo.setId("3");
			userinfo.setUser(user);
			userinfo.setPassword(password);
			userinfo.setPhone(phone);
			userinfo.setIdentity(identity);
			//插入数据
			UserDao.addUser(userinfo);
			try {
				response.sendRedirect("/Emp/html/index.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{ 
			System.out.println("该用户已经存在");
				 
			}
		}
	/**
	 * 员工信息展示在页面
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void loginService(HttpServletRequest request,
		HttpServletResponse response) throws IOException {
		String user = request.getParameter("ind_zhanghao");
		String password = request.getParameter("ind_mima");
		userInfo userinfo = UserDao.findByName(user);
		if(userinfo == null){
			response.sendRedirect("/Emp/html/zhuce.jsp");
		}else{
			String pas = userinfo.getPassword();//从数据库中取出
			if(!pas.equals(password)){
				//System.out.println("密码错误");
				response.sendRedirect("/Emp/html/index.html");
			}else{
				response.sendRedirect("/Emp/list.do");
			}
		}
	};

}
