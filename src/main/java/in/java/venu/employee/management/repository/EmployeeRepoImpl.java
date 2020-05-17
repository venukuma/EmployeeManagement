package in.java.venu.employee.management.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import in.java.venu.employee.management.entity.Employee;
import in.java.venu.employee.management.exception.EmployeeNotFountException;
import in.java.venu.employee.management.util.EmployeeUtil;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeRepoImpl.class);

	@Override
	public Employee updateEmployee(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteEmployee(int empId) {
		Session session = EmployeeUtil.getSession();
		Transaction transaction = null;
		int result=0;
		try {
			transaction = session.beginTransaction();
			Employee emp=(Employee) session.load(Employee.class, empId);
			logger.info("Employee Id:{}",emp.toString());
			session.delete(emp);
			transaction.commit();
			result=1;
			logger.info("Employee Object After deleted {}");
		} catch (Exception e) {
			logger.info("Enterd into catch block in delete()");
			transaction.rollback();
			throw new EmployeeNotFountException("Employee already deleted or not available in DB");
		} 
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees(int empId) {
		Session session = EmployeeUtil.getSession();
		Transaction transaction = null;
		List<Employee> employees = null;
		try {
			 transaction = session.beginTransaction();
			 Criteria criteria = session.createCriteria(Employee.class);
			 employees = criteria.add(Restrictions.eq("empNo", empId)).list();
			 logger.info("Employee Details {}",employees.get(0));
		}
		catch (Exception e) {
			logger.info("Exception In DB");
			transaction.rollback();
			throw new EmployeeNotFountException("Employee Not Found in DB");
            
        } 
		
		return employees;
	}

	@Override
	public int createEmployee(Employee employee) {
		Session session = EmployeeUtil.getSession();
		logger.info("Session object:{}",session);
        Transaction transaction = null;
        logger.info("Employee Object Is:{}",employee.toString());
        try {
            transaction = session.beginTransaction();
            logger.info("Transaction object{}",transaction);
			session.save(employee);
			transaction.commit();
		} catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		return 1;
	}

	

}
