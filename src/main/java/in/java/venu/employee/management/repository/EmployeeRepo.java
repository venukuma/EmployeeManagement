package in.java.venu.employee.management.repository;

import java.util.List;

import in.java.venu.employee.management.entity.Employee;

public interface EmployeeRepo {
	
	public int createEmployee(Employee employee);
	public Employee updateEmployee(int empId);
	public int deleteEmployee(int empId);
	public List<Employee> getAllEmployees(int empId);

}
