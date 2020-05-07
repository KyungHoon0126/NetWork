package kr.hs.dgsw.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketMain {

	public static void main(String[] args) {
		
		System.out.println("start server");
		
		try
		{
			ServerSocket serverSocket = new ServerSocket(6000);
			System.out.println("waiting connect");
			Socket socket = serverSocket.accept();
			System.out.println("connected client");
			OutputStream oStream = socket.getOutputStream();
			
			InputStream iStream = socket.getInputStream();
			
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
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
