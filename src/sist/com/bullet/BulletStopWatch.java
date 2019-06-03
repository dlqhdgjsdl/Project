package sist.com.bullet;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public  class BulletStopWatch extends JFrame implements ActionListener{
	private JLabel jlb;
	private Timer timer;
	private JButton jbtn;
	private Date StartDate,endDate;
	private SimpleDateFormat dateFormat;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==timer) {
			Date newdate = new Date();
			newdate.setTime(newdate.getTime()- StartDate.getTime()+endDate.getTime());
			jlb.setText(dateFormat.format(newdate));
		}
		
		
		else if(e.getSource()==jbtn) {
			StartDate = new Date();
			try {
				endDate = dateFormat.parse(jlb.getText());
			} catch (Exception e2) {
				// TODO: handle exception
			}
			timer.start();
		}
		
	
	
	}


	public BulletStopWatch() {
		jlb=new JLabel("00:00:00.000");
		jlb.setHorizontalAlignment(SwingConstants.CENTER);
		jbtn=new JButton("Ω√¿€");
		jbtn.addActionListener(this);
		timer = new Timer(10,this);
		dateFormat=new SimpleDateFormat("HH:mm:ss.SSS");
		
		
		
		

		
		this.add(jlb, BorderLayout.NORTH);
		this.add(jbtn,BorderLayout.SOUTH);
		this.setBounds(100, 100, 500, 500);	
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	
	public static void main(String[] args) {
		new BulletStopWatch();
	}
	
	
	
}