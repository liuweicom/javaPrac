package com.liuweicom.objectEquals;

public class getStudent {

	public static void main(String[] args){
		Student s = new Student();
		s.setAge(10);
		s.setName("liu");
		Student d = new Student();
		d.setAge(10);
		d.setName("liu");
		System.out.println(s);
		System.out.println(s.equals(d));
	}
}
