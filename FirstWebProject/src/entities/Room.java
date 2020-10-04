package entities;


public class Room {
	
	private String propAddress;
	private String propType;
	private String roomType;
	private String startDate;
	private String endDate;
	private String price;
	private String paymentType;
	private String room_status;
	private String guest_SSN;
	private String branch_id;
	private String ratings;
	private String host_SSN;
	
	public Room() {
		
	}
	
	public Room(String propAddress, String propType, String roomType, String startDate, String endDate,
			String price, String paymentType,String room_status,String guest_SSN,String branch_id,String ratings,String host_SSN) {
		this.propAddress = propAddress;
		this.propType = propType;
		this.roomType = roomType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.paymentType = paymentType;
		this.room_status = room_status;
		this.guest_SSN = guest_SSN;
		this.branch_id = branch_id;
		this.ratings = ratings;
		this.host_SSN = host_SSN;
		
	}

	public String getPropAddress() {
		return propAddress;
	}

	public void setPropAddress(String propAddress) {
		this.propAddress = propAddress;
	}

	public String getPropType() {
		return propType;
	}

	public void setPropType(String propType) {
		this.propType = propType;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public String getRoom_status() {
		return room_status;
	}

	public void setRoom_status(String room_status) {
		this.room_status = room_status;
	}
	
	public String getGuest_SSN() {
		return guest_SSN;
	}

	public void setGuest_SSN(String guest_SSN) {
		this.guest_SSN = guest_SSN;
	}

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public String getHost_SSN() {
		return host_SSN;
	}

	public void setHost_SSN(String host_SSN) {
		this.host_SSN = host_SSN;
	}

	public String getRoomDetails() {
		return ( propAddress +", "+ propType+", " + roomType+", " + startDate+" to " + endDate+", " + price+"CAD, " + paymentType);
	}
	
//	public static void main(String []args) {
//		
//		Room room = new Room("123","222","new","","","123","cash","available","","1");
//		room.getPropAddress();
////		System.out.println(room);
//		
//	}

}
