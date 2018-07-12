package com.practicaljava.codesamples;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

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
		
		//create the byte array and populate it
		int someData[] = {56, 230, 31, 90, 55, 11};
		
		
		//wrtite byte array into file
		try (FileOutputStream myFile = new FileOutputStream("xyz.dat")) {
			
			for (int i=0; i < someData.length; i++ ) {
				myFile.write(someData[i]);
			}			
			
		} catch (IOException ioe) {
			System.out.println("Could not write to a file: " + ioe.toString() );
		} finally {
			System.out.println("");
		}
		
		//read file with BuferredReader
		
		try (FileInputStream myFile = new FileInputStream("abc.dat");
				BufferedInputStream buff = new BufferedInputStream(myFile);) {
			
			boolean endOfFile = false;
			
			while (!endOfFile) {
				int byteValue = buff.read();
				System.out.print(byteValue + " ");
				if (byteValue == -1) 
					endOfFile = true;				
			}		
			
		} catch(IOException ioe) {
			System.out.println("Could not read from the file: " + ioe.getMessage());
		} {
			System.out.println("");
		}
		
		//read file with StringBuffer
		
		StringBuffer buffer = new StringBuffer();
		
		try (FileInputStream myFile = new FileInputStream("abc.dat");
				InputStreamReader inputStreamReader = new InputStreamReader(myFile, "UTF8");
				Reader reader = new BufferedReader(inputStreamReader);) {
			
			int ch;
			while((ch=reader.read()) > -1) {
				buffer.append((char)ch);
			}
			System.out.println(buffer.toString());

			
		} catch (IOException ioe) {
			System.out.println("Warning! " + ioe.toString());
		}
		
		//write file with BufferdWriter
		try (FileOutputStream myFile = new FileOutputStream("xyz.dat");
				Writer out = new BufferedWriter(
						new OutputStreamWriter(myFile, "UTF8"));) {
			String myAdress = "123 Broadway, New York, NY, 10011";
			out.write(myAdress);
		} catch(IOException ioe) {
			System.out.println("Warning!! " + ioe.toString());
		}
		
	}
}
