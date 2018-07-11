package com.practicaljava.codesamples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestFilePaths {

	public static void main(String[] args) {
		//Get the path to the file states.txt located in dir
		//this program was launched from
		
		Path sourcePath = Paths.get("states.txt");
		
		//copy the source file to this destination
		Path destFilePath = Paths.get("states.bak");
		
		if(Files.exists(sourcePath)) {
			System.out.println("This file " + sourcePath + " exists");
			System.out.println("The absolute path is " + sourcePath.toAbsolutePath());
			
			try {
				//Check the size (in bytes)
				System.out.println("It's size is " + Files.size(sourcePath));
				
				//copy the file from states.txt to states.bak
				Files.copy(sourcePath, destFilePath, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Copy completed. The backup file is at " + destFilePath.toAbsolutePath());
				
				
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}

}
