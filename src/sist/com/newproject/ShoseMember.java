package sist.com.newproject;

public class ShoseMember {
	private int number;
	private String manager;
	private String shosename;
	private String contruy;
	private String count;
	private String color;
	
	public ShoseMember() {
		super();
	}

	public ShoseMember(int number, String manager, String shosename, String contruy, String count, String color) {
		super();
		this.number = number;
		this.manager = manager;
		this.shosename = shosename;
		this.contruy = contruy;
		this.count = count;
		this.color = color;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getShosename() {
		return shosename;
	}
	public void setShosename(String shosename) {
		this.shosename = shosename;
	}
	public String getContruy() {
		return contruy;
	}
	public void setContruy(String contruy) {
		this.contruy = contruy;
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
