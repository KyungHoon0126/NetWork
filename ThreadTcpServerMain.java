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
				// 현재 대기상태이니 6000번으로 들어오면 알려줘.
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
			
			// Server에서 내보내는 데이터
			BufferedReader in = new BufferedReader(new InputStreamReader(iStream));
			
			// Client에서 받는 데이터
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
