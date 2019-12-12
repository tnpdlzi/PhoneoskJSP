package dto;


public class Menu {
	private int storeID;
	private int menuID;
	private String menuName;
	private int price;
	
	
	public Menu() {
		this(0, 0, null, 0);
	}
	
	public Menu(int storeID, int menuID, String menuName, int price) {
		this.storeID = storeID;
		this.menuID = menuID;
		this.menuName = menuName;
		this.price = price;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public int getMenuID() {
		return menuID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Menu [storeID=" + storeID + ", menuID=" + menuID + ", menuName=" + menuName + ", price=" + price + "]";
	}


}
