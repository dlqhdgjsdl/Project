package sist.com.bullet;

import java.io.Serializable;

public class BulletMember implements Serializable {
	private String id;
	private	int pk=1;
	private String time;
	
	public	BulletMember() {
		super();
	}
	public BulletMember(String id, int pk, String time) {
		super();
		this.id=id;
		this.pk=pk;
		this.time=time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "BulletMember [id=" + id + ", pk=" + pk + ", time=" + time + "]";
	}
	
}
