package sist.com.newproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import sist.com.net.ActionServerThread;

public class ShoseServerThread extends Thread {
	private ShoseServer server;
	private String id;
	private BufferedReader br;
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private boolean initFlag = false;
	private String msg;
	
	public ShoseServerThread(ShoseServer server) {
		super();
		this.server=server;
	}
	public void broadCast(String message) {
		/*synchronized (hm) {
			Collection<Object> collection = hm.values();
			Iterator<?> iter = collection.iterator();
			while(iter.hasNext()) {
				PrintWriter pw = (PrintWriter)iter.next();
				pw.println(msg);
				pw.flush();
			}
		}*/
		
		for(ShoseServerThread t : server.getCollection()) {
			t.sendMessage(message);
		}
	}
	
	/*public chatServerThread(Socket socket, HashMap<String, Object> hm) {
		super();
		
		this.hm = hm;
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			id=br.readLine();
			broadCast(id+"���� �����ϼ̽��ϴ�.");
			System.out.println("������ ������� ���̵�:"+id);
			synchronized (hm) {
				hm.put(this.id,pw);
			}
			initFlag=true;
			
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}*/
	
	

	public void sendMessage(String message) {//�ӼӸ�
		try {
			oos.writeObject(message);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		/*int start = msg.indexOf(" ")+1;
		int end = msg.indexOf(" ",start);
		if(end != -1) {
			String to = msg.substring(start,end);
			String msg2 = msg.substring(end+1);
			Object obj = hm.get(to);
			if(obj !=null) {
				PrintWriter pw = (PrintWriter)obj;
				pw.println(id+"���� ������ �ӼӸ��� �����̽��ϴ�. : " + msg2);
				pw.flush();
			}
		}*/
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean isStop = false;
		try {
			socket = server.getSocket();
			ois=new ObjectInputStream(socket.getInputStream());
			oos=new ObjectOutputStream(socket.getOutputStream());
			
			
			
			String [] res = null;
			while(!isStop) {
				String message=(String)ois.readObject();
				res= message.split("#");
				if(res[1].equals("exit")) {
					isStop = true;
					broadCast(message);
					
				}else {
					broadCast(message);
				}
			}
			server.getCollection().remove(this);
			System.out.println(socket.getInetAddress()+ "�� ���� �����ڼ�:" + server.getCollection().size()+"��");
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace(); ���� ã���� ��� 
			server.getCollection().remove(this);
			System.out.println(socket.getInetAddress() + "�� ���� ���� ���� �����ڼ�:"+ server.getCollection().size()+"��");
		}finally {
			try {
				if(ois !=null)
					ois.close();
				if(oos !=null)
					oos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
}
