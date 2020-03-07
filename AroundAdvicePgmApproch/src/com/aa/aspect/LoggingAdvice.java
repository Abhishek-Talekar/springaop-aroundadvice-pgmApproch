package com.aa.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String methodName = null;
		Object[] args = null;

		methodName = methodInvocation.getMethod().getName();
		args = methodInvocation.getArguments();

		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				System.out.println("Logging Information:");
				System.out.print("Method & Parameters passed are: " + methodName + "(" + args[i]);
				continue;
			}
			System.out.print("," + args[i] + ")");
		}
		
		Object ret = methodInvocation.proceed();
		
		System.out.println("Logging report Successful for method: "+methodName+"()");
		
		return ret;
	}

}
