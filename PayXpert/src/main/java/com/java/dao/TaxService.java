package com.java.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.exception.DatabaseConnectionException;
import com.java.exception.TaxCalculationException;
import com.java.model.Tax;
import com.java.util.DatabaseContext;

public class TaxService implements ITaxService {
	Connection connection;
	PreparedStatement pst;

	@Override
	public String calculateTax(int employeeId, int taxYear) throws SQLException, TaxCalculationException, DatabaseConnectionException {
		connection = DatabaseContext.getConnection();

		
		double taxableIncome = 500000.00;
		double taxAmount = taxableIncome * 0.10; 

		String cmd = "Insert into Tax(EmployeeID, TaxYear, TaxableIncome, TaxAmount) values (?, ?, ?, ?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, employeeId);
		pst.setInt(2, taxYear);
		pst.setDouble(3, taxableIncome);
		pst.setDouble(4, taxAmount);
		pst.executeUpdate();

		return "Tax calculated successfully..";
	}

	@Override
	public Tax getTaxById(int taxId) throws SQLException, DatabaseConnectionException {
		connection = DatabaseContext.getConnection();
		String cmd = "Select * From Tax Where TaxID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, taxId);
		ResultSet rs = pst.executeQuery();
		Tax tax = null;
		if (rs.next()) {
			tax = new Tax();
			tax.setTaxID(rs.getInt("TaxID"));
			tax.setEmployeeID(rs.getInt("EmployeeID"));
			tax.setTaxYear(rs.getInt("TaxYear"));
			tax.setTaxableIncome(rs.getDouble("TaxableIncome"));
			tax.setTaxAmount(rs.getDouble("TaxAmount"));
		}
		return tax;
	}

	@Override
	public List<Tax> getTaxesForEmployee(int employeeId) throws SQLException, DatabaseConnectionException {
		connection = DatabaseContext.getConnection();
		String cmd = "Select * From Tax Where EmployeeID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, employeeId);
		ResultSet rs = pst.executeQuery();
		List<Tax> taxList = new ArrayList<>();
		while (rs.next()) {
			Tax tax = new Tax();
			tax.setTaxID(rs.getInt("TaxID"));
			tax.setEmployeeID(rs.getInt("EmployeeID"));
			tax.setTaxYear(rs.getInt("TaxYear"));
			tax.setTaxableIncome(rs.getDouble("TaxableIncome"));
			tax.setTaxAmount(rs.getDouble("TaxAmount"));
			taxList.add(tax);
		}
		return taxList;
	}

	@Override
	public List<Tax> getTaxesForYear(int taxYear) throws SQLException, DatabaseConnectionException {
		connection = DatabaseContext.getConnection();
		String cmd = "Select * From Tax Where TaxYear = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, taxYear);
		ResultSet rs = pst.executeQuery();
		List<Tax> taxList = new ArrayList<>();
		while (rs.next()) {
			Tax tax = new Tax();
			tax.setTaxID(rs.getInt("TaxID"));
			tax.setEmployeeID(rs.getInt("EmployeeID"));
			tax.setTaxYear(rs.getInt("TaxYear"));
			tax.setTaxableIncome(rs.getDouble("TaxableIncome"));
			tax.setTaxAmount(rs.getDouble("TaxAmount"));
			taxList.add(tax);
		}
		return taxList;
	}

}
