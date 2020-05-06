package kr.hs.dgsw.URL;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionMain {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://google.com");
            URLConnection urlCon = url.openConnection();
            InputStream input = urlCon.getInputStream();
            
            /* urlCon.getOutputStream();
            urlCon.getDoOutput(); */
            
            InputStreamReader inReader = new InputStreamReader(input);
            BufferedReader in = new BufferedReader(inReader);

            while (in.readLine() != null) {
                System.out.println(in.readLine());
            }

        } catch (MalformedURLException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}