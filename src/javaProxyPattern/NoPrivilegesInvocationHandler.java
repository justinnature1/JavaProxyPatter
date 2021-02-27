package javaProxyPattern;

import java.lang.reflect.*;

public class NoPrivilegesInvocationHandler implements InvocationHandler{
	
	public EmployeeInterface employee;
	
	public NoPrivilegesInvocationHandler (EmployeeInterface employee) {
		this.employee = employee;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		throw new IllegalAccessException();		
	}
	
}
