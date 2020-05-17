package in.java.venu.employee.management.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Emp_Details")
public class Employee {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	@Column(name = "EMP_ID")
	private int empNo;
	@NotNull
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "EMP_DOB")
	private Date empDOB;
	@NotNull
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "EMP_DOJ")
	private Date empDOJ;

	@NotNull
	@Column(name = "FIRST_NAME")
	private String empFirstname;
	@NotNull
	@Column(name = "GENDER")
	private char empGender;
	@Column(name = "LAST_NAME")
	private String empLastName;
	@NotNull
	@Column(name = "EMP_EMAIL")
	private String empMail;
	@NotNull
	@Column(name = "SALARY")
	private double empSalary;
	@NotNull
	@Column(name = "EMP_TITLE")
	private String empTitle;

	@NotNull
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	private Address empAddress;

}
