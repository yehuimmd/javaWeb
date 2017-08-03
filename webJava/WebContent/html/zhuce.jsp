<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="../css/zhuce.css">
</head>
<body>
    <!-- <img src="../images/post2.jpg" class="images"> -->
    <form action="Emp/add.do" class="box"> 
        <h2>注册</h2>
	 	<input type="text" placeholder="输入用户名" name="yh" class="bonnter1">
	 	<input type="password" placeholder="输入密码" name="m" class="bonnter2">
	 	<input type="password" placeholder="再次输入密码" name="mm" class="bonnter2">
	 	<input type="text" placeholder="输入身份证号" name="ide" class="bonnter2">
	 	<input type="text" placeholder="输入电话" name="phone" class="bonnter2">
		<input type="submit" value="提交" class="register_box">
		<!-- <input type="submit" value="注册" class="register_box"> -->
	</form>
</body>
</html>