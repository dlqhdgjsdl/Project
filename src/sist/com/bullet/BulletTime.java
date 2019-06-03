package sist.com.bullet;

import java.util.concurrent.ThreadLocalRandom;

public class BulletTime  extends Thread{
	Bullet1 bullet;
	BulletLogin bl;
	private int i;
	
	
	public BulletTime(Bullet1 bullet) {
		super();
		this.bullet = bullet;
		
	}

	@Override
	public void run() { 
		// TODO Auto-generated method stub

		while (true) {
			//if(bullet.getGG()==1) return;
			try {
				
				/*if(bullet.getIncrement()==10) {
					Thread.sleep(20);
					//System.out.println("실행");
					bullet.setX((int)Math.round((bullet.getX(i)+(bullet.getHx()-bullet.getX(i))/Math.sqrt(Math.pow(bullet.getHx()-bullet.getX(i), 2)+Math.pow(bullet.getHy()-bullet.getY(i), 2)))), i);
					bullet.setY((int)Math.round((bullet.getY(i)+(bullet.getHy()-bullet.getY(i))/Math.sqrt(Math.pow(bullet.getHx()-bullet.getX(i), 2)+Math.pow(bullet.getHy()-bullet.getY(i), 2)))), i);
					
					}else{//화면밖으로 나갔을대 위치를 다시 설정해줌 
						bullet.setY(0,i);
						bullet.setX(0,i);
						bullet.setX((int)Math.round((bullet.getX(i)+(bullet.getHx()-bullet.getX(i))/Math.sqrt(Math.pow(bullet.getHx()-bullet.getX(i), 2)+Math.pow(bullet.getHy()-bullet.getY(i), 2)))), i);
						bullet.setY((int)Math.round((bullet.getY(i)+(bullet.getHy()-bullet.getY(i))/Math.sqrt(Math.pow(bullet.getHx()-bullet.getX(i), 2)+Math.pow(bullet.getHy()-bullet.getY(i), 2)))), i);
						//t.setX((int)(Math.random()*t.getSunCanvas().getWidth()),i);
						
					}*/
				
				if(bullet.getIncrement()<=60) {//60이하일때는 초만 움직이기
				Thread.sleep(1000);//스레드를 주어 시간 흐름주기 (1000=1초)
				bullet.setIncrement(bullet.getIncrement()+1);//초가 1씩증가
				bullet.getJpal().setText("피하는 시간:"+String.valueOf((bullet.getIncrement1()+"분").concat(bullet.getIncrement()+"초")));				
				//분과 초의 시간이 게임 시간에따라 흐르게 설정
				
				}else if(bullet.getIncrement()>60) {//60이상이면 분이 1올라가고 초가 다시 리셋되어 움직임
					Thread.sleep(100); 
					bullet.setIncrement1(bullet.getIncrement1()+1);
					bullet.setIncrement(bullet.getIncrement()*0);
					bullet.getJpal().setText("피하는 시간:"+String.valueOf((bullet.getIncrement1()+"분").concat(bullet.getIncrement()+"초")));
				}
				} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
	
	
	
	
	
	

}
