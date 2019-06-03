package sist.com.bullet;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BulletLogin extends JFrame implements ActionListener {
	
	private Dimension d;
	private JButton jbtn,jbtn1,jbtn2;
	private JTextField jtf;
	
	private ImageIcon icon = new ImageIcon("C:\\Users\\user\\Desktop\\봉봉 프로젝트\\개인프로젝트(게임,종합)\\총알피하기\\bullet 자료\\연습용 배경화면\\15.jpg");
	private JPanel jpal;
	
	
	
	
	public JTextField getJtf() {
		
		return jtf;
	}




	public void setJtf(JTextField jtf) {
		this.jtf = jtf;
	}



 
	public JButton getJbtn() {
		return jbtn;
	}




	public void setJbtn(JButton jbtn) {
		this.jbtn = jbtn;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jbtn) {
			new Bullet1();
			
			this.setVisible(false);
		}else if(e.getSource()==jbtn1) {
			System.exit(0);
		}else if(e.getSource()==jbtn2) {
			 
			this.setVisible(false);
		}
		
	}




	public void initLay() {
		
		
		jbtn=new JButton("START");
		jbtn.addActionListener(this);
		jbtn1=new JButton("EXIT");
		jbtn1.addActionListener(this);
	
		jpal=new JPanel() {

			@Override 
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				g.drawImage(icon.getImage(), 0,0,300,380, this);
			}
			
		};
		jpal.setLayout(null);
		
		jbtn.setFocusPainted(false);
		jbtn.setBackground(new Color(10,139,251)); 
		jbtn.setForeground(new Color(30,251,229));
		jbtn1.setBackground(new Color(10,139,251)); 
		 jbtn1.setForeground(new Color(30,251,229));
		 jbtn.setFont(new Font("", Font.BOLD,20));
		 jbtn1.setFont(new Font("", Font.BOLD,20));
		this.add(jbtn);
		this.add(jbtn1);	
		
		jbtn.setBounds(97,305 , 105,35);
			
		jbtn1.setBounds(97,340,105,35);
		
		this.setResizable(false);
		this.setUndecorated(true);
		this.add(jpal);
		
	}
	
	
	
	
	public BulletLogin() {
		initLay();
		
		d=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100, 300,380);
		this.setVisible(true);
		this.setLocation(((d.width-this.getWidth())/2),(int)((d.getHeight()-this.getHeight())/2));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("봉봉이의 총알게임");
	}
	
	
	
	public static void main(String[] args) {
		new BulletLogin();
	
	}
	
	
	
}



