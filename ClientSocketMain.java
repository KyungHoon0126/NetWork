package kr.hs.dgsw.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketMain {

	public static void main(String[] args) 
	{
		System.out.println("client start");
		try {
				//InetAddress inet = InetAddress.getByAddress(new byte[] {(byte)192,(byte)168,(byte)168,(byte)100}));
				
				InetAddress inet = InetAddress.getLocalHost();
				Socket socket = new Socket(inet, 6000);
				OutputStream oStream = socket.getOutputStream();
				InputStream iStream = socket.getInputStream();
				
				// Server에서 내보내는 데이터
				BufferedReader in = new BufferedReader(new InputStreamReader(iStream));
				
				// Client에서 받는 데이터
				PrintWriter out = new PrintWriter(oStream);
				
				Scanner sc = new Scanner(System.in);
				
				while(true) 
				{
					System.out.println("send server data input : ");
					String data = sc.nextLine();
					out.println(data);
					System.out.println("send : " + data);
					String res = in.readLine();
					System.out.println("client rev data : " + res);
				}
				
				
				// System.out.println("client end");
				
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
