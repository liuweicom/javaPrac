package com.liuweicom.regex;

public class Regex_Demo04 {
	public static void main(String[] args) {
//		String s = "hello.world.girls";
//		String[] arg = s.split("\\.");
//		
//		for(int i =0;i<arg.length;i++){
//			System.out.println(arg[i]);
//		}
//		hello
//		world
//		girls
		
		String s="hell0000000world";
		String newS = s.replaceAll("\\d", "");
		System.out.println(newS);
//		hellworld
		
	}
}
