package in.java.venu.employee.management.output;

import java.util.Date;

import in.java.venu.employee.management.entity.Address;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmpResponse {
	private int empNo;
	private Date empDOB;
	private Date empDOJ;
	private String empFirstname;
	private char empGender;
	private String empLastName;
	private String empMail;
	private double empSalary;
	private String empTitle;
	private String phoneNumber;
	private Address empAddress;
}
