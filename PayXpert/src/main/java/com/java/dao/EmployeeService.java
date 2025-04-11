package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.java.exception.DatabaseConnectionException;
import com.java.exception.EmployeeNotFoundException;
import com.java.model.Employee;
import com.java.model.Gender;
import com.java.util.DatabaseContext;

public class EmployeeService implements IEmployeeService  {
	Connection connection;
	PreparedStatement pst;
	

	@Override
	public Employee getEmployeeById(int employeeId) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException {
		connection=DatabaseContext.getConnection();
		String cmd= "Select * from Employee where EmployeeId = ?";
		pst= connection.prepareStatement(cmd);
		pst.setInt(1, employeeId);
		ResultSet rs= pst.executeQuery();
		Employee emp=null;
		if(rs.next()) {
			emp = new Employee();
			emp.setEmployeeID(rs.getInt("EmployeeID"));
			emp.setFirstName(rs.getString("FirstName"));
			emp.setLastName(rs.getString("LastName"));
			emp.setDateOfBirth(rs.getDate("DateOfBirth"));
			emp.setGender(Gender.valueOf(rs.getString("Gender").toUpperCase()));
			emp.setEmail(rs.getString("Email"));
			emp.setPhoneNumber(rs.getString("PhoneNumber"));
			emp.setAddress(rs.getString("Address"));
			emp.setPosition(rs.getString("Position"));
			emp.setJoiningDate(rs.getDate("JoiningDate"));
			emp.setTerminationDate(rs.getDate("TerminationDate"));
			
		}
		else {
			throw new EmployeeNotFoundException("Employee with ID "+ employeeId +" not Found" );
		}
		
		return emp;
		
	}

	@Override
	public List<Employee> getAllEmployees() throws DatabaseConnectionException, SQLException {
		connection= DatabaseContext.getConnection();
		String cmd = "Select * from Employee";
		pst= connection.prepareStatement(cmd);
		ResultSet rs= pst.executeQuery(cmd);
		List <Employee> empList= new ArrayList<Employee>();
		while(rs.next()) {
			Employee emp= new Employee();
			emp.setEmployeeID(rs.getInt("EmployeeID"));
			emp.setFirstName(rs.getString("FirstName"));
			emp.setLastName(rs.getString("LastName"));
			emp.setDateOfBirth(rs.getDate("DateOfBirth"));
			emp.setGender(Gender.valueOf(rs.getString("Gender").toUpperCase()));
			emp.setEmail(rs.getString("Email"));
			emp.setPhoneNumber(rs.getString("PhoneNumber"));
			emp.setAddress(rs.getString("Address"));
			emp.setPosition(rs.getString("Position"));
			emp.setJoiningDate(rs.getDate("JoiningDate"));
			emp.setTerminationDate(rs.getDate("TerminationDate"));
			empList.add(emp);		
		}
		
		return empList;
	}

	@Override
	public String addEmployee(Employee employee) throws DatabaseConnectionException, SQLException {
		connection= DatabaseContext.getConnection();
		java.sql.Date Dob = new java.sql.Date(employee.getDateOfBirth().getTime());
		java.sql.Date JoinDate = new java.sql.Date(employee.getJoiningDate().getTime());
		java.sql.Date TerminationDate = null;
		if (employee.getTerminationDate() != null) {
		    TerminationDate = new java.sql.Date(employee.getTerminationDate().getTime());
		}
		String cmd="Insert into Employee(FirstName, LastName, DateOfBirth, Gender, Email, PhoneNumber, Address, Position, JoiningDate, TerminationDate) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		pst= connection.prepareStatement(cmd);
		pst.setString(1, employee.getFirstName());
		pst.setString(2, employee.getLastName());
		pst.setDate(3, Dob);
		pst.setString(4, employee.getGender().toString());
		pst.setString(5, employee.getEmail());
		pst.setString(6, employee.getPhoneNumber());
		pst.setString(7, employee.getAddress());
		pst.setString(8, employee.getPosition());
		pst.setDate(9, JoinDate);
		if(employee.getTerminationDate()!=null) {
			pst.setDate(10, TerminationDate);
		}
		else {
			pst.setNull(10, java.sql.Types.DATE);
		}
		pst.executeUpdate();
		return "Employee added sucessfully..";
	}

	@Override
	public String updateEmployee(Employee employee) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException {
		getEmployeeById(employee.getEmployeeID());
		connection=DatabaseContext.getConnection();
		java.sql.Date Dob = new java.sql.Date(employee.getDateOfBirth().getTime());
		java.sql.Date JoinDate = new java.sql.Date(employee.getJoiningDate().getTime());
		java.sql.Date TerminationDate = null;
		if (employee.getTerminationDate() != null) {
		    TerminationDate = new java.sql.Date(employee.getTerminationDate().getTime());
		}
		String cmd = "Update Employee set FirstName = ?, LastName = ?, DateOfBirth = ?, Gender = ?, Email = ?,PhoneNumber = ?, Address = ?, Position = ?, JoiningDate = ?, TerminationDate = ? where EmployeeID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, employee.getFirstName());
		pst.setString(2, employee.getLastName());
		pst.setDate(3, Dob);
		pst.setString(4, employee.getGender().toString());
		pst.setString(5, employee.getEmail());
		pst.setString(6, employee.getPhoneNumber());
		pst.setString(7, employee.getAddress());
		pst.setString(8, employee.getPosition());
		pst.setDate(9, JoinDate);
		if(employee.getTerminationDate()!=null) {
			pst.setDate(10, TerminationDate);
		}
		else {
			pst.setNull(10, java.sql.Types.DATE);
		}
		pst.setInt(11, employee.getEmployeeID());
		pst.executeUpdate();
		return "Employee updated sucessfully..";
		
	}

	@Override
	public String removeEmployee(int employeeId) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException {
		getEmployeeById(employeeId);
		connection= DatabaseContext.getConnection();
		String cmd = "Delete From Employee Where EmployeeID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, employeeId);
		pst.executeUpdate();
		return "Employee removed successfully..";
		
		
		
	}
	

}
