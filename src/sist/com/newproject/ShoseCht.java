package sist.com.newproject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ShoseCht extends Frame  implements TextListener,ActionListener{	
	private JPanel jp1,jp2;
	private TextField tf;
	private JButton jbtn1,jbtn2;
	private JTextArea jTextArea;	
	private ImageIcon icon = new ImageIcon("C:\\Users\\sist-216\\Desktop\\연습용 배경\\7.jpg");
	private JLabel jlbIp,jlbNickName;
	private Dimension d;
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private static final int PORT=5000;
	private String ip,nickname;
	
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public JTextArea getjTextArea() {
		return jTextArea;
	}
	public void setjTextArea(JTextArea jTextArea) {
		this.jTextArea = jTextArea;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public ObjectInputStream getOis() {
		return ois;
	}
	public void setOis(ObjectInputStream ois) {
		this.ois = ois;
	}
	public ObjectOutputStream getOos() {
		return oos;
	}
	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}
	//private int width=770,height=540;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String msg=tf.getText();
		if(e.getSource()==tf|| e.getSource()==jbtn1) {
		if(msg==null||msg.equals("")) {
			JOptionPane.showMessageDialog(this, "내용이 없습니다.");
			return;
		}
		try {
			oos.writeObject(ShoseCht.this.nickname+"#"+msg);
			
			jTextArea.setCaretPosition(jTextArea.getDocument().getLength());
			
			tf.setText("");
			tf.requestFocus();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		}
		
	}
	@Override
	public void textValueChanged(TextEvent e) {
		// TODO Auto-generated method stub
		if(tf.getText().length()>0) {
			jbtn1.setEnabled(true);
		}else {
			jbtn1.setEnabled(false);
		}
	}
	public void initLayEx(String ip,String nickName) {
		jp1=new JPanel();
		
		jp1.add(tf=new TextField(50));
		tf.addActionListener(this);
		jp1.add(jbtn1=new JButton("전송"));
		jbtn1.addActionListener(this);
		tf.addTextListener(this);
		jp1.add(jbtn2=new JButton("끝내기"));
		jbtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			try {
				oos.writeObject(ShoseCht.this.nickname+"#"+"exit");
			} catch (Exception e2) {
				// TODO: handle exception
			}
				System.exit(0);	
			}
		});
		
		this.add(new JScrollPane(jTextArea=new JTextArea() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				//System.out.println(jTextArea.getDocument().getLength());				
				g.drawImage(icon.getImage(),0,0,jTextArea.getWidth(),jTextArea.getHeight(), null);				
				super.paintComponent(g);
			}
			
			
		},JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		jTextArea.setOpaque(false);
		jTextArea.setForeground(Color.white);
		jTextArea.setFont(new Font(getTitle(),Font.BOLD,20));
		jTextArea.setEditable(false);
		this.add("South",jp1);
		jp2=new JPanel(new BorderLayout());
		jp2.add("East",jlbIp=new JLabel("IP"+ip+"]"));
		jp2.add("West",jlbNickName=new JLabel("Nick["+nickName+"]"));
		this.add("North",jp2);
	}                                                                             
	public ShoseCht(String ip , String nickName) {
		this.nickname=nickName;
		initLayEx(ip,nickName);
		this.addWindowListener(new WindowAdapter() {			

			@Override
			public void windowOpened(WindowEvent e) {
			tf.requestFocus();
			}
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				try {
					oos.writeObject(ShoseCht.this.nickname+"#"+"exit");
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				System.exit(0);
			}

		});

		this.setBounds(100, 100,580, 700);
		
		this.setVisible(true);
		this.setTitle("채팅창 BOOM");
		 d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((d.width-this.getWidth())/2,(d.height-this.getHeight())/2);
		connect();
	}
	
	public void connect() {
		try {
			socket=new Socket(ip,PORT);
			oos=new ObjectOutputStream(socket.getOutputStream());
			ois=new ObjectInputStream(socket.getInputStream());
			ShoseChtThread sc = new ShoseChtThread(this);
			sc.start();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		new ShoseCht("211.63.89.102","bongbong");
	}

}
