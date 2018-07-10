package com.practicaljava.codesamples;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

	public static void main(String[] args) {

		//create FileInputStream 
		try (FileInputStream myFile = new FileInputStream("abc.dat")){
			
			boolean endOfFile = false;
			
			while (!endOfFile) {
				int byteValue = myFile.read();
				System.out.print(byteValue + " ");
				if (byteValue == -1)
					endOfFile = true;
			}
			
		} catch (IOException ioe){
			
			System.out.print("Could not read file: " + ioe.toString());
			
		}
	}
}
