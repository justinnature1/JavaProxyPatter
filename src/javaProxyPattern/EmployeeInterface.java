package javaProxyPattern;

public interface EmployeeInterface {

	public String getFirstName();
	public String getLastName();
	public Employee getManager();
	public double getSalary();
	public String getAddress();

	public void setFirstName(String firstName);
	public void setLastName(String lastName);
	public void setManager(Employee manager);
	public void setSalary(double salary);
	public void setAddress(String address);

}
