package com.practiclajava.lesson8;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HelloWorld extends JFrame {

	public static void main(String[] args) {
		JFrame myWindow = new HelloWorld();
		
		//Creating and adding a button to the container
		JButton myButton = new JButton ("Click me");
		myWindow.add(myButton);
		myWindow.setSize(200, 300);
		myWindow.setTitle("Hello World!");
		myWindow.setVisible(true);	
	}

}
