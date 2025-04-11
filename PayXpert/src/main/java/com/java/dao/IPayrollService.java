package com.java.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.java.exception.DatabaseConnectionException;
import com.java.model.Payroll;

public interface IPayrollService {
	String generatePayroll(int employeeId,Date startDate,Date endDate,double basicSalary, double overtimePay, double deductions) throws DatabaseConnectionException, SQLException;
	Payroll getPayrollById(int payrollId) throws DatabaseConnectionException, SQLException;
	List<Payroll> getPayrollsForEmployee(int employeeId) throws SQLException, DatabaseConnectionException;
	List<Payroll> getPayrollsForPeriod(Date startDate, Date endDate) throws SQLException, DatabaseConnectionException;

}
