package com.ejemplo;

import com.ejemplo.beans.ConsultasBean;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Control
public class ControlInterceptor {
	@Inject
	ConsultasBean cs;

	@AroundInvoke
	public Object ControlInvocation(InvocationContext con) throws Exception {

		String ss = (String) con.proceed();

		if (ss.length() >= 50) {
			cs.setTemp(ss.substring(0, 50));
		} else {
			cs.setTemp(ss.substring(0, ss.length()-1));
		}

		return "consulta";
	}

}
