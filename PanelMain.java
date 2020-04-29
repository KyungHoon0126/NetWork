package kr.hs.dgsw.thread;

import javax.swing.JOptionPane;

public class PanelMain {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Input number");
		System.out.println("Input :  " + input);
		
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("system out");
	}
}
