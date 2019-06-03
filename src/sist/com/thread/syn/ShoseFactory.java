package sist.com.thread.syn;

public class ShoseFactory implements Runnable {
	private Shose shose;
	public ShoseFactory(Shose shose) {
		super();
		this.shose=shose;
				
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				shose.push(shose.ShoseMake());
				
			
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}
