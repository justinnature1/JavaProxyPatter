package javaProxyPattern;

import java.util.HashMap;


public class EmployeeDatabaseTest {

	HashMap<String, EmployeeInterface> employeeDB = new HashMap<String, EmployeeInterface>();
 	
	public static void main(String[] args) {
		EmployeeDatabaseTest test = new EmployeeDatabaseTest();
		test.drive();
	}
 
	public EmployeeDatabaseTest() {
		createDatabase();
	}

	public void drive() {
		EmployeeInterface employee = getPersonFromDatabase("JohnDeere");
		EmployeeInterface managedEmployee = getPersonFromDatabase("JaneDoe");
		
		EmployeeInterface employeeProxy = getEmployeeProxy(employee);
		EmployeeInterface managerProxy = getManagerProxy(managedEmployee);
		EmployeeInterface noPrivilegesProxy = getNoPrivilegesProxy(employee);
		
		System.out.println("Employee Info Using Employee Proxy Before Changes:");
		printEmployeeInfo(employeeProxy);
		System.out.println();
		employeeProxy.setFirstName("Bob");;
		employeeProxy.setAddress("Geneseo, IL");			
		employeeProxy.setSalary(10000000);
		System.out.println();
		System.out.println("Employee Info Using Employee Proxy After Changes:");
		printEmployeeInfo(employeeProxy);
		
		System.out.println();
		
		System.out.println("Employee Info Using Manager Proxy Before Changes:");
		printEmployeeInfo(managerProxy);
		System.out.println();
		managerProxy.setFirstName("Jill");;
		managerProxy.setAddress("Geneseo, IL");			
		managerProxy.setSalary(60000);
		System.out.println();
		System.out.println("Employee Info Using Manager Proxy After Changes:");
		printEmployeeInfo(managerProxy);
		
		System.out.println();
		
		System.out.println("Employee Info Using No Privileges Proxy Before Changes:");
		printEmployeeInfo(noPrivilegesProxy);
	}

	void printEmployeeInfo (EmployeeInterface proxy) {
		System.out.println("Employee's Information Before:");
		System.out.println("Name is " + proxy.getFirstName() + " " + proxy.getLastName());
		System.out.println("Lives in " + proxy.getAddress());
		System.out.println("Salary: $" + proxy.getSalary());		
	}
	
	EmployeeInterface getEmployeeProxy(EmployeeInterface employee) {
		 return (EmployeeInterface) new EmployeeProxy(
				 employee, 
				 new EmployeeInvocationHandler(employee));
	}

	EmployeeInterface getManagerProxy(EmployeeInterface employee) {
		 return (EmployeeInterface) new EmployeeProxy(
				 employee, 
				 new ManagerInvocationHandler(employee));
       
	}
	
	EmployeeInterface getNoPrivilegesProxy (EmployeeInterface employee) {
		 return (EmployeeInterface) new EmployeeProxy(
				 employee, 
				 new NoPrivilegesInvocationHandler(employee));
	}

	Employee getPersonFromDatabase(String name) {
		return (Employee) employeeDB.get(name);
	}

	void createDatabase() {
		Employee employee1 = new Employee("Fawn", "Lee", null, 40000, "Moline, IL");
		employeeDB.put(employee1.getFirstName() + employee1.getLastName(), employee1);
		
		Employee employee2 = new Employee("John", "Deere", employee1, 40000, "Moline, IL");
		employeeDB.put(employee2.getFirstName() + employee2.getLastName(), employee1);

		Employee employee3 = new Employee("Jane", "Doe", employee2, 40000, "Davenport, IA");
		employeeDB.put(employee3.getFirstName() + employee3.getLastName(), employee1);

	}
	
	
}
