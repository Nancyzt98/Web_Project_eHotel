<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Guest List</title>
</head>
<body>
<%
String id = request.getParameter("userId");
String driverName = "org.postgresql.Driver";
String connectionUrl = "jdbc:postgresql://web0.site.uottawa.ca:15432/group_139";
String dbName = "postgresql";
String userId = "tzhao018";
String password = "Remote2554";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<h2 align="center"><font><strong>Guest List</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr>
<td><b>GuestName</b></td>
<td><b>Guest_SSN</b></td>
<td><b>GuestAddress</b></td>
<td><b>GuestEmail</b></td>
<td><b>GuestPhoneNumber</b></td>
<td><b>GuestPwd</b></td>

</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM public.guests";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>

<td><%=resultSet.getString("guestname") %></td>
<td><%=resultSet.getString("guest_ssn") %></td>
<td><%=resultSet.getString("guestaddress") %></td>
<td><%=resultSet.getString("guestemail") %></td>
<td><%=resultSet.getString("guestphonenumber") %></td>
<td><%=resultSet.getString("guestpwd") %></td>

</tr>
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>