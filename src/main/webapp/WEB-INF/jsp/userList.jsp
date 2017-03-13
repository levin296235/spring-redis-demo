<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="../../jquery/bootstrap-3.3.7/css/bootstrap.css" />
	<script src="../../jquery/jquery-1.12.4.js"></script>
	<script src="../../jquery/bootstrap-3.3.7/js/bootstrap.js"></script>
  </head>
  
  <body>
  <h1 align="center">用户基本信息</h1>
  <table border="1" align="center">
  	<thead>
  	 	<tr><th>用户ID</th><th>用户名</th><th>密码</th><th>年龄</th></tr>
  	</thead>
  	<tbody>
  	<c:forEach items="${uList }" var="u">  
  		<tr>
  			<td>${u.id }</td>
  			<td>${u.userName}</td>
  			<td>${u.password }</td>
  			<td>${u.age }</td>
  			<%-- <td><fmt:formatDate value="${u.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
  		</tr>
   	</c:forEach> 
   	</tbody>
  </table>
  <hr/>
  
  </body>
</html>
