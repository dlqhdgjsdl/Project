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
					//System.out.println("����");
					bullet.setX((int)Math.round((bullet.getX(i)+(bullet.getHx()-bullet.getX(i))/Math.sqrt(Math.pow(bullet.getHx()-bullet.getX(i), 2)+Math.pow(bullet.getHy()-bullet.getY(i), 2)))), i);
					bullet.setY((int)Math.round((bullet.getY(i)+(bullet.getHy()-bullet.getY(i))/Math.sqrt(Math.pow(bullet.getHx()-bullet.getX(i), 2)+Math.pow(bullet.getHy()-bullet.getY(i), 2)))), i);
					
					}else{//ȭ������� �������� ��ġ�� �ٽ� �������� 
						bullet.setY(0,i);
						bullet.setX(0,i);
						bullet.setX((int)Math.round((bullet.getX(i)+(bullet.getHx()-bullet.getX(i))/Math.sqrt(Math.pow(bullet.getHx()-bullet.getX(i), 2)+Math.pow(bullet.getHy()-bullet.getY(i), 2)))), i);
						bullet.setY((int)Math.round((bullet.getY(i)+(bullet.getHy()-bullet.getY(i))/Math.sqrt(Math.pow(bullet.getHx()-bullet.getX(i), 2)+Math.pow(bullet.getHy()-bullet.getY(i), 2)))), i);
						//t.setX((int)(Math.random()*t.getSunCanvas().getWidth()),i);
						
					}*/
				
				if(bullet.getIncrement()<=60) {//60�����϶��� �ʸ� �����̱�
				Thread.sleep(1000);//�����带 �־� �ð� �帧�ֱ� (1000=1��)
				bullet.setIncrement(bullet.getIncrement()+1);//�ʰ� 1������
				bullet.getJpal().setText("���ϴ� �ð�:"+String.valueOf((bullet.getIncrement1()+"��").concat(bullet.getIncrement()+"��")));				
				//�а� ���� �ð��� ���� �ð������� �帣�� ����
				
				}else if(bullet.getIncrement()>60) {//60�̻��̸� ���� 1�ö󰡰� �ʰ� �ٽ� ���µǾ� ������
					Thread.sleep(100); 
					bullet.setIncrement1(bullet.getIncrement1()+1);
					bullet.setIncrement(bullet.getIncrement()*0);
					bullet.getJpal().setText("���ϴ� �ð�:"+String.valueOf((bullet.getIncrement1()+"��").concat(bullet.getIncrement()+"��")));
				}
				} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
	
	
	
	
	
	

}
