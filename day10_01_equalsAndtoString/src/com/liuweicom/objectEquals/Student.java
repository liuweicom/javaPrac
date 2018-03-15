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
	 * toString����Ĭ�����У�this.getClass()+'@'+Integer.toHexString(this.hashCode())
	 * ͨ����Ҫ���޸ĳ�class�����Դ��������ַ���
	 */
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}
	
	//Ĭ������±Ƚϵ��Ƕ���������Ƿ���ͬ
	//	==�ź�equals����������
	/*
	 * ==�ţ���һ�����ԱȽ�������ţ��ȿ��ԱȽϱȱ��������ͣ�Ҳ���ԱȽ������������ͣ������������ͱȽϵ���ֵ��Ӧ�����ͱȽϵ��ǵ�ַ
	 * equals��������һ��������ֻ�ܱȽ������������ͣ����еĶ��󶼻�̳�Object���еķ��������û����дObject����equals������equals������==�űȽ���������������������д���equals�����Ƚϵ��Ƕ����е�����
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
