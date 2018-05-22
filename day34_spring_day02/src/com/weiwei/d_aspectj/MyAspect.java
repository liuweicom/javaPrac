package com.weiwei.d_aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * �����࣬���ж��֪ͨ
 *
 */
public class MyAspect {
	
	public void myBefore(JoinPoint joinPoint){
		System.out.println("ǰ��֪ͨ��"+joinPoint.getSignature().getName());
	}
	
	public void myAfterRuturning(JoinPoint joinPoint,Object ret){
		System.out.println("�������ƣ�"+joinPoint.getSignature().getName()+"====>"+ret);
	}
	
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("brfore");
		//�ֶ�ִ��Ŀ�귽��
		Object obj = joinPoint.proceed();
		System.out.println("after");
		return obj;
	}
	
	public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("�׳��쳣:"+e.getMessage());
	}
	
	public void myAfter(JoinPoint jointPoint){
		System.out.println("����֪ͨ");
	}
}
