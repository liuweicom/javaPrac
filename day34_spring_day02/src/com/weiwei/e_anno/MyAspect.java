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
 * �����࣬���ж��֪ͨ
 *
 */
@Component
@Aspect
public class MyAspect {
	
	//����㵱ǰ��Ч
	@Before("execution(* com.weiwei.e_anno.UserServiceImpl.*(..))")
	public void myBefore(JoinPoint joinPoint){
		System.out.println("ǰ��֪ͨ��"+joinPoint.getSignature().getName());
	}
	
//	//�������������
//	@Pointcut("execution(* com.weiwei.e_anno.UserServiceImpl.*(..))")
//	private void myPointCut(){
//		
//	}
//	
//	@AfterReturning(value="myPointCut()", returning="ret")
//	public void myAfterRuturning(JoinPoint joinPoint,Object ret){
//		System.out.println("�������ƣ�"+joinPoint.getSignature().getName()+"====>"+ret);
//	}
//	
//	@Around(value="myPointCut()")
//	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
//		
//		System.out.println("brfore");
//		//�ֶ�ִ��Ŀ�귽��
//		Object obj = joinPoint.proceed();
//		System.out.println("after");
//		return obj;
//	}
//	
//	@AfterThrowing(value="myPointCut()", throwing="e")
//	public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
//		System.out.println("�׳��쳣:"+e.getMessage());
//	}
//	
//	@After("myPointCut()")//һ��������value����Ĭ�ϲ�д
//	public void myAfter(JoinPoint jointPoint){
//		System.out.println("����֪ͨ");
//	}
}
