<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>新增员工</title>
	<style type="text/css">
	    *{
			padding:0;
		    margin:0;
		}
		body{
			text-align: center;
		}
		.images{
			position:relative;
			z-index:-1;
		}
		.nav{
			margin:20px auto;
			font-family:微软雅黑;
			color:#000;
			font-size:30px;
		}
		h1{
			margin-top:10px;
			font-family:微软雅黑;
			color:#FFF;
			font-size:25px;
		}
		.box{
		    padding-top:10px;
            margin:0px auto;
			width:550px;
			height:350px;
		 	background-color:#3A4563;
		 	opacity:0.9;
		}
		.tab{
			margin:20px auto;
			height:auto;
			width:1200px;
			text-align:center;
		}
		input{
			height:30px;
			width:280px;
			color:#999;
		 	border-radius:5px;
		 	border:none;
		 	text-align:center;
		}
		.fontshow{
		    font-family:'微软雅黑';
		 	font-size:19px;
		    color:#fff;
		}
		.bonnter1{
			float:left;
			margin-top:10px;
			margin-left:-20px; 
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
        <form action="Emp/addEmp.do" class="box">
            <h1>添加员工</h1>
            <table cellpadding="0" cellspacing="0" class="tab">
                <tr>
                    <td class="fontshow">姓名:</td>
                    <td><input type="text" class="bonnter1" name="name"></td>
                </tr>
                <tr>
                    <td class="fontshow">薪水:</td>
                    <td><input type="text" class="bonnter1" name="salary"></td>
                </tr>
                <tr>
                    <td class="fontshow">年龄:</td>
                    <td><input type="text" class="bonnter1" name="age"></td>
                </tr>
            </table>
            <input type="submit" value="确定" class="register_box">
        </form>
    </div>
</body>
</html>