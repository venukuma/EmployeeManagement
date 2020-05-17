package in.java.venu.employee.management.service;

import in.java.venu.employee.management.entity.Employee;
import in.java.venu.employee.management.entity.EmployeeResponse;

public interface EmployeeService {
	
	public EmployeeResponse insertEmployee(Employee emp);
	public EmployeeResponse getEmployees(int empId);
	public EmployeeResponse deleteEmployee(int EmpId);
	

}
