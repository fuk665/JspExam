<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import= "factory.ConFactory"%>
<%@ page import= "java.sql.Connection" %>
<%@ page import= "java.sql.ResultSet" %>
<%@ page import= "dao.FilmDAO" %>
<%@ page import= "impl.FilmImp" %>
<%@ page import= "entity.Film" %>
<%@ page import= "java.io.IOException" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>toupdate page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  <h4>此功能尚未完成</h4>
  
  <%
  	ResultSet rs = null;
  	rs = (ResultSet)request.getSession().getAttribute("rs");
  %>
  <form action="<%=request.getContextPath() %>/UpdateSertlet" method="post" >
  	
  
  </form>
  
  </body>
</html>
