package sist.com.bullet;


import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.SwingConstants;


public class Bullet1 extends JFrame  {
	
	boolean KeyUp = false; //Ű�� �ε巴�� �̵��ϱ����� boolean���� �̸� ��
	boolean KeyDown = false;
	boolean KeyLeft = false;
	boolean KeyRight = false;
	boolean KeySpace = false;
	/////////////////////////////////
	private int increment;
	private int increment1;
	private int chk=0;
	private	JLabel jpal;
	private SunCanvas sunCanvas=new SunCanvas();
	private final int cnt=10;
	private final int cnt1=5;
	private int y[] = new int [cnt];
	private int x[] =new int [cnt];
	private int x1[] = new int [cnt];
	private int y1[] = new int [cnt];
	private int x2[] = new int [cnt];
	private int y2[] = new int [cnt];
	private int x3[] = new int [cnt];
	private int y3[] = new int [cnt];
	
	private Bullet_[]t=new Bullet_[cnt];
	
	
	private Thread h1=new Thread();
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	private int hx=250,hy=250;
	private static final int SPEED=1;
	private	Image buffimage;
	private	Graphics buffg;
	private ImageIcon icon = new ImageIcon("C:\\Users\\user\\Desktop\\���� ������Ʈ\\����������Ʈ(����,����)\\�Ѿ����ϱ�\\bullet �ڷ�\\������ ���ȭ��\\11.jpg");
	private ImageIcon icon2= new ImageIcon("C:\\Users\\user\\Desktop\\���� ������Ʈ\\����������Ʈ(����,����)\\�Ѿ����ϱ�\\bullet �ڷ�\\������ ���ȭ��\\14.png");
	
	
	private int gg;
	
	
	
	public Bullet_[] getT() {
		return t;
	}
	public void setT(Bullet_[] t) {
		this.t = t;
	}
	public int getChk() {
		return chk;
	}
	public void setChk(int chk) {
		this.chk = chk;
	}
	public int getIncrement1() {
		return increment1;
	}
	public void setIncrement1(int increment1) {
		this.increment1 = increment1;
	}
	public JLabel getJpal() {
		return jpal;
	}
	public void setJpal(JLabel jpal) {
		this.jpal = jpal;
	}
	public int getIncrement() {
		return increment;
	}
	public void setIncrement(int increment) {
		this.increment = increment;
	}
	public int getHx() {
		return hx;
	}
	public void setHx(int hx) {
		this.hx = hx;
	}
	public int getHy() {
		return hy;
	}
	public void setHy(int hy) {
		this.hy = hy;
	}
	public int getX2(int i) {
		return x2[i];
	}
	public void setX2(int x2,int i) {
		this.x2[i] = x2;
	}
	public int getY2(int i) {
		return y2[i];
	}
	public void setY2(int y2,int i) {
		this.y2[i] = y2;
	}
	public int getX3(int i) {
		return x3[i];
	}
	public void setX3(int x3,int i) {
		this.x3[i] = x3;
	}
	public int getY3(int i) {
		return y3[i];
	}
	public void setY3(int y3,int i) {
		this.y3[i] = y3;
	}
	public SunCanvas getSunCanvas() {
		return sunCanvas;
	}
	public int getX1(int i) {
		return x1[i];
	}
	public void setX1(int x1,int i) {
		this.x1[i] = x1;
	}
	public int getY1(int i) {
		return y1[i];
	}
	public void setY1(int y1,int i) {
		this.y1[i] = y1;
	}
	public void setSunCanvas(SunCanvas sunCanvas) {
		this.sunCanvas = sunCanvas;
	}
	public int getX(int i) {
		return x[i];
	}
	public void setX(int x,int i) {
		this.x[i] = x;
	}
	public int getY(int i) {
		return y[i];
	}
	public void setY(int y,int i) {
		this.y[i] = y;
	}
	
	public int getGG() {
		return gg;
	}
	public void keyProcess() {
		if(KeyUp)  hy -= SPEED;		
		if(KeyDown) hy+= SPEED;
		if(KeyLeft)  hx-= SPEED;
		if(KeyRight) hx+= SPEED;		
		
		
	}

	
	public   Bullet1() {
		
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				switch (e.getKeyCode()) {//Ű�� ���� false�� �ٲ��� �������� ����
				case KeyEvent.VK_UP:
					KeyUp=false;
					break;
				case KeyEvent.VK_DOWN:
					KeyDown=false;
					break;
				case KeyEvent.VK_RIGHT:
					KeyRight=false;
					break;
				case KeyEvent.VK_LEFT:
					KeyLeft=false;
					break;
				case KeyEvent.VK_SPACE:
					KeySpace=false;
					break;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {//Ű�� ������ �־����� ��� true���� �־� �����̰� ����
				case KeyEvent.VK_UP:
					KeyUp=true;
					break;
				case KeyEvent.VK_DOWN:
					KeyDown=true;
					break;
				case KeyEvent.VK_RIGHT:
					KeyRight=true;
					break;
				case KeyEvent.VK_LEFT:
					KeyLeft=true;
					break;
				case KeyEvent.VK_SPACE:
					KeySpace=true;
					break;
				}
					

			}
		});
		this.add(sunCanvas);
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
			
				for (int i = 0; i < cnt; i++) {//��ġ ���� �ؼ� ���Ʒ� ���ʿ����ʿ��� ������ ���ش�.
					
		 			x[i]=(int)(Math.random() * getSunCanvas().getWidth());
					y[i]=(int)(Math.random() * getSunCanvas().getHeight())-450;
					x1[i]=(int)(Math.random() * getSunCanvas().getWidth());
					y1[i]=(int)(Math.random() * getSunCanvas().getHeight())+450;
					x2[i]=(int)(Math.random() * getSunCanvas().getWidth())+450;
					y2[i]=(int)(Math.random() * getSunCanvas().getHeight());
					x3[i]=(int)(Math.random() * getSunCanvas().getWidth())-450;
					y3[i]=(int)(Math.random() * getSunCanvas().getHeight());
					
					t[i] = new Bullet_(Bullet1.this,cnt1,i);
					t[i].start();//bullet_�����带 ����
					
			
				}
				
				h1=new Thread(new BulletHero(Bullet1.this));
				h1.start();//����� �����带 ����
				BulletTime t= new BulletTime(Bullet1.this);
				t.start();//Ÿ�� �����带 ����
				
				
					
					
			}
				
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
			}
			
			
		});
		
		
		
		jpal=new JLabel("���ϴ� �ð�:0��0��");//label �ؽ��� ����
		jpal.setHorizontalAlignment(SwingConstants.CENTER);//label��ġ ����
		this.add(jpal,BorderLayout.NORTH);
		this.setBounds(100,100,500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("����ϱ�");
		this.setResizable(false);
		this.setLocation((int)((d.width-this.getWidth())/2),(int)((d.getHeight()-this.getHeight())/2));
		
	}
	
	
   //
	
	public class SunCanvas extends Canvas {

		@Override
		public void paint(Graphics g) {//���� ���۸���� !
			// TODO Auto-generated method stub
			
			if(buffg==null) {
			buffimage = createImage(500,500);
			buffg=buffimage.getGraphics();
			}
			
			buffg.drawImage(icon.getImage(), 0,0,500,500,this);
			for (int i = 0; i < cnt; i++) {
			
				
				buffg.setColor(Color.red );
				buffg.fillOval(x[i],y[i], 10,10);// �������Ʒ�
				buffg.setColor(Color.LIGHT_GRAY);
				buffg.fillOval(x1[i], y1[i],10,10);//�Ʒ����� ��
				buffg.fillOval(x2[i], y2[i], 10,10);//�����ʿ��� ����
				buffg.fillOval(x3[i], y3[i], 10,10);//���ʿ��� ������
		
			/*buffg.drawImage(icon3.getImage(),x[i], y[i],this);
			buffg.drawImage(icon3.getImage(),x1[i], y1[i],this);
			buffg.drawImage(icon3.getImage(),x2[i], y2[i],this);
			buffg.drawImage(icon3.getImage(),x3[i], y3[i],this);
			Ȥ�ö� ��̹����� ã���� ���� �ҽ�*/
			}
		
				
				buffg.drawImage(icon2.getImage(),hx-20,hy-20,this);//�̹��� ���ΰ�
			g.drawImage(buffimage,0,0,this);
			repaint();
			buffg.clearRect(0,0, 500,500);
			
		}
		
		@Override
		public void update(Graphics g) {
			// TODO Auto-generated method stub
			paint(g);
			
		 
		}
	}
	

}
