<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.tedu.entity.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>员工信息</title>
	<!-- <link rel="stylesheet" type="text/css" href=".../css/xinxi.css"> -->
	<style type="text/css">
	    *{
			padding:0;
		    margin:0;
		}
		body{
			text-align: center;
			font-family:微软雅黑;
		}
/* 		.images{
			position:relative;
			z-index:-1;
		} */
		.nav{
			margin:20px auto;
			font-family:微软雅黑;
			color:#000;
			font-size:30px;
		}
		h1{
			margin-top:5px;
			font-family:微软雅黑;
			color:#FFF;
			font-size:25px;
		}
		.box{
		    padding-top:10px;
            margin:0px auto;
			width:1000px;
			height:auto;
		 	background-color:#3a4563;
		 	opacity:0.9;
		}
		.tab{
			margin:30px auto;
			height:auto;
			width:900px;
		}
		.row{
			height:40px;
			color:#fff;
			font-weight:bold;
			background-color:#667CDF;
			opacity:0.9;
		}
		.row1, .row3, .row5, .row5,.row9, .row11{
			height:50px;
			background-color:#fff;
		}
		.row2, .row4{
		    height:50px;
			background-color:#ccc;
		}
		.er{
		    height:40px;
			background-color:#fff;
		}
		.register_box{
		    width:200px;
		    height:30px;
		 	margin:20px auto; 
		 	border-style:none;
		 	border-radius:5px;
		 	color:#FFFFFF;
		 	line-height:30px;
		 	text-align:center;
		 	font-family:'微软雅黑';
		 	font-weight:bolder;
		 	font-size:19px;
		    background-color:#667CDF;
		}
			    
	</style>
</head>
<body>
    <!-- 导航区 -->
    <p class="nav">导航区域</p>
    <div class="box"> 
        <h1>欢迎</h1>
		<table class="tab" border="0" cellpadding="0" cellspacing="0">
		    <tr class="row">
		        <td>ID</td>
		        <td>姓名</td>
		        <td>年龄</td>
		        <td>工资</td>
		        <td>操作</td>
		    </tr>
		    <% 
		        List<Emp> emps = (List<Emp>)request.getAttribute("emps");
		        if(null == emps){
		    %>
		        <tr class="er">
		            <td colspan="5">没有数据</td>
		        </tr>
		    <%
		        }else{
		        	for(int i = 0; i < emps.size(); i++){
		        		Emp emp = emps.get(i);
            %>
                <tr class="row<%=i%2+1 %>">
			        <td><%=emp.getId() %></td>
			        <td><%=emp.getName() %></td>
			        <td><%=emp.getAge() %></td>
			        <td><%=emp.getSalary() %></td>
			        <td>
			            <a href="del.do?id=<%=emp.getId() %>" 
			            onclick="return confirm('确定删除<%=emp.getName() %>吗？>');">删除</a>
			            &nbsp;<a href="load.do?id=<%=emp.getId() %>">修改</a>
		        </tr>
            <%
		            }
		        }
		    %>
		</table>
		<input type="button" value="增加员工" class="register_box" 
		onclick="location='html/addEmp.jsp'">
	</div>
</body>
</html>