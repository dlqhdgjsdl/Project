package sist.com.newproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ShoseInfo extends JFrame implements ActionListener {

	private ImageIcon ss;

	private JPanel jpal;
	private JLabel jlb, jlb1, jlb2, jlb3, jlb4, jlb5 , jlb6;//jlb=사진이미지,jlb1=색상라벨,jlb2=사이즈라벨.jlb3=수량라벨,jlb4=가격라벨,jlb5=가격,jlb6=신발이름;
	private JComboBox<String> jcb, jcb1, jcb2;
	private ImageIcon icon = new ImageIcon("C:\\Users\\user\\Desktop\\봉봉 프로젝트\\자바(개인 crud) 프로젝트\\신발이미지\\main.jpg");
	private String s[] = { "---색상선택---","화이트", "그레이", "블랙" };
	private String s1[] = { "---사이즈선택---","230", "235", "240", "245", "250", "255", "260", "265", "270", "275", "280" };
	private String s2[] = { "---수량선택---","1", "2", "3", "4", "5" };
	private JButton jbtn,jbtn1,jbtn2;
	private JOptionPane jop;
	
	public void initlay() {
		// this.setLayout(null);
		JPanel jPanel = new JPanel(null);
		this.add(jPanel);
		jpal = new JPanel();
		jpal.add(jlb = new JLabel(ss));
		jpal.setBounds(60, 70, 260, 260);
		jpal.setOpaque(true);

		
		jlb1 = new JLabel("색상");
		jlb1.setFont(new Font("휴먼매직체", Font.BOLD, 30));
		jlb1.setOpaque(true);
		jlb1.setBackground(Color.orange);
		jlb1.setBounds(410, 150, 60, 40);
		jlb2 = new JLabel("사이즈");
		jlb2.setFont(new Font("휴먼매직체", Font.BOLD, 30));
		jlb2.setOpaque(true);
		jlb2.setBackground(Color.orange);
		jlb2.setBounds(410, 220, 80, 40);
		jlb3 = new JLabel("수량");
		jlb3.setFont(new Font("휴먼매직체", Font.BOLD, 30));
		jlb3.setOpaque(true);
		jlb3.setBackground(Color.orange);
		jlb3.setBounds(410, 290, 60, 40);
		jlb4 = new JLabel("가격");
		jlb4.setOpaque(true);
		jlb4.setFont(new Font("휴먼매직체", Font.BOLD, 30));
		jlb4.setBackground(Color.orange);
		jlb4.setBounds(340, 80, 100, 40);
		jlb5 = new JLabel();
		jlb5.setFont(new Font("휴먼매직체", Font.BOLD, 30));
		jlb5.setOpaque(true);
		jlb5.setBackground(Color.orange);
		jlb5.setBounds(450, 80, 200, 40);
		jlb6=new JLabel();
		jlb6.setOpaque(true);
		jlb6.setBounds(60, 350,350, 70);
		jlb6.setFont(new Font("휴먼매직체",Font.BOLD,45));
		jlb6.setOpaque(true);
		jlb6.setBackground(Color.orange);
		
		
		jcb = new JComboBox<String>(s);
		jcb.setBounds(530, 150, 120, 40);
		jcb.setFont(new Font("휴먼매직체",Font.BOLD,15));
		jcb1 = new JComboBox<String>(s1);
		jcb1.setBounds(530, 220, 120, 40);
		jcb1.setFont(new Font("휴먼매직체",Font.BOLD,15));
		jcb2 = new JComboBox<String>(s2);
		jcb2.setBounds(530, 290, 120, 40);
		jcb2.setFont(new Font("휴먼매직체",Font.BOLD,15));
		
		
		jbtn=new JButton("구매");
		jbtn.addActionListener(this);
		jbtn.setBounds(200,500,100,50);
		jbtn1=new JButton("취소");
		jbtn1.addActionListener(this);
		jbtn1.setBounds(300, 500,100, 50);
		jbtn2=new JButton("1:1문의");
		jbtn.addActionListener(this);
		jbtn2.setBounds(400,500,100,50);
		jPanel.setBackground(Color.gray);
		jPanel.add(jpal);
		jPanel.add(jlb1);
		jPanel.add(jlb2);
		jPanel.add(jlb3);
		jPanel.add(jcb);
		jPanel.add(jcb1);
		jPanel.add(jcb2);
		jPanel.add(jlb4);
		jPanel.add(jlb5);
		jPanel.add(jlb6);
		jPanel.add(jbtn);
		jPanel.add(jbtn1);
		jPanel.add(jbtn2);
		dispose();

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("취소")) {
			dispose();
		}
		if(e.getActionCommand().equals("구매")) {
			jop.showMessageDialog(this,"구매 되셨습니다 .");
			dispose();
		}
		if(e.getActionCommand().equals("1:1문의")) {
			System.out.println("네트워크 연결전");
		}
	}


	public ShoseInfo(ImageIcon ss,String sss) {
		this.ss = ss;	
		initlay();
		jlb6.setText(sss.split("#")[0]);
		jlb5.setText(sss.split("#")[1]);
		this.setBounds(400, 100, 700,600);
		this.setVisible(true);

	}
}
