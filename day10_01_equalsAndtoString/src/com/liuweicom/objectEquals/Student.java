package com.liuweicom.objectEquals;

public class Student {

	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * toString方法默认是有：this.getClass()+'@'+Integer.toHexString(this.hashCode())
	 * 通常都要被修改成class中属性串起来的字符串
	 */
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}
	
	//默认情况下比较的是对象的引用是否相同
	//	==号和equals方法的区别：
	/*
	 * ==号，是一个可以比较运算符号，既可以比较比本数据类型，也可以比较引用数据类型，基本数据类型比较的是值，应用类型比较的是地址
	 * equals方法，是一个方法，只能比较引用数据类型，所有的对象都会继承Object类中的方法，如果没有重写Object类中equals方法，equals方法和==号比较引用数据类型无区别，重写后的equals方法比较的是对象中的属性
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
