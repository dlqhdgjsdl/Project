package sist.com.thread.syn;

import java.util.List;
import java.util.Vector;

public class Shose {
	
	private List<String>list;
	
	
	public  Shose() {
		list=new Vector<String>();
	}
	
	public String ShoseMake() {
		String ShoseName=null;
		switch ((int)(Math.random()*3)) {
		case 0:
			ShoseName="�Ƶ�ٽ�";
			break;
		case 1:
			ShoseName="����Ű";
			break;
		case 2:
			ShoseName="����";
			break;
		default:
			break;
		}//sw��
		return ShoseName;
	}
	public synchronized void push(String ShoseName) {//����ȭ ���� �ذ��� ���� synchronized�� ����Ͽ� �� ��ü���� �ѹ����� �����尡 �Ҵ�ǰ� �Ѵ�.
		list.add(ShoseName);
		System.out.println("�Ź� ��� �Ϸ� �Ź��̸���"+ShoseName);
		if(list.size()==4)
		this.notify();//�ѹ��� �Ҵ� ���� �����带 �ٽ� runnable�� �����ش�.
	}

	public synchronized void pop() {
		if(list.size()==0) {
			try {//list.size �迭���� 0 �϶� ����� ������ ������ Ư���� ��� 0�϶��� ���ư��� ������ this.wait�� ���־  �� �����带 �����־���Ѵ�.
				System.out.println("�Ź� ��� �����ϴ�.");
				this.wait();
				
			} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
			
		}else {
			String ShoseName=list.remove(list.size()-1);
			System.out.println(ShoseName+"��۵Ǿ����ϴ�.");
			System.out.println("���� ����==="+list.size()+"��");
			
		
		}
		
	}
	
}
