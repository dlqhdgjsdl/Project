package sist.com.newproject;

public class ShoseCatThread extends Thread{
	private ShoseService s1;
	
	public ShoseCatThread(ShoseService s1) {
		super();
		this.s1=s1;
		
	}

	@Override
	public void run() {//채팅 쓰레드  연습중
						
		
		// TODO Auto-generated method stub
		String message=null;
		String []res=null;
		boolean isStop = false;
		System.out.println("run");
		while(!isStop) {
			try {
				message=(String) s1.getOis().readObject();
				res = message.split("#");
				System.out.println(message);
				if(res[1].equals("exit")) {
				if(res[1].equals(s1.getNickname())) {
					System.exit(0);
				}else {
					s1.getjTextArea().append(res[0]+"님 종료"+System.getProperty("line.separator"));
					s1.getjTextArea().setCaretPosition(s1.getjTextArea().getDocument().getLength());
				}
				}else {
					s1.getjTextArea().append(res[0]+":"+res[1]+System.getProperty("line.separator"));
					s1.getjTextArea().setCaretPosition(s1.getjTextArea().getDocument().getLength());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
}
