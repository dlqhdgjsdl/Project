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
	private String[]lbAraay= {"����","�÷��̾�","��ƾ �ð�"};
	private JButton jbtn,jbtn2;
	private JLabel []lb = new JLabel[lbAraay.length];
	private BulletCrudTable bcrudtable;
	private BulletHero bh;
	private  Vector<BulletMember> vector=new Vector<BulletMember>();//��ü�� �ȸ�����ָ� �ҷ��� �� ���� ũ�Ⱑ ��� ������ ���� �� �ֵ�.
	private int pk;
	private Bullet1 t;
	BulletMember member= new BulletMember();
	private static final String PATH="C:\\Users\\user\\Desktop\\���� ������Ʈ\\����������Ʈ(����,����)\\�Ѿ����ϱ�\\bullet �ڷ�\\������ ���ȭ��\\list.dat";
	
	
	
	public void addmemberlist(BulletMember member) {
		vector.add(member);// bylletmember class���� ����ȭ�� ������� �������������� �ִ�.(Serializable)
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
		ObjectInputStream ois=null;//�ż��� ���� ���� Ǫ����� ����Ǳ� ���� �ޱ� ���� �ǵ����� ��
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
	public void pushMember() {//j���̺� �� ���� �������ش�.
		//System.out.println("pK:"+vector.get(vector.size()-1).getPk());
		//System.out.println(bh.getS());
		
		oisex();
		
		member.setPk(vector.size()>=1?vector.get(vector.size()-1).getPk()+1:1);//������ �°� �� ���ü� �ֵ�������
		member.setId(bh.getS());
		member.setTime(bh.getJ());
		//setActionTable();
		
		addmemberlist(member);
	}
	
	
	public void setActionTable(Vector<BulletMember> vector) {//j���̺� ���� �־��ش�.
		Object[][]data=new Object[vector.size()][bcrudtable.getColumnCount()];
		for(int i =0;i<data.length;i++) {
			for (int  j= 0; j < data[i].length;) {
				BulletMember bm=vector.get(i);
				data[i][j++]=bm.getPk();
				data[i][j++]=bm.getId();
				data[i][j++]=bm.getTime();
				
				
				
			}
		}
		jTable.setModel(bcrudtable=new BulletCrudTable(data));//j���̺� ������ش�.
	}
	
	public void initLay() {
	
		
		
		
		
		for (int i = 0; i < lb.length; i++) {
			lb[i]=new JLabel(lbAraay[i]);
			
		}
		jbtn=new JButton("Ȯ��");
		jbtn.addActionListener(this);
		//jbtn2=new JButton("�˻�");
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
		this.bh=bh;//�����ڸ� �����Ͽ� bh ���� �����ͼ� bc�� �ѷ��ش�.
		this.setTitle("�������");
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/*public static void main(String[] args) {
		new BulletCrud();
	}*/
	
}



