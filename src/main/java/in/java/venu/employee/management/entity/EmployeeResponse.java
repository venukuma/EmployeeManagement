package in.java.venu.employee.management.entity;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class EmployeeResponse {

	private int statusCode;
	private String message;
	private String status;
	private List<Employee> employees;

}
