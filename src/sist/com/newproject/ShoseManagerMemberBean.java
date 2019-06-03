package sist.com.newproject;

public class ShoseManagerMemberBean {
	private int number;
	private String shosename;
	private String size;
	private String price;
	private String count;
	private String color;
	private String num;
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public ShoseManagerMemberBean() {
		super();
	}

	public ShoseManagerMemberBean(int number, String shosename, String size, String price, String count, String color) {
		super();
		this.number = number;
		this.shosename = shosename;
		this.size = size;
		this.price = price;
		this.count = count;
		this.color = color;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getShosename() {
		return shosename;
	}
	public void setShosename(String shosename) {
		this.shosename = shosename;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getprice() {
		return price;
	}
	public void setprice(String price) {
		this.price = price;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
}
