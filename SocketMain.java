package kr.hs.dgsw.URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketMain {

	public static void main(String[] args) {
		
		try 
		{
			// Socket socket = new Socket("google.com", 80);
			InetAddress inet = InetAddress.getByName("google.com");
			Socket socket = new Socket(inet, 80);
			System.out.println("connected : " + socket.isConnected());
			InputStream input = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			
			while(!br.ready()) {
				
			}
			
			String line = "";
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			br.close();
			socket.close();
			
		} catch (UnknownHostException e) 
		{
			e.printStackTrace();
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

}
