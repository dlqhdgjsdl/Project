package sist.com.newproject;

import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ShoseChtServer {
	private static final int PORT=5000;
	private Socket socket;
	private ArrayList<ShoseChtServerThread>collection;
	
	
	
	
	public ArrayList<ShoseChtServerThread> getCollection() {
		return collection;
	}
	public void setCollection(ArrayList<ShoseChtServerThread> collection) {
		this.collection = collection;
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	public ShoseChtServer() {
		ServerSocket serverSocket=null;
		boolean isStop=false;
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("server is ready");
			collection=new ArrayList<ShoseChtServerThread>();
			while(!isStop) {
				socket = serverSocket.accept();
				ShoseChtServerThread cvt=new ShoseChtServerThread(this);
				collection.add(cvt);
				cvt.start();
				System.out.println("접속자:"+collection.size()+"명");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(serverSocket!=null || !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		new ShoseChtServer();
		
	}
}
