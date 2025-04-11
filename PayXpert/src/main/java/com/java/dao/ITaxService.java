package com.java.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.exception.DatabaseConnectionException;
import com.java.exception.TaxCalculationException;
import com.java.model.Tax;

public interface ITaxService {
	String calculateTax(int employeeId, int taxYear) throws SQLException, TaxCalculationException, DatabaseConnectionException;
	Tax getTaxById(int taxId) throws SQLException, DatabaseConnectionException;
	List<Tax> getTaxesForEmployee(int employeeId) throws SQLException, DatabaseConnectionException;
    List<Tax> getTaxesForYear(int taxYear) throws SQLException,DatabaseConnectionException ;

}
