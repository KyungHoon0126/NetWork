package kr.hs.dgsw.thread;

// �̹� �ٸ� Ŭ������ ��ӹ޾��� �� Thread ����

public class MyRunnable extends Object implements Runnable {

	/**
	 * �������̽� ����� �޾��� ��� �ݵ�� �������̽��� ���Ե� �޼��带
	 * �����ؾ� �Ѵ�.
	 */
	@Override
	public void run() {
		// �������̽��� extends Thread�ʹ� �ٸ��� ������ �κ��� �����Ƿ�
		// super.run()�� ����.
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("MyRunnable run");
	}
	
}
