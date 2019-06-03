package sist.com.thread.syn;

public class ShoseByuer implements Runnable{
	private Shose shose;
	public ShoseByuer(Shose shose) {
		super();
		this.shose=shose;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep((int)(Math.random()*1000));
				shose.pop();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	
	}
	
	
}
