package com.practicaljava.codesamples;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class TestReaadAllNio {

	public static void main(String[] args) {
		Path statesFile = Paths.get("states.txt");
		
		try {
			//Populate the collection
			List<String> states = Files.readAllLines(statesFile, StandardCharsets.UTF_8);
			
			//Print state names
			states.forEach(System.out::println);
			
		} catch(IOException ioe) {
			System.out.println("Error while reading states.txt: " + ioe.getMessage());
		}
		
		Path myOutputFile = Paths.get("someOutputFile.txt");
		
		try (BufferedWriter writer = Files.newBufferedWriter(myOutputFile, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
			
			writer.write("Whatever you want to write!");
			
		} catch (IOException ioe) {
			System.out.println("Error while writing: " + ioe.getMessage());
		}

	}

}
