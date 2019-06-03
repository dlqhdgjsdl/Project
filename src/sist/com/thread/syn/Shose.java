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
			ShoseName="아디다스";
			break;
		case 1:
			ShoseName="나이키";
			break;
		case 2:
			ShoseName="리복";
			break;
		default:
			break;
		}//sw문
		return ShoseName;
	}
	public synchronized void push(String ShoseName) {//동기화 문제 해결을 위해 synchronized를 사용하여 각 객체에서 한번씩만 쓰레드가 할당되게 한다.
		list.add(ShoseName);
		System.out.println("신발 출고 완료 신발이름은"+ShoseName);
		if(list.size()==4)
		this.notify();//한번씩 할당 받은 쓰레드를 다시 runnable로 보내준다.
	}

	public synchronized void pop() {
		if(list.size()==0) {
			try {//list.size 배열값이 0 일때 멈춰야 하지만 쓰레드 특성상 계속 0일때도 돌아가기 때문에 this.wait를 써주어서  그 쓰레드를 멈춰주어야한다.
				System.out.println("신발 재고가 없습니다.");
				this.wait();
				
			} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
			
		}else {
			String ShoseName=list.remove(list.size()-1);
			System.out.println(ShoseName+"배송되었습니다.");
			System.out.println("남은 개수==="+list.size()+"개");
			
		
		}
		
	}
	
}
