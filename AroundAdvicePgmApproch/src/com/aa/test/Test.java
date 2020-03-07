package com.aa.test;

import org.springframework.aop.framework.ProxyFactory;

import com.aa.aspect.LoggingAdvice;
import com.aa.beans.Calculator;

public class Test {
	public static void main(String[] args) {
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(new Calculator());
		factory.addAdvice(new LoggingAdvice());
		
		Calculator proxy = (Calculator) factory.getProxy();
		int sum = proxy.add(10, 20);
		System.out.println("Sum is:"+sum);
	}
}
