package sist.com.bullet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

public class BulletHero extends Thread implements ActionListener {
	private boolean st=true;//while의 조건을 만족시키기 위해 boolean상태의 인스턴스 변수를 설정해준다
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
			t.keyProcess();//게임을 시작할때 키프로세스 기능을 실행되도록 설정
			for (int i = 0; i <cnt ; i++) {
			if(t.getY(i)+4>t.getHy() &&t.getY(i)-4<t.getHy() && t.getX(i)+4>t.getHx()
					&& t.getX(i)-4<t.getHx()) {//9는 날아오는 총알의 범위 
				j=t.getJpal().getText();
				//타이틀에 피하는 시간초가 나오게 했슴
				for (int j = 0; j < t.getT().length; j++) {					
					t.getT()[j].setIs(false);
					
					}
				r=jop1.showConfirmDialog(null,"저런 총알을 맞으셨군요 ㅠㅠ 다시하시겠습니까?",j,jop1.YES_NO_OPTION);
				t.dispose();  
				h=1;
				if(r==jop1.YES_OPTION) {
					st=false;
					new BulletLogin();
					
				}
				else {
					st=false;
					s=jop2.showInputDialog("플레이어","기록할 이름을 적어주세요");
					if(s!=null) {//입력박스와 비교해서 값이 들어 있으면 실행
						
						BulletCrud bc=new BulletCrud(this,t);// pushmember를 통해
						
						bc.pushMember();							//crud구현
						
						
					t.dispose();
				}
				}
				
			}else if(t.getY1(i)+4>t.getHy() &&t.getY1(i)-4<t.getHy() && t.getX1(i)+4>t.getHx()
					&& t.getX1(i)-4<t.getHx()) {
				j=t.getJpal().getText();
				for (int j = 0; j < t.getT().length; j++) {					
					t.getT()[j].setIs(false);
					
				}
				
				
				
				r=jop1.showConfirmDialog(null,"저런 총알을 맞으셨군요 ㅠㅠ 다시하시겠습니까?",j,jop1.YES_NO_OPTION);
				t.dispose();
				
				
				if(r==jop1.YES_OPTION) {
					st=false;
					new BulletLogin();
					
				}else {
					st=false;
					s=jop2.showInputDialog("플레이어","기록할 이름을 적어주세요");
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
				r=jop1.showConfirmDialog(null,"저런 총알을 맞으셨군요 ㅠㅠ 다시하시겠습니까?",j,jop1.YES_NO_OPTION);
				t.dispose();
				
				
				if(r==jop1.YES_OPTION) {
					st=false;
					new BulletLogin();
					
				}else {
					st=false;
					s=jop2.showInputDialog("플레이어","기록할 이름을 적어주세요");
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
				r=jop1.showConfirmDialog(null,"저런 총알을 맞으셨군요 ㅠㅠ 다시하시겠습니까?",j,jop1.YES_NO_OPTION);
				t.dispose();
				
				if(r==jop1.YES_OPTION) {
					st=false;
					new BulletLogin();
				
				}else {
					st=false;
					s=jop2.showInputDialog("플레이어", "기록할 이름을 적어주세요");
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

		
	