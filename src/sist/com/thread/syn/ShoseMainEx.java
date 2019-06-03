package sist.com.thread.syn;

public class ShoseMainEx {
	
	public static void main(String[] args) {
		Shose shose = new Shose();
		
		ShoseByuer byuer = new ShoseByuer(shose);
		ShoseFactory factory = new ShoseFactory(shose);
		
		Thread t1 = new Thread(byuer);
		Thread t2 = new Thread(factory);
		
		t1.start();
	
		t2.start();
	
	
	}

}
