package com.practicaljava.homework;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipInputStreamTest {

	public static void main(String[] args) {
		//Open the FileInputStream and connect it with ZipInputStream
		
		ZipEntry myEntry = null;
		
		try (FileInputStream myFile = new FileInputStream("Lesson 14.zip");
				BufferedInputStream buff = new BufferedInputStream(myFile);
				ZipInputStream myZip = new ZipInputStream(myFile, StandardCharsets.UTF_8);)
				{
			

			while((myEntry = myZip.getNextEntry()) != null) {
				System.out.println(myEntry.getName());
				System.out.println(myEntry.getSize());
				myZip.closeEntry();
			} 
		
		} catch (IOException ioe) {
			System.out.println("Warning! Can't read Lesson 14.zip " + ioe.getMessage());
		}
	}
}
