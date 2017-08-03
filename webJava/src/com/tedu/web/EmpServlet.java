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
		//������Ӧ����
		request.setCharacterEncoding("utf-8");
		//��ȡ����·��
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
	 * �޸�Ա����Ϣ
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
			//��������
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
     * ��ѯһ��Ա������Ϣ����modifyEmpService
     * @param request
     * @param response
     */
	private void loadEmpService(HttpServletRequest request,
			HttpServletResponse response) {
		
		try{
	        String id = request.getParameter("id");
			//��������
			Emp emp = EmpDao.findById(id);
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("/html/updateEmp.jsp")
			.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ɾ��Ա����Ϣ
	 */
	public void deleteEmp(HttpServletRequest request,
			HttpServletResponse response){
		try{
	        String id = request.getParameter("id");
			//��������
			EmpDao.deleteById(id);
			response.sendRedirect("/Emp/list.do");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ���Ա��
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
			//��������
			EmpDao.addEmp(emp);
			response.sendRedirect("/Emp/list.do");
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	public void listEmp(HttpServletRequest request,
			HttpServletResponse response){
		try {
			//��ѯԱ����Ϣ������Ϣ��ʾ����ҳ��
			String empSql = "select * from emp";
			List<Emp> emps = EmpDao.findAll(empSql);
			//���ú���������չ����ǰ��ҳ��
			request.setAttribute("emps", emps);
			//ת��
			request.getRequestDispatcher(
					"/html/listEmp.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ע��
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
			System.out.println("�������,�����³���");
			return;
		}
        //������ݿ���Ƿ��Ѿ�ע��
		userInfo info = UserDao.findByName(user);
		if(info == null){
			userInfo userinfo = new userInfo();
			userinfo.setId("3");
			userinfo.setUser(user);
			userinfo.setPassword(password);
			userinfo.setPhone(phone);
			userinfo.setIdentity(identity);
			//��������
			UserDao.addUser(userinfo);
			try {
				response.sendRedirect("/Emp/html/index.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{ 
			System.out.println("���û��Ѿ�����");
				 
			}
		}
	/**
	 * Ա����Ϣչʾ��ҳ��
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
			String pas = userinfo.getPassword();//�����ݿ���ȡ��
			if(!pas.equals(password)){
				//System.out.println("�������");
				response.sendRedirect("/Emp/html/index.html");
			}else{
				response.sendRedirect("/Emp/list.do");
			}
		}
	};

}
