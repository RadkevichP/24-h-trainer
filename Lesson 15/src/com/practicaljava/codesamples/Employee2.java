package com.practicaljava.codesamples;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class Employee2 implements Externalizable {

	String lName;
	String fName;
	String address;
	Date hireDate;
	int id;
	double salary;
	
	@Override
	public void readExternal(ObjectInput stream) throws IOException, ClassNotFoundException {
		salary = stream.readDouble();
		id = stream.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput stream) throws IOException {
		//Serializing only the salary and id
		stream.writeDouble(salary);
		stream.writeInt(id);

	}

}
