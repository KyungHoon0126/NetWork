package kr.hs.dgsw.multiserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadTcpServerMain extends Thread {

	private Socket clientSocket;
	public ThreadTcpServerMain(Socket s)
	{
		this.clientSocket = s;
	}
	
	public static void main(String[] args) {

		System.out.println("Main Server Moudle Start");
		try 
		{
			ServerSocket serverSocket = new ServerSocket(6000);
			while(true) 
			{
				// ���� �������̴� 6000������ ������ �˷���.
				Socket socket = serverSocket.accept();
				ThreadTcpServerMain thread = new ThreadTcpServerMain(socket);
				thread.start();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run() {		
		try {
			System.out.println("Thread start : " + Thread.currentThread());
			OutputStream oStream = clientSocket.getOutputStream();
			
			InputStream iStream = clientSocket.getInputStream();
			
			// Server���� �������� ������
			BufferedReader in = new BufferedReader(new InputStreamReader(iStream));
			
			// Client���� �޴� ������
			PrintWriter out = new PrintWriter(oStream, true);
			
			String inputData = "";
			System.out.println("rev wating ");
			while((inputData = in.readLine()) != null) {
				System.out.println("server Rev data");
				out.println(inputData);
			}
			
			System.out.println("server end");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
