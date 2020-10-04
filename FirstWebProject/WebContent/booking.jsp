<%@page import="java.util.ArrayList"%>
<%@page import="entities.Room"%>
<%@page import="connections.PostgreSqlConn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Page</title>
</head>
<body>

	
	<form method="post" action="roomBook">
		<h4>
			Welcome,
			<h4>
				<h4>Here are the details of the room(s) you booked:</h4>
				<ul>
					<%
						Object obj1 = request.getAttribute("bookedRooms");
						ArrayList<Room> broomList = null;
						if (obj1 instanceof ArrayList) {
							broomList = (ArrayList<Room>) obj1;
						}
						if (broomList != null) {
							for (Room room : broomList) {
								String roominfo = room.getPropAddress() +", "+ room.getPropType()+", " + room.getRoomType()+", " + room.getStartDate()+" to " +room.getEndDate()+", " + room.getPrice()+"CAD, "+ room.getPaymentType()+", "+room.getGuest_SSN()+", "+room.getBranch_id()+"---" + room.getRoom_status();
					%>
					<li><%=roominfo%></li>
					<%
						}
						}
					%>
				</ul>
				<h4>Here are available rooms</h4>

				<select name = "propAddress">
					<%
						Object obj = request.getAttribute("allRooms");
						ArrayList<Room> roomList = null;
						if (obj instanceof ArrayList) {
							roomList = (ArrayList<Room>) obj;
						}
						if (roomList != null) {
							for (Room room : roomList) {
								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>					
						<option><%=room.getPropAddress()%></option>
						

					<%
					
							}
						}
					%>
						
				</select><br><br>
				Please enter your Guest_SSN:<input type = "text" id="guest_SSN" name = "guest_SSN" /><br><br> 
				Please sign the rental agreement: <a href=RentalAgreement.html>sign</a><br><br>
				<button type="submit" onclick="return confirm('book?');">book</button>
				<a href=Guest_Reviews.html>Write a review?</a><br>
	</form>


</body>
</html>