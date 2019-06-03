package sist.com.newproject;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ShoseManager extends JFrame implements ActionListener{
	private static int jpcnt = 7;
	private String [] function = {"입력","수정","삭제"};
	private JTable jtable1 ;
	private String [] putin= {"신발명","사이즈","가격","수량    ","색상    ","사번호"};
	private JTextField []tf=new JTextField[6];
	private JLabel []lb = new JLabel[tf.length];
	private JPanel [] jpan = new JPanel[jpcnt];
	private int number;
	private ShoseManagerCrudTableModel sct;
	
	private JPanel jpal,jpal2,jpal3;
	private JButton jbtn,jbtn1,jbtn2;
	private JScrollPane jsp;
	private ImageIcon icon=new ImageIcon("C:\\Users\\user\\Desktop\\봉봉 프로젝트\\자바(개인 crud) 프로젝트\\신발이미지\\main.jpg");
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("입력")) {
			
			createShoseManagerList();
			
			setJTable();
			
			for (int i = 0; i < tf.length; i++) {
				tf[i].setText("");
			}
		}
		if(e.getActionCommand().equals("수정")) {
			int row=jtable1.getSelectedRow();
			ShoseDao.updateMember(tf[0].getText(), tf[1].getText(), tf[2].getText(), tf[3].getText(), tf[4].getText(),
					tf[5].getText(), (Integer)jtable1.getValueAt(row, 0));
			setJTable();
	}
	if(e.getActionCommand().equals("삭제")) {
		int row=jtable1.getSelectedRow();
		
		ShoseDao.deleteMember((Integer)jtable1.getValueAt(row, 0));
		setJTable();
	}
	}
	
	public void createShoseManagerList() {
		ShoseManagerMemberBean smb = new ShoseManagerMemberBean();
		smb.setShosename(tf[0].getText());
		smb.setSize(tf[1].getText());
		smb.setprice(tf[2].getText());
		smb.setCount(tf[3].getText());
		smb.setColor(tf[4].getText());
		smb.setNum(tf[5].getText());
		ShoseDao.createManagerList(smb);
	}
	public void setJTable() {
		Object[][]data1=new Object[ShoseDao.ShowManagerList().size()][sct.getColumnCount()];
		
		for (int i = 0; i < data1.length; i++) {
			for (int j = 0; j < data1[i].length;) {
				ShoseManagerMemberBean smb = ShoseDao.ShowManagerList().get(i);
				data1[i][j++]=smb.getNumber();
				data1[i][j++]=smb.getShosename();
				data1[i][j++]=smb.getSize();
				data1[i][j++]=smb.getprice();
				data1[i][j++]=smb.getCount();
				data1[i][j++]=smb.getColor();
				data1[i][j++]=smb.getNum();
						
				
			}
		}
		jtable1.setModel(sct=new ShoseManagerCrudTableModel(data1));
	}
	
	class Functiont1 extends JFrame {//옆에 기능
		private JButton jbtn1,jbtn2,jbtn3;
		private JPanel jpan;
		public Functiont1 () {
			
			
			
			
			jpan = new JPanel(null);
			
			jbtn1=new JButton("뒤로가기");
			jbtn2=new JButton("물어보기");
			jbtn3=new JButton("재고확인");
			
			
			jpan.add(jbtn1);
			jbtn1.setBounds(0, 90, 100,40);
			jpan.add(jbtn2);
			jbtn2.setBounds(50,30,100,40);
			jpan.add(jbtn3);
			jbtn3.setBounds(100,90,100,40);
			
			
			
			this.add(jpan);
			
			
			
			this.setUndecorated(true);
			this.setBounds(895,100,200,150);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		
			
		
		}
	}
	
	public void initLay() {
		
		this.setLayout(null);
		jpal=new JPanel();
		jpal.add(jbtn=new JButton("입력"));
		jbtn.addActionListener(this);
		jpal.add(jbtn1=new JButton("수정"));
		jbtn1.addActionListener(this);
		jpal.add(jbtn2=new JButton("삭제"));
		jbtn2.addActionListener(this);
		jpal2=new JPanel(null);
		
		for (int i = 0; i < lb.length; i++) {
			jpal2.add(lb[i]=new JLabel(putin[i]));
			lb[i].setBounds(20, i*40,50, 30);
			jpal2.add(tf[i]=new JTextField(20));
			tf[i].setBounds(75,i*40,130,30);
		}
		this.add(jsp=new JScrollPane(jtable1=new JTable(sct=new ShoseManagerCrudTableModel(new Object[0][0]))));
		jsp.setBounds(230, 0, 550,400);
		jtable1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==2) {
				int row = jtable1.getSelectedRow();
				for (int i = 0; i < tf.length; i++) {
					String imsi=(String)jtable1.getValueAt(row, i+1);
					tf[i].setText(imsi.replace(",", "").trim());
				
				}
				}
			
			}
		
		});
		
		this.add(jpal);
		jpal.setBounds(250,400,300,100);
		this.add(jpal2);
		jpal2.setBounds(0, 50,220,400);
		
		 setJTable();
	}
	
	public ShoseManager() {
		initLay();
		this.setBounds(100, 100, 800, 500);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}
	
	
	
	public static void main(String[] args) {
		
		new ShoseManager();
	}
}
