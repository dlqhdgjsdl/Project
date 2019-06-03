package sist.com.newproject;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ShoseLoginAddr extends JDialog implements ActionListener{//이 아이만 꺼짐 이 아이만 만질수 있음
	private JButton jbtn,jbtn1;
	private JTable jta;
	private JTextField jtf,jtf1;
	private JPanel jpal,jpal1;
	private JLabel jla,jla1;
	private JOptionPane jop;
	private ShoseLoginByer sb;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("검색")) {
			if(jtf.getText().trim().length()==0){
				JOptionPane.showMessageDialog(this,"존재하지 않는 동입니다. 다시 입력해주세요");
				return;
			}else
			ShoseDao.selectZip(jtf.getText().trim(),jta);
		}
		if(e.getActionCommand().equals("확인")) {
			if(jtf1.getText().trim().length()==0) {
				jop.showMessageDialog(this,"공백입니다. 다시 입력해주세요");
				return;
			}else {
				int row = jta.getSelectedRow();
			ShoseLoginBean sbean=(ShoseDao.selectBean(ShoseDao.getSbean(row)));
			sb.getJtf()[2].setText(sbean.getSido()+sbean.getGugun()+sbean.getDong()+jtf1.getText());
			ShoseLoginAddr.this.dispose();
			}
		}
	}
	public void layout1() {
		this.setLayout(new BorderLayout());
		
		jpal  = new JPanel();
		jpal1 = new JPanel();
		
		jpal.add(jla=new JLabel("동을 입력해 주세요"));
		jpal.add(jtf=new JTextField(20));
		jpal.add(jbtn=new JButton("검색"));
		jbtn.addActionListener(this);
		
		jpal1.add(jla1=new JLabel("상세주소를 입력해주세요"));
		jpal1.add(jtf1=new JTextField(20));
		jpal1.add(jbtn1=new JButton("확인"));
		jbtn1.addActionListener(this);
		
		
		this.add("North",jpal);
		this.add(new JScrollPane(jta=new JTable(),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
		/*jta.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if() {
					int row = jta.getSelectedRow();
					ShoseLoginBean sbean=(ShoseLoginDao.selectBean(ShoseLoginDao.getSbean(row)));
					sb.getJtf()[2].setText(sbean.getSido()+sbean.getGugun()+sbean.getDong()+jtf1.getText());
					ShoseAddr.this.dispose();
				}
			}
			
			
		});*/
		this.add("South",jpal1);
	}
	public ShoseLoginAddr(ShoseLoginByer sb) {
		this.sb=sb;
		layout1();
		//this.setModal(true);
		this.setBounds(200,200, 500,300);
		this.setVisible(true);
	}
	
	
	/*public static void main(String[] args) {
		new ShoseAddr();
	}*/
}
