package sist.com.newproject;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class ShoseLogin extends JFrame implements ActionListener {
	private JPanel jp3,jp1,jp2,jp4,jp5;
	private JTextField jtfd;
	private JPasswordField jpp;
	private JLabel jlb,jlb2;
	private JButton jbtn1, jbtn2 , jbtn3;
	private ImageIcon icon=new ImageIcon("C:\\Users\\user\\Desktop\\���� ������Ʈ\\�ڹ�(���� crud) ������Ʈ\\�Ź��̹���\\main.jpg");
	private JOptionPane jop;
//panel �ϳ��� ������ 
	//mouset Listener  mouse motion listener �� ���������ӿ� �޴��� ���̵� ������ �� �ֵ�.
	
	
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("����") && jtfd.getText().trim().equals("�̺���")) {
			if(jtfd.getText().trim().equals("�̺���")&& String.valueOf(jpp.getPassword()).equals("7830")) {
				jbtn1.grabFocus();
				dispose();
				jop.showMessageDialog(jbtn1,"�����ڷ� �α����ϼ̽��ϴ�.");
				new ShoseManager();
				//new ShoseService("211.63.89.106","bongbong");ä��â ������
				this.setVisible(false);
			}else  {
				jbtn1.grabFocus();
				jop.showMessageDialog(jbtn1,"�߸��Է��ϼ̽��ϴ�.");
			
			}
		}
		if(e.getActionCommand().equals("����") && !(jtfd.getText().trim().equals("�̺���"))) {
				
			if(ShoseDao.idserch(jtfd.getText(),String.valueOf(jpp.getPassword())).equals(jtfd.getText())) {
					
					//new ShoseService("211.63.89.106","bongbong");ä��â ������
					this.setVisible(false);
					jbtn1.grabFocus();
					dispose();
					new ChooseShose();
				}else {
					
					jbtn1.grabFocus();
					jop.showMessageDialog(jbtn1,"�߸��Է��ϼ̽��ϴ�.");
				}
				
		}
		 if(e.getActionCommand().equals("���")) {
				System.exit(0);;
			
		}
		
		if(e.getActionCommand().equals("ȸ������")) {
			
			new ShoseLoginByer();
			
			
		}
	}




	public void initLayEx() {
	jp1=new JPanel();
	jp4=new JPanel() {

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			g.drawImage(icon.getImage(),0,0,400,400,null);
			
		}
		
	};
	jp1.add(jlb=new JLabel("�α���"));
	//jlb.setOpaque(false);
	jlb.setForeground(Color.CYAN);
	jp1.setOpaque(false);//jpanel�� �����ϰ� �־ �ڿ��ִ� ���ȭ���� ���̰� ����
	jp1.add(jtfd=new JTextField(20));
	jp2=new JPanel();
	jp2.add(jlb2=new JLabel("��й�ȣ"));
	jlb2.setForeground(Color.CYAN);
	jp2.setOpaque(false);
	jp2.add(jpp=new JPasswordField(17));
	jp3=new JPanel();
	jp3.add(jbtn1=new JButton("����"));
	jpp.addActionListener(this);
	
	jpp.addKeyListener(new KeyAdapter() {//����Ű ���� �ؾߵ�

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyChar();
			//System.out.println(e.getKeyCode());//����Ű �ƽ�Ű �ڵ尪�� �˾ƺ� 
			if(key==10 && jtfd.getText().trim().equals("�̺���") ) {
				if(jtfd.getText().trim().equals("�̺���")&& String.valueOf(jpp.getPassword()).equals("7830")) {
					jbtn1.grabFocus();
					dispose();
					jop.showMessageDialog(jbtn1,"�����ڷ� �α����ϼ̽��ϴ�.");
					new ShoseManager();
					}else {
						jbtn1.grabFocus();
						jop.showMessageDialog(jbtn1,"�߸��Է��ϼ̽��ϴ�.");
					}
			}
					//new ShoseService("211.63.89.106","bongbong");
					//this.setVisible(false);
					if(key==10 && !(jtfd.getText().trim().equals("�̺���"))) {// �����ͺ��̽��� ����� ������ �޾Ƽ� �α��� �ǰ� �ؾ��� 
						if(ShoseDao.idserch(jtfd.getText(),String.valueOf(jpp.getPassword())).equals(jtfd.getText())) {
							jbtn1.grabFocus();
							dispose();
							new ChooseShose();
						}else {
							jbtn1.grabFocus();
							jop.showMessageDialog(jbtn1,"�߸��Է��ϼ̽��ϴ�.");
						}
				
				
			}
			
		}
		
	});
	jbtn1.addActionListener(this);
	jp3.setOpaque(false);
	jp3.add(jbtn2=new JButton("���"));
	jp3.add(jbtn3=new JButton("ȸ������"));
	jbtn3.addActionListener(this);
	jbtn2.addActionListener(this);
	jp5=new JPanel();
	jp5.setOpaque(false);
	jp5.add(jp1);
	jp5.add(jp2);
	jp5.setBounds(40,440,300,120);
	jp3.setBounds(135,520,150,80);
	
	this.add(jp3);
	this.add(jp5);
	this.add(jp4);
	
	//jp4.setBackground(Color.yellow);
	jp4.setOpaque(true);
	//this.add("South",)
	}
	
	
	
	
	public ShoseLogin() {
		initLayEx();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				jtfd.requestFocus();
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			
			
			
		});
		//this.setUndecorated(true);//���ڷ���Ʈ�� ����ϸ� Ÿ��Ʋ ����� ���ּ� �ִ�.
		this.setBounds(100, 100, 400, 630);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((d.width-this.getWidth())/2,(d.height-this.getHeight())/2);
		//pack();
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		this.setTitle("�α���");
		//this.setBounds(0, 0, d.width, d.height);
		}
	
	public static void main(String[] args) {
		ShoseLogin s = new ShoseLogin();
	
	}
	
	
}
