package com.java;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.java.model.Payroll;

public class PayrollTest {

	@Test
    public void testToString() {
        Payroll payroll = new Payroll(1, 101, Date.valueOf("2023-01-01"), Date.valueOf("2023-01-31"), 50000.0, 2000.0, 1500.0, 50500.0);
        String result = "Payroll [payrollID=1, employeeID=101, payPeriodStartDate=2023-01-01, payPeriodEndDate=2023-01-31, basicSalary=50000.0, overtimePay=2000.0, deductions=1500.0, netSalary=50500.0]";
        assertEquals(result, payroll.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Payroll payroll = new Payroll();
        payroll.setPayrollID(2);
        payroll.setEmployeeID(202);
        payroll.setPayPeriodStartDate(Date.valueOf("2023-02-01"));
        payroll.setPayPeriodEndDate(Date.valueOf("2023-02-28"));
        payroll.setBasicSalary(60000.0);
        payroll.setOvertimePay(3000.0);
        payroll.setDeductions(2000.0);
        payroll.setNetSalary(61000.0);

        assertEquals(2, payroll.getPayrollID());
        assertEquals(202, payroll.getEmployeeID());
        assertEquals(Date.valueOf("2023-02-01"), payroll.getPayPeriodStartDate());
        assertEquals(Date.valueOf("2023-02-28"), payroll.getPayPeriodEndDate());
        assertEquals(60000.0, payroll.getBasicSalary(), 0.01);
        assertEquals(3000.0, payroll.getOvertimePay(), 0.01);
        assertEquals(2000.0, payroll.getDeductions(), 0.01);
        assertEquals(61000.0, payroll.getNetSalary(), 0.01);
    }

    @Test
    public void testConstructor() {
        Payroll payroll = new Payroll();
        assertNotNull(payroll);

        Payroll payroll1 = new Payroll(3, 303, Date.valueOf("2023-03-01"), Date.valueOf("2023-03-31"), 55000.0, 2500.0, 1000.0, 56500.0);
        assertEquals(3, payroll1.getPayrollID());
        assertEquals(303, payroll1.getEmployeeID());
        assertEquals(Date.valueOf("2023-03-01"), payroll1.getPayPeriodStartDate());
        assertEquals(Date.valueOf("2023-03-31"), payroll1.getPayPeriodEndDate());
        assertEquals(55000.0, payroll1.getBasicSalary(), 0.01);
        assertEquals(2500.0, payroll1.getOvertimePay(), 0.01);
        assertEquals(1000.0, payroll1.getDeductions(), 0.01);
        assertEquals(56500.0, payroll1.getNetSalary(), 0.01);
    }
}
