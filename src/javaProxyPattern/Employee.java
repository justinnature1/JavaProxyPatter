package javaProxyPattern;

public class Employee implements EmployeeInterface{

	private String firstName;
	private String lastName;
	private Employee manager;
	private double salary;
	private String address;
	
public Employee (String firstName, String lastName, Employee manager, double salary, String address) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.manager = manager;
	this.salary = salary;
	this.address = address;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public Employee getManager() {
	return manager;
}

public void setManager(Employee manager) {
	this.manager = manager;
}

public double getSalary() {
	return salary;
}

public void setSalary(double salary) {
	this.salary = salary;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

}