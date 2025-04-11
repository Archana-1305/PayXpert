package com.java.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.exception.DatabaseConnectionException;
import com.java.exception.FinancialRecordException;
import com.java.model.FinancialRecord;
import com.java.model.RecordType;
import com.java.util.DatabaseContext;


public class FinancialRecordService implements IFinancialRecordService {
	Connection connection;
	PreparedStatement pst;
	@Override
	public String addFinancialRecord(int employeeId, String description, double amount, String recordType)
			throws SQLException, FinancialRecordException, DatabaseConnectionException {

		connection = DatabaseContext.getConnection();

		
		java.util.Date today = new java.util.Date();
		java.sql.Date Date = new java.sql.Date(today.getTime());
		RecordType typeEnum = RecordType.valueOf(recordType.toUpperCase().replace(" ", "_"));

		String cmd = "Insert into FinancialRecord(EmployeeID, RecordDate, Description, Amount, RecordType) values (?, ?, ?, ?, ?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, employeeId);
		pst.setDate(2, Date);
		pst.setString(3, description);
		pst.setDouble(4, amount);
		pst.setString(5, typeEnum.toString().replace("_", " "));
		pst.executeUpdate();

		return "Financial record added successfully.";
	}

	@Override
	public FinancialRecord getFinancialRecordById(int recordId) throws SQLException, DatabaseConnectionException {
		connection = DatabaseContext.getConnection();
		String cmd = "Select * From FinancialRecord Where RecordID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, recordId);
		ResultSet rs = pst.executeQuery();
		FinancialRecord record = null;
		if (rs.next()) {
			record = new FinancialRecord();
			record.setRecordID(rs.getInt("RecordID"));
			record.setEmployeeID(rs.getInt("EmployeeID"));
			record.setRecordDate(rs.getDate("RecordDate"));
			record.setDescription(rs.getString("Description"));
			record.setAmount(rs.getDouble("Amount"));
			record.setRecordType(RecordType.valueOf(rs.getString("RecordType").toUpperCase().replace(" ", "_")));
		}
		return record;
	}

	@Override
	public List<FinancialRecord> getFinancialRecordsForEmployee(int employeeId) throws SQLException, DatabaseConnectionException {
		connection = DatabaseContext.getConnection();
		String cmd = "Select * From FinancialRecord Where EmployeeID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, employeeId);
		ResultSet rs = pst.executeQuery();
		List<FinancialRecord> recordList = new ArrayList<>();
		while (rs.next()) {
			FinancialRecord record = new FinancialRecord();
			record.setRecordID(rs.getInt("RecordID"));
			record.setEmployeeID(rs.getInt("EmployeeID"));
			record.setRecordDate(rs.getDate("RecordDate"));
			record.setDescription(rs.getString("Description"));
			record.setAmount(rs.getDouble("Amount"));
			record.setRecordType(RecordType.valueOf(rs.getString("RecordType").toUpperCase().replace(" ", "_")));
			recordList.add(record);
		}
		return recordList;
	}

	@Override
	public List<FinancialRecord> getFinancialRecordsForDate(Date recordDate) throws SQLException, DatabaseConnectionException {
		connection = DatabaseContext.getConnection();
		java.sql.Date Date = new java.sql.Date(recordDate.getTime());
		String cmd = "Select * From FinancialRecord Where RecordDate = ?";
		pst = connection.prepareStatement(cmd);
		pst.setDate(1, Date);
		ResultSet rs = pst.executeQuery();
		List<FinancialRecord> recordList = new ArrayList<>();
		while (rs.next()) {
			FinancialRecord record = new FinancialRecord();
			record.setRecordID(rs.getInt("RecordID"));
			record.setEmployeeID(rs.getInt("EmployeeID"));
			record.setRecordDate(rs.getDate("RecordDate"));
			record.setDescription(rs.getString("Description"));
			record.setAmount(rs.getDouble("Amount"));
			record.setRecordType(RecordType.valueOf(rs.getString("RecordType").toUpperCase().replace(" ", "_")));
			recordList.add(record);
		}
		return recordList;
	}

}
