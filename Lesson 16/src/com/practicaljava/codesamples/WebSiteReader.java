package com.practicaljava.codesamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class WebSiteReader {

	public static void main(String[] args) {
		
		String nextLine;
		URL url = null;
		URLConnection urlConn = null;
		
		try {
			url = new URL("http://www.google.com");
			urlConn = url.openConnection();
		} catch(IOException ioe) {
			System.out.println("Can't connect to the provided url: "+ ioe.toString());
		}
		
		try(InputStreamReader inStream = new InputStreamReader(
				urlConn.getInputStream(), StandardCharsets.UTF_8);
				BufferedReader buff = new BufferedReader(inStream);) {
			
			//Read and print the content of the Google's front page
			while (true) {
				nextLine = buff.readLine();
				if (nextLine != null) {
					System.out.println(nextLine);
				}
				else {
					break;
				}
			}
			
		} catch (IOException ioe) {
			System.out.println("Can't read from the internet: " + ioe.toString());
		}

	}

}
