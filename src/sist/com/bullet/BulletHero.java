package sist.com.bullet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

public class BulletHero extends Thread implements ActionListener {
	private boolean st=true;//while�� ������ ������Ű�� ���� boolean������ �ν��Ͻ� ������ �������ش�
	private Bullet1 t;
	private final int cnt=10;
	private JOptionPane jop1,jop2;
	private BulletCrud bcr;
	private int h=0;
	private String s,j = null;
	
	
	
	public String getJ() {
		return j;
	} 

	public void setJ(String j) {
		this.j = j;
	}

	public JOptionPane getJop1() {
		return jop1;
	}

	public void setJop1(JOptionPane jop1) {
		this.jop1 = jop1;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public BulletHero(Bullet1 t) {
		super();
		this.t = t;
		
		
		
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		int r = 0;
		
		while(st) {
			try {
				Thread.sleep(5);				
			} catch (Exception e) {
				// TODO: handle exception
			}
			t.keyProcess();//������ �����Ҷ� Ű���μ��� ����� ����ǵ��� ����
			for (int i = 0; i <cnt ; i++) {
			if(t.getY(i)+4>t.getHy() &&t.getY(i)-4<t.getHy() && t.getX(i)+4>t.getHx()
					&& t.getX(i)-4<t.getHx()) {//9�� ���ƿ��� �Ѿ��� ���� 
				j=t.getJpal().getText();
				//Ÿ��Ʋ�� ���ϴ� �ð��ʰ� ������ �߽�
				for (int j = 0; j < t.getT().length; j++) {					
					t.getT()[j].setIs(false);
					
					}
				r=jop1.showConfirmDialog(null,"���� �Ѿ��� �����̱��� �Ф� �ٽ��Ͻðڽ��ϱ�?",j,jop1.YES_NO_OPTION);
				t.dispose();  
				h=1;
				if(r==jop1.YES_OPTION) {
					st=false;
					new BulletLogin();
					
				}
				else {
					st=false;
					s=jop2.showInputDialog("�÷��̾�","����� �̸��� �����ּ���");
					if(s!=null) {//�Է¹ڽ��� ���ؼ� ���� ��� ������ ����
						
						BulletCrud bc=new BulletCrud(this,t);// pushmember�� ����
						
						bc.pushMember();							//crud����
						
						
					t.dispose();
				}
				}
				
			}else if(t.getY1(i)+4>t.getHy() &&t.getY1(i)-4<t.getHy() && t.getX1(i)+4>t.getHx()
					&& t.getX1(i)-4<t.getHx()) {
				j=t.getJpal().getText();
				for (int j = 0; j < t.getT().length; j++) {					
					t.getT()[j].setIs(false);
					
				}
				
				
				
				r=jop1.showConfirmDialog(null,"���� �Ѿ��� �����̱��� �Ф� �ٽ��Ͻðڽ��ϱ�?",j,jop1.YES_NO_OPTION);
				t.dispose();
				
				
				if(r==jop1.YES_OPTION) {
					st=false;
					new BulletLogin();
					
				}else {
					st=false;
					s=jop2.showInputDialog("�÷��̾�","����� �̸��� �����ּ���");
					if(s!=null) {
						
					BulletCrud bc=new BulletCrud(this,t);
					
					bc.pushMember();	
					
					t.dispose();
					
					}
					}
			}else if(t.getY2(i)+4>t.getHy() &&t.getY2(i)-4<t.getHy() && t.getX2(i)+4>t.getHx()
					&& t.getX2(i)-4<t.getHx()) {
				j=t.getJpal().getText();
				for (int j = 0; j < t.getT().length; j++) {					
					t.getT()[j].setIs(false);
					
				}
				r=jop1.showConfirmDialog(null,"���� �Ѿ��� �����̱��� �Ф� �ٽ��Ͻðڽ��ϱ�?",j,jop1.YES_NO_OPTION);
				t.dispose();
				
				
				if(r==jop1.YES_OPTION) {
					st=false;
					new BulletLogin();
					
				}else {
					st=false;
					s=jop2.showInputDialog("�÷��̾�","����� �̸��� �����ּ���");
					if(s!=null) {
						
						BulletCrud bc=new BulletCrud(this,t);
						
						bc.pushMember();
						
					t.dispose();
					}
					}
			}else if(t.getY3(i)+4>t.getHy() &&t.getY3(i)-4<t.getHy() && t.getX3(i)+4>t.getHx()
					&& t.getX3(i)-4<t.getHx()) {
				j=t.getJpal().getText();
				for (int j = 0; j < t.getT().length; j++) {					
					t.getT()[j].setIs(false);
					
				}
				r=jop1.showConfirmDialog(null,"���� �Ѿ��� �����̱��� �Ф� �ٽ��Ͻðڽ��ϱ�?",j,jop1.YES_NO_OPTION);
				t.dispose();
				
				if(r==jop1.YES_OPTION) {
					st=false;
					new BulletLogin();
				
				}else {
					st=false;
					s=jop2.showInputDialog("�÷��̾�", "����� �̸��� �����ּ���");
					if(s!=null) {
						
						BulletCrud bc=new BulletCrud(this,t);
						
						bc.pushMember();
						
						
					t.dispose();
				}
				}
			}
			
		}
			
		
	}
	}
}

		
	