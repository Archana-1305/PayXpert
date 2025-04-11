package com.java.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.java.exception.DatabaseConnectionException;
import com.java.exception.FinancialRecordException;
import com.java.model.FinancialRecord;

public interface IFinancialRecordService {
	String addFinancialRecord(int employeeId, String description, double amount, String recordType)throws SQLException, FinancialRecordException, DatabaseConnectionException;
	FinancialRecord getFinancialRecordById(int recordId) throws SQLException, DatabaseConnectionException;
	List<FinancialRecord> getFinancialRecordsForEmployee(int employeeId)throws SQLException, DatabaseConnectionException;
    List<FinancialRecord> getFinancialRecordsForDate(Date recordDate) throws SQLException, DatabaseConnectionException;


}
