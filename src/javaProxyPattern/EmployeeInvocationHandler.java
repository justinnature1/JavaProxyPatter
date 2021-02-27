package javaProxyPattern;

import java.lang.reflect.*;

public class EmployeeInvocationHandler implements InvocationHandler{
	
	public EmployeeInterface employee;
	
	public EmployeeInvocationHandler (EmployeeInterface employee) {
		this.employee = employee;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(employee, args);
   			} else if (method.getName().equals("setSalary") || method.getName().equals("setManager")) {
				throw new IllegalAccessException();
			} else if (method.getName().startsWith("set")) {
				return method.invoke(employee, args);
			} 
		}
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
