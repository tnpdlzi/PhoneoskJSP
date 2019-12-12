package dto;


public class Store {
	private int storeID;
	private String name;
	private String address;
	private int phone;
	private int open;
	private int close;
	
	public Store() {
		this(0, null, null, 0, 0, 0);
	}
	
	public Store(int storeID, String name, String address, int phone, int open, int close) {
		this.storeID = storeID;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.open = open;
		this.close = close;
	}
	
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getOpen() {
		return open;
	}
	public void setOpen(int open) {
		this.open = open;
	}
	public int getClose() {
		return close;
	}
	public void setClose(int close) {
		this.close = close;
	}
	@Override
	public String toString() {
		return "Store [storeID=" + storeID + ", name=" + name + ", address=" + address + ", phone=" + phone + ", open="
				+ open + ", close=" + close + "]";
	}

}
