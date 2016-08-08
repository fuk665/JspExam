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
<%@ page import= "entity.Film" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
   <body>
  <div align="center">
  <a href="<%=request.getContextPath() %>/index.jsp">返回主页面</a>
  </div> 
   
    <table border="2px">
    <tr>
    <th>film_id</th>
    <th>title</th>
    <th>description</th>
    <th>language_name</th>
    <th>删除</th>
    <th>修改</th>
    </tr>
    <%
    try{
    Connection con = ConFactory.getConFactory().getCon();
	FilmDAO fd = new FilmImp();
	ResultSet rs = fd.listF(con);
	while(rs.next()){
	 %>
	 <tr>
	 <td><%=rs.getInt("film_id") %></td>
	 <td><%=rs.getString("title") %></td>
	 <td><%=rs.getString("description") %></td>
	 <td><%=rs.getString("name") %></td>
	 <td><a href="<%=request.getContextPath() %>/DeleteServlet?id=<%=rs.getInt("film_id") %>">删除</a>
	 <td><a href="<%=request.getContextPath() %>/TOUpdateServlet?id=<%=rs.getInt("film_id") %>">修改</a>
	 </tr>
	 <% 
	}
	}catch(Exception e){
		e.printStackTrace();
	}
    %>
    </table>
   
  </body>
</html>
