package javaProxyPattern;

import java.lang.reflect.*;

public class ManagerInvocationHandler implements InvocationHandler{

	public EmployeeInterface employee;

	public ManagerInvocationHandler (EmployeeInterface employee) {
		this.employee = employee;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(employee, args);
			} else if (method.getName().equals("setSalary") || method.getName().equals("setManager")) {
				return method.invoke(employee, args);
			} else if (method.getName().startsWith("set")) {
				throw new IllegalAccessException();
			} 
		}
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;

	}

}
