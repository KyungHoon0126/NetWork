package kr.hs.dgsw.thread;

public class TestMain {

	public static void main(String[] args) {
		
		MyThread thread = new MyThread();
		
		thread.start(); // run()과 다르게 start() : 실행 순서가 바뀜, 별도의 쓰레드로 동작
		
		MyRunnable thread2 = new MyRunnable();
		// Thread 생성자에서는 Runnable을 상속받는 것을 넣을 수 있다.
		// 즉 Runnable 을 상속받는 thread2는 start()가 없으므로 Thread에 넣어서 start() 사용
		Thread thread3 = new Thread(thread2);
		thread3.start();
		
		System.out.println("main Thread exit");
	}

}
