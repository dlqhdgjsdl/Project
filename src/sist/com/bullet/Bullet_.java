package sist.com.bullet;





public class Bullet_ extends Thread{
	
	//private boolean st=true;
	private Bullet1 t;
	private final int i;
	private final int cnt1;
	private BulletHero bh;
	private boolean is=true;
	
	public Bullet_(Bullet1 t,int cnt1,int i) {
		super();
		this.t=t;
		this.i=i;
		this.cnt1=cnt1;
		
	}



	public boolean isIs() {
		return is;
	}



	public void setIs(boolean is) {
		this.is = is;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		
		
		
		while(is) {
			
			try {
				Thread.sleep(20);
		
				if(t.getY(i)<t.getSunCanvas().getHeight()) {//히어로의 좌표를 얻어 빨간색 공들이 히어로를 따라가게 만듬
					
					
					t.setX(t.getX(i)+(int)Math.round(((t.getHx()-t.getX(i))/Math.sqrt(Math.pow(t.getHx()-t.getX(i), 2)+Math.pow(t.getHy()-t.getY(i), 2)))), i);
					t.setY(t.getY(i)+(int)Math.round(((t.getHy()-t.getY(i))/Math.sqrt(Math.pow(t.getHx()-t.getX(i), 2)+Math.pow(t.getHy()-t.getY(i), 2)))), i);
					
					}
						
				
				
				
				
				
				if(t.getY1(i)>0){//아래에서 위로 총알이 날라온다.
					
					
					t.setY1(t.getY1(i)-(int)(Math.random()*cnt1), i);
					
				}else {
					t.setY1(t.getSunCanvas().getHeight(),i);
					t.setX1((int)(Math.random()*t.getSunCanvas().getWidth()),i);
					
				}
				if(0<t.getX2(i)) {//오른쪽에서 위쪽으로 총알이 날라온다.
					
					
					t.setX2(t.getX2(i)-(int)(Math.random()*cnt1), i);
					
				}else {
					t.setX2(t.getSunCanvas().getWidth(),i);
					t.setY2((int)(Math.random()*t.getSunCanvas().getHeight()),i);
					
				}
				if(t.getX3(i)<t.getSunCanvas().getWidth()) {//왼쪽에서 오른쪽으로 총알이 날라온다.
					
					
					t.setX3(t.getX3(i)+(int)(Math.random()*cnt1),i);
				
					}else {
					t.setX3(0,i);
					t.setY3((int)(Math.random()*t.getSunCanvas().getHeight()),i);
					
				}
				
				
				t.getSunCanvas().repaint();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}
	
}

