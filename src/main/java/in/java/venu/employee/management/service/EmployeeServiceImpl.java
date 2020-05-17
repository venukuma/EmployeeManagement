package in.java.venu.employee.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.java.venu.employee.management.entity.Employee;
import in.java.venu.employee.management.entity.EmployeeResponse;
import in.java.venu.employee.management.exception.EmployeeNotFountException;
import in.java.venu.employee.management.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public EmployeeResponse insertEmployee(Employee emp) {
		EmployeeResponse response = new EmployeeResponse();
		int noOfRows = empRepo.createEmployee(emp);
		if (noOfRows > 0) {
			response.setStatusCode(200);
			response.setMessage("Employee Created Successfully");
			response.setStatus("Success");
		}
		return response;
	}

	@Override
	public EmployeeResponse getEmployees(int empId) {
		List<Employee> employees = empRepo.getAllEmployees(empId);
		EmployeeResponse response = new EmployeeResponse();
		if(null!=employees && !employees.isEmpty()) {
			
			response.setEmployees(employees);
			
		}
		return response;
	}

	@Override
	public EmployeeResponse deleteEmployee(int empId) {
		int noOfRows = empRepo.deleteEmployee(empId);
		EmployeeResponse response = new EmployeeResponse();
		if(noOfRows>0) {
			response.setStatusCode(200);
			response.setMessage("Employee "+ empId+" Deleted Successfully");
			response.setStatus("Success");
		}
		return response;
	}

}
