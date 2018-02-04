package com.itheima.client;

import java.util.Scanner;

import com.itheima.entity.User;
import com.itheima.service.Dologin;

public class login {
public static void main(String [] args){
	Scanner input =new Scanner(System.in);
	System.out.println("请输入用户名");
	String name=input.nextLine();
	System.out.println("请输入密码：");
	String password=input.nextLine();
	
	Dologin dl=new Dologin();
	User u=dl.findUser(name, password);
	if(u!=null){
		System.out.println("欢迎你"+u.getName());
	}else{
		System.out.println("用户名或密码错误");
	}
}
}
