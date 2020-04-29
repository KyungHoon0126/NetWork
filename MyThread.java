package kr.hs.dgsw.thread;

public class MyThread extends Thread {

	public void printTest() {
		System.out.println("MyThread print");
	}

	@Override
	public void run() {
//		try {
//			sleep(500);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("MyThread run");
	}

}
