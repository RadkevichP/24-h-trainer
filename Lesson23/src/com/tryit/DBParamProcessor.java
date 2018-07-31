package com.tryit;

public class DBParamProcessor {

	public static void main(String[] args) {
		
		//assign what class to analyze 
		try {
			//load class with it name
			Class loadedClass = Class.forName("com.tryit.MyDBWorker");
			
			//check if the class is marked with annotation
			if (loadedClass.isAnnotationPresent(com.tryit.DBParams.class)) {
				System.out.println("Yees!");
				//introspect the annotation and print values of the parameters
				DBParams dbParams = (DBParams) loadedClass.getAnnotation(com.tryit.DBParams.class);
				System.out.println("Parameters of DBParams are: " + "dbName - " + dbParams.dbName() + " , uid - " + dbParams.uid() + " , password - " + dbParams.password());
			}
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

	}

}
