package com.java;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.model.Tax;

public class TaxTest {

	 @Test
	    public void testToString() {
	        Tax tax = new Tax(1, 101, 2024, 750000.0, 75000.0);
	        String result = "Tax [taxID=1, employeeID=101, taxYear=2024, taxableIncome=750000.0, taxAmount=75000.0]";
	        assertEquals(result, tax.toString());
	    }

	    @Test
	    public void testGettersAndSetters() {
	        Tax tax = new Tax();
	        tax.setTaxID(2);
	        tax.setEmployeeID(202);
	        tax.setTaxYear(2023);
	        tax.setTaxableIncome(850000.0);
	        tax.setTaxAmount(85000.0);

	        assertEquals(2, tax.getTaxID());
	        assertEquals(202, tax.getEmployeeID());
	        assertEquals(2023, tax.getTaxYear());
	        assertEquals(850000.0, tax.getTaxableIncome(), 0.01);
	        assertEquals(85000.0, tax.getTaxAmount(), 0.01);
	    }

	    @Test
	    public void testConstructor() {
	        Tax tax = new Tax();
	        assertNotNull(tax);

	        Tax tax1 = new Tax(3, 303, 2022, 900000.0, 90000.0);
	        assertEquals(3, tax1.getTaxID());
	        assertEquals(303, tax1.getEmployeeID());
	        assertEquals(2022, tax1.getTaxYear());
	        assertEquals(900000.0, tax1.getTaxableIncome(), 0.01);
	        assertEquals(90000.0, tax1.getTaxAmount(), 0.01);
	    }

}
