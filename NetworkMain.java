package kr.hs.dgsw.URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkMain {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://google.com");
			System.out.println("Host : " + url.getHost());
			System.out.println("Protocol : " + url.getProtocol());
			System.out.println("Port : " + url.getPort());
			System.out.println("FileName : " + url.getFile());
			System.out.println("Path : " + url.getPath());
			
			
			InputStream input = url.openStream();
			InputStreamReader inReader = new InputStreamReader(input);
			BufferedReader in = new BufferedReader(inReader);
			
			String line = "";
			// 한라인씩 읽어서 저장.
			while( (line = in.readLine()) != null) {
				System.out.println("data : " + line);
			}
			in.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
