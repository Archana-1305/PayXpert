package com.java;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.java.model.FinancialRecord;
import com.java.model.RecordType;

public class FinancialRecordTest {

	@Test
    public void testToString() {
        FinancialRecord record = new FinancialRecord(1, 101, Date.valueOf("2024-04-01"), "Salary Credited", 45000.0, RecordType.INCOME);
        String expected = "FinancialRecord [recordID=1, employeeID=101, recordDate=2024-04-01, description=Salary Credited, amount=45000.0, recordType=INCOME]";
        assertEquals(expected, record.toString());
    }

    @Test
    public void testGettersAndSetters() {
        FinancialRecord record = new FinancialRecord();
        record.setRecordID(2);
        record.setEmployeeID(202);
        record.setRecordDate(Date.valueOf("2024-04-10"));
        record.setDescription("Tax Deducted");
        record.setAmount(5000.0);
        record.setRecordType(RecordType.INCOME);

        assertEquals(2, record.getRecordID());
        assertEquals(202, record.getEmployeeID());
        assertEquals(Date.valueOf("2024-04-10"), record.getRecordDate());
        assertEquals("Tax Deducted", record.getDescription());
        assertEquals(5000.0, record.getAmount(), 0.01);
        assertEquals(RecordType.INCOME, record.getRecordType());
    }

    @Test
    public void testConstructor() {
        FinancialRecord record = new FinancialRecord();
        assertNotNull(record);

        FinancialRecord record1 = new FinancialRecord(3, 303, Date.valueOf("2024-03-01"), "Software License", 12000.0, RecordType.EXPENSE);
        assertEquals(3, record1.getRecordID());
        assertEquals(303, record1.getEmployeeID());
        assertEquals(Date.valueOf("2024-03-01"), record1.getRecordDate());
        assertEquals("Software License", record1.getDescription());
        assertEquals(12000.0, record1.getAmount(), 0.01);
        assertEquals(RecordType.EXPENSE, record1.getRecordType());
    }

}
