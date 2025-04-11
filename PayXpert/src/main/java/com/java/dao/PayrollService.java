package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.java.exception.DatabaseConnectionException;
import com.java.model.Payroll;
import com.java.util.DatabaseContext;

public class PayrollService implements IPayrollService {
	Connection connection;
	PreparedStatement pst;

	@Override
	public String generatePayroll(int employeeId, Date startDate, Date endDate, double basicSalary, double overtimePay, double deductions) throws DatabaseConnectionException, SQLException {
		connection = DatabaseContext.getConnection();
		double netSalary = basicSalary + overtimePay - deductions;
		java.sql.Date StartDate = new java.sql.Date(startDate.getTime());
	    java.sql.Date EndDate = new java.sql.Date(endDate.getTime());
		 String cmd = "Insert into Payroll(EmployeeID, PayPeriodStartDate, PayPeriodEndDate, BasicSalary, OvertimePay, Deductions, NetSalary) values (?, ?, ?, ?, ?, ?, ?)";
		 pst = connection.prepareStatement(cmd);
		    pst.setInt(1, employeeId);
		    pst.setDate(2, StartDate);
		    pst.setDate(3, EndDate);
		    pst.setDouble(4, basicSalary);
		    pst.setDouble(5, overtimePay);
		    pst.setDouble(6, deductions);
		    pst.setDouble(7, netSalary);
		    pst.executeUpdate();
		
		return "Payroll generated successfully..";
	}

	@Override
	public Payroll getPayrollById(int payrollId) throws DatabaseConnectionException, SQLException {
		connection = DatabaseContext.getConnection();
		String cmd = "Select * From Payroll Where PayrollID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, payrollId);
		ResultSet rs = pst.executeQuery();
		Payroll payroll = null;
		if (rs.next()) {
			payroll = new Payroll();
			payroll.setPayrollID(rs.getInt("PayrollID"));
			payroll.setEmployeeID(rs.getInt("EmployeeID"));
			payroll.setPayPeriodStartDate(rs.getDate("PayPeriodStartDate"));
			payroll.setPayPeriodEndDate(rs.getDate("PayPeriodEndDate"));
			payroll.setBasicSalary(rs.getDouble("BasicSalary"));
			payroll.setOvertimePay(rs.getDouble("OvertimePay"));
			payroll.setDeductions(rs.getDouble("Deductions"));
			payroll.setNetSalary(rs.getDouble("NetSalary"));
		}
		return payroll;
		
	}

	@Override
	public List<Payroll> getPayrollsForEmployee(int employeeId) throws SQLException, DatabaseConnectionException {
		connection = DatabaseContext.getConnection();
		String cmd = "Select * From Payroll Where EmployeeID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, employeeId);
		ResultSet rs = pst.executeQuery();
		List<Payroll> payrollList = new ArrayList<>();
		while (rs.next()) {
			Payroll payroll = new Payroll();
			payroll.setPayrollID(rs.getInt("PayrollID"));
			payroll.setEmployeeID(rs.getInt("EmployeeID"));
			payroll.setPayPeriodStartDate(rs.getDate("PayPeriodStartDate"));
			payroll.setPayPeriodEndDate(rs.getDate("PayPeriodEndDate"));
			payroll.setBasicSalary(rs.getDouble("BasicSalary"));
			payroll.setOvertimePay(rs.getDouble("OvertimePay"));
			payroll.setDeductions(rs.getDouble("Deductions"));
			payroll.setNetSalary(rs.getDouble("NetSalary"));
			payrollList.add(payroll);
		}
		return payrollList;
	
	}

	@Override
	public List<Payroll> getPayrollsForPeriod(Date startDate, Date endDate) throws SQLException, DatabaseConnectionException {
		connection = DatabaseContext.getConnection();
		java.sql.Date StartDate = new java.sql.Date(startDate.getTime());
		java.sql.Date EndDate = new java.sql.Date(endDate.getTime());

		String cmd = "Select * From Payroll Where PayPeriodStartDate >= ? And PayPeriodEndDate <= ?";
		pst = connection.prepareStatement(cmd);
		pst.setDate(1, StartDate);
		pst.setDate(2, EndDate);
		ResultSet rs = pst.executeQuery();
		List<Payroll> payrollList = new ArrayList<>();
		while (rs.next()) {
			Payroll payroll = new Payroll();
			payroll.setPayrollID(rs.getInt("PayrollID"));
			payroll.setEmployeeID(rs.getInt("EmployeeID"));
			payroll.setPayPeriodStartDate(rs.getDate("PayPeriodStartDate"));
			payroll.setPayPeriodEndDate(rs.getDate("PayPeriodEndDate"));
			payroll.setBasicSalary(rs.getDouble("BasicSalary"));
			payroll.setOvertimePay(rs.getDouble("OvertimePay"));
			payroll.setDeductions(rs.getDouble("Deductions"));
			payroll.setNetSalary(rs.getDouble("NetSalary"));
			payrollList.add(payroll);
		}
		return payrollList;
	
	}

}
