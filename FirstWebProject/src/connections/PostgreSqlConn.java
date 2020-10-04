package connections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entities.Room; 



public class PostgreSqlConn{
	
		Connection db = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Statement st = null;
	    String sql;


		public void getConn(){
			
			try {
				
				Class.forName("org.postgresql.Driver"); 
								
				db = DriverManager.getConnection("jdbc:postgresql://web0.site.uottawa.ca:15432/group_139",
						"tzhao018", "Remote2554");
															
			}catch(Exception e) {
				System.out.print("error catched");
			}
						
		}
		
		public void closeDB() {
				try {
					if(rs != null){
						rs.close();
					}
					if(ps!=null){
						ps.close();
					}
					if(st!=null){
						st.close();
					}
					if(db!=null){
						db.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		
		public String getpwdbyUname(String param){
			getConn();

			String pwd = "";
			
	        try{
	            ps = db.prepareStatement("select employee_pass from public.employee where employee_id=?");
	            
	            ps.setString(1, param);	               
	            rs = ps.executeQuery();
	
				while(rs.next()) {
					pwd = rs.getString(1);
				}
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return pwd;       
	    }
		
		
		public String[] getuserinfobyguestSSN(String param){
			getConn();

			String[] pwd = new String[5];
			
	        try{
	            ps = db.prepareStatement("select * from public.guests where guest_ssn=?");
	            
	            ps.setString(1, param);	               
	            rs = ps.executeQuery();
	
				while(rs.next()) {
					pwd[0] = rs.getString(0);
					pwd[1] = rs.getString(2);
					pwd[2] = rs.getString(3);
					pwd[3] = rs.getString(4);
					pwd[4] = rs.getString(5);
				}
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return pwd;       
	    }
		public String[] getuserinfobyHostSSN(String param){
			getConn();

			String[] pwd = new String[7];
			
	        try{
	            ps = db.prepareStatement("select * from public.host where host_ssn=?");
	            
	            ps.setString(1, param);	               
	            rs = ps.executeQuery();
	
				while(rs.next()) {
					pwd[0] = rs.getString(0);
					pwd[1] = rs.getString(1);
					pwd[2] = rs.getString(2);
					pwd[3] = rs.getString(3);
					pwd[4] = rs.getString(4);
					pwd[5] = rs.getString(5);
					pwd[6] = rs.getString(6);
				
				}
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return pwd;       
	    }
		
		public boolean insertNewGuest(String[] param){
			getConn();

			
	        try{
	        	st = db.createStatement();
	        	sql = "insert into public.guests values('"+param[0]+"','"+param[1]+"','"+param[2]+"','"+param[3]+"','"+param[4]+"','"+param[5]+"')";
	        	
	        	System.out.print(sql);
	            
	            st.executeUpdate(sql);
	            
	            return true;

	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
	        }	       
	    }
		public boolean insertNewHost(String[] param){
			getConn();

			
	        try{
	        	st = db.createStatement();
	        	sql = "insert into public.host values('"+param[0]+"','"+param[1]+"','"+param[2]+"','"+param[3]+"','"+param[4]+"','"+param[5]+"','"+param[6]+"','"+param[7]+"','"+param[8]+"')";
	        	
	        	System.out.print(sql);
	            
	            st.executeUpdate(sql);
	            
	            return true;

	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
	        }	       
	    }
		
		public boolean insertNewProperty(String[] param){
			getConn();
			
	        try{
	        	st = db.createStatement();
	        	sql = "insert into public.property values('"+param[0]+"','"+param[1]+"','"+param[2]+"','"+param[3]+"','"+param[4]+"','"+param[5]+"','"+param[6]+"','"+param[7]+"','"+param[8]+"','"+param[9]+"','"+param[10]+"','"+param[11]+"')";
	        	
	        	System.out.print(sql);
	            
	            st.executeUpdate(sql);
	            
	            return true;

	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
	        }
		}
		
		public boolean insertReviews(String[] param) {
			getConn();
			
	        try{
	        	st = db.createStatement();
	        	sql = "insert into public.reviews values('"+param[0]+"','"+param[1]+"','"+param[2]+"','"+param[3]+"')";
	        	
	        	System.out.print(sql);
	            
	            st.executeUpdate(sql);
	            
	            return true;

	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
	        }
		}
		
		public boolean updatePropertyReviews(String ratings, String propAddress) {
			getConn();
			
			try{
				st = db.createStatement();
	        	sql = "update public.property set ratings='"+ ratings +"' where propertyaddress='"+propAddress+"'";
	            
	        	st.executeUpdate(sql);
	        	
	            
	            return true;

	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
	        }
		}
		
		public ArrayList<Room> getAllAvailRooms(){
			
			getConn();
			
			ArrayList<Room> Rooms = new ArrayList<Room>();
			
			try {
				ps = db.prepareStatement("select * from public.property where room_status='available'" );
				rs = ps.executeQuery();
				while(rs.next()){
					String propAddress = rs.getString("propertyaddress");
					String propType = rs.getString("propertytype");
					String roomType = rs.getString("roomtype");
					String startDate = rs.getString("startdate");
					String endDate = rs.getString("enddate");
					String price = rs.getString("price");
					String paymentType = rs.getString("paymenttype");
					String room_status = rs.getString("room_status");
					String guest_SSN = rs.getString("guest_ssn");
					String branch_id = rs.getString("branch_id");
					String ratings = rs.getString("ratings");
					String host_ssn = rs.getString("host_ssn");
					Room room = new Room(propAddress, propType, roomType, startDate, endDate,
							price, paymentType, room_status,guest_SSN,branch_id,ratings,host_ssn);
					Rooms.add(room);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
						
			return Rooms;
			
		}
		
		public  ArrayList<Room> getbookedRooms(String guest_SSN){
			
			getConn();
			
			ArrayList<Room> Rooms = new ArrayList<Room>();
			
			try {
				ps = db.prepareStatement("select * from public.property where guest_ssn='"+guest_SSN+"'");
				rs = ps.executeQuery();
				while(rs.next()){
					String propAddress = rs.getString("propertyaddress");
					String propType = rs.getString("propertytype");
					String roomType = rs.getString("roomtype");
					String startDate = rs.getString("startdate");
					String endDate = rs.getString("enddate");
					String price = rs.getString("price");
					String paymentType = rs.getString("paymenttype");
					String room_status = rs.getString("room_status");
//					String guest_SSN = rs.getString("guest_SSN");
					String branch_id = rs.getString("branch_id");
					String ratings = rs.getString("ratings");
					String host_ssn = rs.getString("host_ssn");
					Room room = new Room(propAddress, propType, roomType, startDate, endDate,
							price, paymentType, room_status,guest_SSN,branch_id,ratings,host_ssn);
					Rooms.add(room);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
						
			return Rooms;
			
		}
		//need to be modified
		public String bookRoom(String guest_SSN,String propAddress){
			getConn();
			
			
	        try{
				
	        	st = db.createStatement();
	        	sql = "update public.property set guest_ssn='"+guest_SSN+"', room_status='booked' where propertyaddress='"+propAddress+"'";
	            st.executeUpdate(sql);
	            
	            
	            

	        }catch(SQLException e){
	            e.printStackTrace();
	            return "";	 
	        }finally {
	        	closeDB();
	        }
			
	        return guest_SSN;
	        
	    }
		
		
		
		
		
//		public static void main(String []args) {
//			PostgreSqlConn con = new PostgreSqlConn();
//			con.getConn();
////			String[] pwd = con.getuserinfobyHostSSN("123");
////			System.out.println(pwd);
////			con.bookRoom("111", "123Drive");
//			System.out.println(con.getbookedRooms("111"));
//			
//			
//			
//		}

		
	}

