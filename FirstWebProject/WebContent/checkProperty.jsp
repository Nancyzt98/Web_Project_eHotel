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
<title>Check Property List</title>
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

<h2 align="center"><font><strong>Property List, Host List, Guest List</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr>
<td><b>PropertyAddress</b></td>
<td><b>PropertyType</b></td>
<td><b>RoomType</b></td>
<td><b>StartDate</b></td>
<td><b>EndDate</b></td>
<td><b>Price</b></td>
<td><b>PaymentType</b></td>
<td><b>Room_status</b></td>
<td><b>Guest_SSN</b></td>
<td><b>Branch_ID</b></td>
<td><b>Ratings</b></td>
<td><b>Host_SSN</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM public.property";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>

<td><%=resultSet.getString("propertyaddress") %></td>
<td><%=resultSet.getString("propertytype") %></td>
<td><%=resultSet.getString("roomtype") %></td>
<td><%=resultSet.getString("startdate") %></td>
<td><%=resultSet.getString("enddate") %></td>
<td><%=resultSet.getString("price") %></td>
<td><%=resultSet.getString("paymenttype") %></td>
<td><%=resultSet.getString("room_status") %></td>
<td><%=resultSet.getString("guest_ssn") %></td>
<td><%=resultSet.getString("branch_id") %></td>
<td><%=resultSet.getString("ratings") %></td>
<td><%=resultSet.getString("host_ssn") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>

<!-- <h2 align="center"><font><strong>Host List</strong></font></h2> -->
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr>
<td><b>HouseNum</b></td>
<td><b>HouseStreet</b></td>
<td><b>HouseCity</b></td>
<td><b>HouseProv</b></td>
<td><b>HostName</b></td>
<td><b>HostEmail</b></td>
<td><b>HostPhoneNumber</b></td>
<td><b>HostPwd</b></td>
<td><b>Host_SSN</b></td>

</tr>
<%
try{ 
String sql ="SELECT * FROM public.host";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>

<td><%=resultSet.getString("housenum") %></td>
<td><%=resultSet.getString("housestreet") %></td>
<td><%=resultSet.getString("housecity") %></td>
<td><%=resultSet.getString("houseprov") %></td>
<td><%=resultSet.getString("hostname") %></td>
<td><%=resultSet.getString("hostemail") %></td>
<td><%=resultSet.getString("hostphonenumber") %></td>
<td><%=resultSet.getString("hostpwd") %></td>
<td><%=resultSet.getString("host_ssn") %></td>

</tr>
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>

<!-- <h2 align="center"><font><strong>Guest List</strong></font></h2> -->
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

</table>
</body>
</html>