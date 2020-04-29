package kr.hs.dgsw.thread;

// 이미 다른 클래스를 상속받았을 때 Thread 사용법

public class MyRunnable extends Object implements Runnable {

	/**
	 * 인터페이스 상속을 받았을 경우 반드시 인터페이스에 포함된 메서드를
	 * 구현해야 한다.
	 */
	@Override
	public void run() {
		// 인터페이스는 extends Thread와는 다르게 구현된 부분이 없으므로
		// super.run()이 없다.
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("MyRunnable run");
	}
	
}
