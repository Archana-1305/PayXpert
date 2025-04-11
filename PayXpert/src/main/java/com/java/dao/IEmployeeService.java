package com.java.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.exception.DatabaseConnectionException;
import com.java.exception.EmployeeNotFoundException;
import com.java.model.Employee;

public interface IEmployeeService {
	Employee getEmployeeById(int employeeId) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException;
	List<Employee> getAllEmployees() throws DatabaseConnectionException, SQLException;
	String addEmployee(Employee employee) throws DatabaseConnectionException, SQLException;
	String updateEmployee(Employee employee) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException;
	String removeEmployee(int employeeId) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException;
	

}
