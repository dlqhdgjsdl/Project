package sist.com.newproject;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShoseLoginByer extends JFrame implements ActionListener {

	private JTextField[] jtf = new JTextField[4];
	private String[] lbArray = { "아이디           ", "비밀번호       ", "주소              ", "별명              " };
	private String[] jbtnLabel = { "회원가입", "끝내기" };
	private JLabel[] lb = new JLabel[jtf.length];
	private JButton[] jbtn = new JButton[jbtnLabel.length];
	private static int JPCNT = 7;
	private JPanel[] jpan = new JPanel[JPCNT];
	private JButton jbt, jbt1, jbt2;
	private JPanel jpan1;
	private JOptionPane jop;
	private boolean flag;
	
	
	
	public JTextField[] getJtf() {
		return jtf;
	}

	public void setJtf(JTextField[] jtf) {
		this.jtf = jtf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("끝내기")) {
			dispose();
		}
		if (e.getActionCommand().equals("회원가입")) {
			CreateShoseMember();
			dispose();
			new ShoseLogin();
		}
		if (e.getActionCommand().equals("아이디 중복검사")) {
			if (!jtf[0].getText().trim().equals("")) {
				flag = ShoseDao.idCheck(jtf[0].getText());
				if (flag == true) {
					jop.showMessageDialog(this, "이미 사용중입니다.");
					jtf[0].setText("");
					jtf[0].setFocusable(true);
				} else if (flag == false) {
					jop.showMessageDialog(this, "사용가능한 아이디 입니다.");
					jtf[1].setEditable(true);
					jtf[1].requestFocus();
				}
			} else
				jop.showMessageDialog(this, "아이디를 입력해주세요");
		}
		if (e.getActionCommand().equals("비밀번호 확인")) {
			if (!jtf[1].getText().trim().equals("")) {
				String s = jop.showInputDialog(this, "비밀번호");

				if (s.equals(jtf[1].getText())) {

					jop.showMessageDialog(this, "비밀번호 확인 완료쿠");
					jtf[2].setEditable(true);
					jtf[2].requestFocus();
				}
			} else
				jop.showMessageDialog(this, "비밀번호를 입력해주세요");
		}
		if(e.getActionCommand().equals("주소 찾기")) {
			new ShoseLoginAddr(this);
			jtf[3].setEditable(true);
			jtf[3].requestFocus();
		}
	}

	public void CreateShoseMember() {
		ShoseLoginMember loginMember = new ShoseLoginMember();
		loginMember.setId(jtf[0].getText());
		loginMember.setPassword(jtf[1].getText());
		loginMember.setAddr(jtf[2].getText());
		loginMember.setNickname(jtf[3].getText());
		ShoseDao.createShoseMember(loginMember);
	}

	public void LayOut() {

		for (int i = 0; i < JPCNT; i++) {
			switch (i) {
			case 0:
				jpan[i] = new JPanel(new GridLayout(5, 1));
				break;
			case 1:
			case 2:
				jpan[i] = new JPanel();
			default:
				jpan[i] = new JPanel();
				break;
			}
		}

		for (int i = 0; i < jbtn.length; i++) {
			jbtn[i] = new JButton(jbtnLabel[i]);
			jpan[JPCNT - 1].add(jbtn[i]);
			jbtn[i].addActionListener(this);

		}

		for (int i = 0; i < jtf.length; i++) {
			jtf[i] = new JTextField(15);
			lb[i] = new JLabel(lbArray[i]);
			jpan[i + 1].add(lb[i]);
			jpan[i + 1].add(jtf[i]);
			jpan[0].add(jpan[i + 1]);
			if (i != 0) {
				jtf[i].setEditable(false);
			}

		}
		jpan1 = new JPanel(null);
		jpan1.add(jbt = new JButton("아이디 중복검사"));
		jbt.setBounds(20, 8, 150, 21);
		jpan1.add(jbt1 = new JButton("비밀번호 확인"));
		jbt1.setBounds(20, 50, 150, 21);
		jpan1.add(jbt2 = new JButton("주소 찾기"));
		jbt2.setBounds(20, 95, 150, 21);
		jbt.addActionListener(this);
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		this.add(jpan1);

		this.add("West", jpan[0]);
		this.add("South", jpan[JPCNT - 1]);
	}

	public ShoseLoginByer() {
		LayOut();
		this.setBounds(100, 100, 450, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ShoseLoginByer();
	}
}
