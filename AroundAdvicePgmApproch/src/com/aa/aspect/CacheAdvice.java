package com.aa.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.aa.beans.Cache;

public class CacheAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = null;
		Object[] args = null;
		String key = null;
		Cache cache = null;
		Object ret = null;

		methodName=invocation.getMethod().getName();
		args=invocation.getArguments();
		System.out.println("*****CACHE***** Entering into Method::"+methodName);
		key = methodName + "(";
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				key += args[i];
				continue;
			}
			key += "," + args[i];
		}
		key += ")";
		
		cache = Cache.getInstance();
		if (cache.containsKey(key)) {
			ret = cache.get(key);
		}else {
			ret = invocation.proceed();
			System.out.println("Exiting ::"+methodName+" return value: "+ret);
			cache.put(key, ret);
		}
		return ret;
	}

}
