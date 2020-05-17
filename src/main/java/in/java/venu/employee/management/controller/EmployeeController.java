package in.java.venu.employee.management.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import in.java.venu.employee.management.entity.Employee;
import in.java.venu.employee.management.entity.EmployeeResponse;
import in.java.venu.employee.management.exception.EmployeeNotFountException;
import in.java.venu.employee.management.json.validator.JsonSchemaValidator;
import in.java.venu.employee.management.service.EmployeeService;

@RestController
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping(value = "v1/createEmployee")
	public EmployeeResponse createEmp(@RequestBody Employee employee) throws Exception {
		EmployeeResponse response = new EmployeeResponse();
		List<String> isJsonValidator = JsonSchemaValidator.validateJson(employee);
		if(isJsonValidator.size()>0) {
			response = service.insertEmployee(employee);
		}else {
			logger.info("JsonValidator else block"+isJsonValidator);
		}
		
		return response;
	}
		

	@GetMapping(value = "v1/getEmployee")
	public List<Employee> getEmployees(@RequestParam(value = "empId") int empId) {
		logger.info("Entered into getEmployees");
		EmployeeResponse response = service.getEmployees(empId);
		logger.info("List of Employees {}",response.getEmployees());
		//Already handled in DAO Layer
		if(response.getEmployees()==null) {
			throw new EmployeeNotFountException("Employee "+empId+" Not forund");
		}
		return response.getEmployees();
	}
	
	@DeleteMapping(value = "v1/deleteEmployee")
	public EmployeeResponse deleteEmployee(@RequestParam(value = "id") int empId) {
		logger.info("Entered into  delete Employees");
		EmployeeResponse response = null;
		try {
			response = service.deleteEmployee(empId);
			if (response.getEmployees().isEmpty()) {

			}
		} catch (Exception e) {
			throw new EmployeeNotFountException("ALready Deleted");
		}
		return response;
	}
		

}
