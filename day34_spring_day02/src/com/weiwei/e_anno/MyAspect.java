package com.weiwei.e_anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类，含有多个通知
 *
 */
@Component
@Aspect
public class MyAspect {
	
	//切入点当前有效
	@Before("execution(* com.weiwei.e_anno.UserServiceImpl.*(..))")
	public void myBefore(JoinPoint joinPoint){
		System.out.println("前置通知："+joinPoint.getSignature().getName());
	}
	
//	//声明公共切入点
//	@Pointcut("execution(* com.weiwei.e_anno.UserServiceImpl.*(..))")
//	private void myPointCut(){
//		
//	}
//	
//	@AfterReturning(value="myPointCut()", returning="ret")
//	public void myAfterRuturning(JoinPoint joinPoint,Object ret){
//		System.out.println("后置配制："+joinPoint.getSignature().getName()+"====>"+ret);
//	}
//	
//	@Around(value="myPointCut()")
//	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
//		
//		System.out.println("brfore");
//		//手动执行目标方法
//		Object obj = joinPoint.proceed();
//		System.out.println("after");
//		return obj;
//	}
//	
//	@AfterThrowing(value="myPointCut()", throwing="e")
//	public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
//		System.out.println("抛出异常:"+e.getMessage());
//	}
//	
//	@After("myPointCut()")//一个参数是value可以默认不写
//	public void myAfter(JoinPoint jointPoint){
//		System.out.println("最终通知");
//	}
}
