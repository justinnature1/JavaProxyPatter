package javaProxyPattern;

import java.lang.reflect.*;

public class EmployeeProxy implements EmployeeInterface {
	EmployeeInterface employee;
	InvocationHandler invocationHandler;


	public EmployeeProxy (EmployeeInterface employee, InvocationHandler invocationHandler) {
		this.employee = employee;
		this.invocationHandler = invocationHandler;
	}

	public String getFirstName() {
		try {
			Method method = employee.getClass().getDeclaredMethod("getFirstName", null);
			return (String) invocationHandler.invoke(this, method, null);
		}
		catch (IllegalAccessException e) {
			System.out.println("Can't access first name");
		}
		catch (Throwable e) {
			System.out.println(e.toString()); 
		}
		return null;
	}
	public String getLastName() {
		try {
			Method method = employee.getClass().getDeclaredMethod("getLastName", null);
			return (String) invocationHandler.invoke(this, method, null);
		}
		catch (IllegalAccessException e) {
			System.out.println("Can't access last name.");
		}
		catch (Throwable e) {
			System.out.println(e.toString()); 
		}
		return null;
	}
	public Employee getManager() {
		try {
			Method method = employee.getClass().getDeclaredMethod("getManager", null);
			return (Employee) invocationHandler.invoke(this, method, null);
		}
		catch (IllegalAccessException e) {
			System.out.println("Can't access manager.");
		}
		catch (Throwable e) {
			System.out.println(e.toString()); 
		}
		return null;
	}
	public double getSalary() {
		try {
			Method method = employee.getClass().getDeclaredMethod("getSalary", null);
			return (double) invocationHandler.invoke(this, method, null);
		}
		catch (IllegalAccessException e) {
			System.out.println("Can't access salary.");
		}
		catch (Throwable e) {
			System.out.println(e.toString()); 
		}
		return 0;
	}
	public String getAddress() {
		try {
			Method method = employee.getClass().getDeclaredMethod("getAddress", null);
			return (String) invocationHandler.invoke(this, method, null);
		}
		catch (IllegalAccessException e) {
			System.out.println("Can't set address.");
		}
		catch (Throwable e) {
			System.out.println(e.toString()); 
		}
		return null;
	}

	public void setFirstName(String firstName) {
		try {
			Object[] arg = {firstName};
			Class[] param = new Class[1];
			param[0] = String.class;  
			Method method = employee.getClass().getDeclaredMethod("setFirstName", param);  
			invocationHandler.invoke(this, method, arg);

		}
		catch (IllegalAccessException e) {
			System.out.println("Can't set first name.");
		}
		catch (Throwable e) {
			System.out.println(e.toString()); 
		}
	}
	public void setLastName(String lastName) {
		try {
			String[] arg = {lastName};
			Class[] param = new Class[1];  
			param[0] = String.class;  
			Method method = employee.getClass().getDeclaredMethod("setLastName", param);  
			invocationHandler.invoke(this, method, arg);
		}
		catch (IllegalAccessException e) {
			System.out.println("Can't set last name.");
		}
		catch (Throwable e) {
			System.out.println(e.toString()); 
		}
	}
	public void setManager(Employee manager) {
		try {
			Employee[] arg = {manager};
			Class[] param = new Class[1];  
			param[0] = Employee.class;  
			Method method = employee.getClass().getDeclaredMethod("setManager", param);  
			invocationHandler.invoke(this, method, arg);
		}
		catch (IllegalAccessException e) {
			System.out.println("Can't set manager.");
		}
		catch (Throwable e) {
			System.out.println(e.toString()); 
		}
	}
	public void setSalary(double salary){
		try {
			Double[] arg = {salary};
			Class[] param = new Class[1];  
			param[0] = double.class;  
			Method method = employee.getClass().getDeclaredMethod("setSalary", param);  
			invocationHandler.invoke(this, method, arg);
		}
		catch (IllegalAccessException e) {
			System.out.println("Can't set salary.");
		}
		catch (Throwable e) {
			
			
			System.out.println(e.toString()); 
		}
	}
	public void setAddress(String address) {
		try {
			String[] arg = {address};
			Class[] param = new Class[1];  
			param[0] = String.class;  
			Method method = employee.getClass().getDeclaredMethod("setAddress", param);  
			invocationHandler.invoke(this, method, arg);
		}
		catch (IllegalAccessException e) {
			System.out.println("Can't set address.");
		}
		catch (Throwable e) {
			System.out.println(e.toString()); 
		}
	}

}
