<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import= "factory.ConFactory"%>
<%@ page import= "java.sql.Connection" %>
<%@ page import= "java.sql.ResultSet" %>
<%@ page import= "dao.CusDAO" %>
<%@ page import= "dao.FilmDAO" %>
<%@ page import= "impl.FilmImp" %>
<%@ page import= "entity.Language" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>add</title>
    
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
    
    <form action="<%=request.getContextPath() %>/AddServlet" method="POST" >
    	<table border="1px" >
    		<tr >
    			<h5>添加页面</h5>
    		</tr>
    		<!-- 
    		<tr colspan="2" align="center" >
    			<td>Film_id:<input type="text" name="film_id" /></td>
    		</tr>
    		 -->
    		<tr >
    			<td>Title:<input type="text" name="title" /></td>
    		</tr>
    		
    		<tr>
    			<td>Description:<input type="text" name="description" /></td>
    		</tr>
    		
    		<tr>
    			<td>Language_Name:
    			
    				<select  name="language" >
						
						<%
					    try{
					    Connection con = ConFactory.getConFactory().getCon();
						FilmDAO fd = new FilmImp();
						ResultSet rs = fd.FindLanguage(con);
						while(rs.next()){
						 %>
						 <option value="<%=rs.getString("language_id") %>" >
						 	<%=rs.getString("name") %>
						 </option>
						 <% 
						}
						}catch(Exception e){
							e.printStackTrace();
						}
						 %>
					</select>
    			</td>
    		</tr>
    		
    		<tr>
    			<td><input type="submit" value="提交" /></td>
    		</tr>
    		<tr>
    			<td><input type="reset" value="重置" /></td>
    		</tr>
    		
    	</table>
    </form>
    
  </body>
</html>


