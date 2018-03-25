package com.liuweicom.regex;

public class Regex_Demo05 {
	/**
	 * * A:������ʽ�ķ��鹦��
			* ���������ͨ�������Ҽ����俪��������š����磬�ڱ��ʽ ((A)(B(C))) �У������ĸ��������飺 
		* 
				1     ((A)(B(C))) 
				2     (A 
				3     (B(C)) 
				4     (C) 
			
				����ʼ�մ����������ʽ��
		B:������ʾ
			a:�и�
				�����밴�յ����и "sdqqfgkkkhjppppkl";
			b:�滻
				��������....��...��.Ҫ...ҪҪ...Ҫѧ....ѧѧ..ѧ.��..���.��.��.��.��..��
				���ַ�����ԭ��:����Ҫѧ��̡���
	 */
	
	public static void demo1(){
		//���� �������,�߸�����
				/*String regex = "(.)\\1(.)\\2";					//\\1�����һ���ֳ���һ��	\\2����ڶ����ֳ���һ��
				 */
		
		String a = "(.)\\1+";
		String regex = "sdqqfgkkkhjppppkl";
		String[] args=regex.split(a);
		for(int i=0;i<args.length;i++){
			System.out.print(args[i]);
		}
	}
	
	public static void demo2(){
		String s = "����....��...��.Ҫ...ҪҪ...Ҫѧ....ѧѧ..ѧ.��..���.��.��.��.��..��";
		String s2 = s.replaceAll("\\.+", "");
		String s3 = s2.replaceAll("(.)\\1+", "$1");////$1�����һ���е�����
		System.out.print(s3);
	}
	
	public static void main(String[] args) {
//		demo1();
		demo2();
	}
	
}
