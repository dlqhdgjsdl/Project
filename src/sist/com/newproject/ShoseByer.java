package sist.com.newproject;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShoseByer extends JFrame implements ActionListener{
		
	private JTextField []jtf = new JTextField[4];
	private String []lbArray= {"아이디           ","비밀번호        ","비밀번호확인","별명              "};
	private String []jbtnLabel= {"회원가입","끝내기"};
	private JLabel []lb=new JLabel[jtf.length];
	private JButton []jbtn = new JButton[jbtnLabel.length];
	private static int JPCNT=7;
	private JPanel [] jpan = new JPanel[JPCNT];
	private JButton jbt;
	private JPanel jpan1;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("끝내기")) {
			dispose();
		}
		if(e.getActionCommand().equals("아이디 중복검사")) {
			System.out.println("데이터베이스 연결전");
		}
	}

	public void LayOut() {
		
		for (int i = 0; i < JPCNT; i++) {
			switch (i) {
			case 0:
				jpan[i]=new JPanel(new GridLayout(5,1));
				break;
			case 1:
			case 2:
				jpan[i] = new JPanel();
			default:
				jpan[i]=new JPanel();
				break;
			}
		}
		
		for (int i = 0; i < jbtn.length; i++) {
			jbtn[i]=new JButton(jbtnLabel[i]);
			jpan[JPCNT-1].add(jbtn[i]);
			jbtn[i].addActionListener(this);
		}
		
		for (int i = 0; i < jtf.length; i++) {
			jtf[i]=new JTextField(15);
			lb[i]=new JLabel(lbArray[i]);
			jpan[i+1].add(lb[i]);
			jpan[i+1].add(jtf[i]);
			jpan[0].add(jpan[i+1]);
		}
		jpan1 = new JPanel();
		jpan1.add(jbt=new JButton("아이디 중복검사"));
		jbt.addActionListener(this);
		this.add(jpan1);
		
		this.add("West",jpan[0]);
		this.add("South",jpan[JPCNT-1]);
	}
	
	public ShoseByer() {
		LayOut();
		this.setBounds(100, 100, 450, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		new ShoseByer();	
		}
}
