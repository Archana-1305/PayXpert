package com.java;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.java.model.Employee;
import com.java.model.Gender;

public class EmployeeTest {

	@Test
	public void testToString() {
		Employee emp = new Employee(1, "Archana", "GV", Date.valueOf("2000-01-01"), Gender.FEMALE,
				"archana@gmail.com", "9876543210", "Chennai", "Developer",
				Date.valueOf("2020-06-01"), Date.valueOf("2024-12-31"));
		String result = "Employee [employeeID=1, firstName=Archana, lastName=GV, dateOfBirth=2000-01-01, gender=FEMALE, email=archana@gmail.com, phoneNumber=9876543210, address=Chennai, position=Developer, joiningDate=2020-06-01, terminationDate=2024-12-31]";
		assertEquals(result, emp.toString());
	}

	@Test
	public void testGettersAndSetters() {
		Employee emp = new Employee();
		emp.setEmployeeID(2);
		emp.setFirstName("Aravind");
		emp.setLastName("Kumar");
		emp.setDateOfBirth(Date.valueOf("1999-12-31"));
		emp.setGender(Gender.MALE);
		emp.setEmail("aravind@gmail.com");
		emp.setPhoneNumber("9123456789");
		emp.setAddress("Mumbai");
		emp.setPosition("Engineer");
		emp.setJoiningDate(Date.valueOf("2022-01-01"));
		emp.setTerminationDate(Date.valueOf("2025-01-01"));

		assertEquals(2, emp.getEmployeeID());
		assertEquals("Aravind", emp.getFirstName());
		assertEquals("Kumar", emp.getLastName());
		assertEquals(Date.valueOf("1999-12-31"), emp.getDateOfBirth());
		assertEquals(Gender.MALE, emp.getGender());
		assertEquals("aravind@gmail.com", emp.getEmail());
		assertEquals("9123456789", emp.getPhoneNumber());
		assertEquals("Mumbai", emp.getAddress());
		assertEquals("Engineer", emp.getPosition());
		assertEquals(Date.valueOf("2022-01-01"), emp.getJoiningDate());
		assertEquals(Date.valueOf("2025-01-01"), emp.getTerminationDate());
	}

	@Test
	public void testConstructor() {
		Employee emp = new Employee();
		assertNotNull(emp);
		Employee emp1 = new Employee(3, "Dev", "Sharma", Date.valueOf("1998-03-15"), Gender.MALE,
				"dev.sharma@gmail.com", "9000000000", "Delhi", "Tester",
				Date.valueOf("2021-09-01"), Date.valueOf("2023-12-31"));

		assertEquals(3, emp1.getEmployeeID());
		assertEquals("Dev", emp1.getFirstName());
		assertEquals("Sharma", emp1.getLastName());
		assertEquals(Date.valueOf("1998-03-15"), emp1.getDateOfBirth());
		assertEquals(Gender.MALE, emp1.getGender());
		assertEquals("dev.sharma@gmail.com", emp1.getEmail());
		assertEquals("9000000000", emp1.getPhoneNumber());
		assertEquals("Delhi", emp1.getAddress());
		assertEquals("Tester", emp1.getPosition());
		assertEquals(Date.valueOf("2021-09-01"), emp1.getJoiningDate());
		assertEquals(Date.valueOf("2023-12-31"), emp1.getTerminationDate());
	}
}
