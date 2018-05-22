package com.weiwei.d_aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类，含有多个通知
 *
 */
public class MyAspect {
	
	public void myBefore(JoinPoint joinPoint){
		System.out.println("前置通知："+joinPoint.getSignature().getName());
	}
	
	public void myAfterRuturning(JoinPoint joinPoint,Object ret){
		System.out.println("后置配制："+joinPoint.getSignature().getName()+"====>"+ret);
	}
	
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("brfore");
		//手动执行目标方法
		Object obj = joinPoint.proceed();
		System.out.println("after");
		return obj;
	}
	
	public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("抛出异常:"+e.getMessage());
	}
	
	public void myAfter(JoinPoint jointPoint){
		System.out.println("最终通知");
	}
}
