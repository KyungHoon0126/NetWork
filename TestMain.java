package kr.hs.dgsw.thread;

public class TestMain {

	public static void main(String[] args) {
		
		MyThread thread = new MyThread();
		
		thread.start(); // run()�� �ٸ��� start() : ���� ������ �ٲ�, ������ ������� ����
		
		MyRunnable thread2 = new MyRunnable();
		// Thread �����ڿ����� Runnable�� ��ӹ޴� ���� ���� �� �ִ�.
		// �� Runnable �� ��ӹ޴� thread2�� start()�� �����Ƿ� Thread�� �־ start() ���
		Thread thread3 = new Thread(thread2);
		thread3.start();
		
		System.out.println("main Thread exit");
	}

}
