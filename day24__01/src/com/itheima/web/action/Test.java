package com.itheima.web.action;

public class Test {
	public static void main(String[] args) {
		for (int i = 0; i <= 1000; i++) {
			for (int j = 0; j <= 1000 - i; j++) {
				int k = 1000 - i - j;
				if (k * k == i * i + j * j) {
					System.out.println(i +" "+k +" "+ j);
				}
			}
		}
	}
}
