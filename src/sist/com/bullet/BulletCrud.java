package sist.com.bullet;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import sist.com.ui.crud.MemberUser;

public class BulletCrud extends JFrame implements ActionListener{
	private JTable jTable;
	private String[]lbAraay= {"순위","플레이어","버틴 시간"};
	private JButton jbtn,jbtn2;
	private JLabel []lb = new JLabel[lbAraay.length];
	private BulletCrudTable bcrudtable;
	private BulletHero bh;
	private  Vector<BulletMember> vector=new Vector<BulletMember>();//객체를 안만들어주면 불러올 때 백터 크기가 없어서 에러가 나올 수 있따.
	private int pk;
	private Bullet1 t;
	BulletMember member= new BulletMember();
	private static final String PATH="C:\\Users\\user\\Desktop\\봉봉 프로젝트\\개인프로젝트(게임,종합)\\총알피하기\\bullet 자료\\연습용 배경화면\\list.dat";
	
	
	
	public void addmemberlist(BulletMember member) {
		vector.add(member);// bylletmember class에서 동기화를 해줘야지 파일을내보낼수 있다.(Serializable)
		ObjectOutputStream oos=null;
		try {
			oos=new ObjectOutputStream(new FileOutputStream(new File(PATH)));
			oos.writeObject(vector);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		listMemberUser();
	}
	
	public void listMemberUser() {
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(new FileInputStream(new File(PATH)));
			
			vector=(Vector<BulletMember>)ois.readObject();
			vector=vector==null?vector=new Vector<BulletMember>():vector;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				new File(PATH).createNewFile();				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		//return vector;
		setActionTable(vector);
	}	
	public void oisex() {
		ObjectInputStream ois=null;//매서드 새로 만들어서 푸쉬멤버 실행되기 전에 받기 먼저 되도록할 것
		try {
			ois=new ObjectInputStream(new FileInputStream(new File(PATH)));
			
			vector=(Vector<BulletMember>)ois.readObject();
			vector=vector==null?vector=new Vector<BulletMember>():vector;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				new File(PATH).createNewFile();				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public void pushMember() {//j테이블에 들어갈 값을 설정해준다.
		//System.out.println("pK:"+vector.get(vector.size()-1).getPk());
		//System.out.println(bh.getS());
		
		oisex();
		
		member.setPk(vector.size()>=1?vector.get(vector.size()-1).getPk()+1:1);//순서에 맞게 끔 나올수 있도록해줌
		member.setId(bh.getS());
		member.setTime(bh.getJ());
		//setActionTable();
		
		addmemberlist(member);
	}
	
	
	public void setActionTable(Vector<BulletMember> vector) {//j테이블에 값을 넣어준다.
		Object[][]data=new Object[vector.size()][bcrudtable.getColumnCount()];
		for(int i =0;i<data.length;i++) {
			for (int  j= 0; j < data[i].length;) {
				BulletMember bm=vector.get(i);
				data[i][j++]=bm.getPk();
				data[i][j++]=bm.getId();
				data[i][j++]=bm.getTime();
				
				
				
			}
		}
		jTable.setModel(bcrudtable=new BulletCrudTable(data));//j테이블 만들어준다.
	}
	
	public void initLay() {
	
		
		
		
		
		for (int i = 0; i < lb.length; i++) {
			lb[i]=new JLabel(lbAraay[i]);
			
		}
		jbtn=new JButton("확인");
		jbtn.addActionListener(this);
		//jbtn2=new JButton("검색");
		//jbtn2.addActionListener(this);
		jbtn.setBounds(210, 420,80,30);
		///jbtn2.setBounds(240,420,80,30);
		
		this.add(jbtn);
		//this.add(jbtn2);
		this.add(new JScrollPane(jTable=new JTable(bcrudtable=new BulletCrudTable(new Object[0][0]))));
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource()==jbtn) {
			System.exit(0);
		
		}/*else if(e.getSource()==jbtn2){
			
		}*/
	}

	public BulletCrud(BulletHero bh,Bullet1 t) {
		
		initLay();
		this.t=t;
		this.bh=bh;//생성자를 생성하여 bh 값을 가져와서 bc에 뿌려준다.
		this.setTitle("점수기록");
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/*public static void main(String[] args) {
		new BulletCrud();
	}*/
	
}



