package com.java.main;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.java.dao.EmployeeService;
import com.java.dao.FinancialRecordService;
import com.java.dao.PayrollService;
import com.java.dao.TaxService;
import com.java.model.Employee;
import com.java.model.FinancialRecord;
import com.java.model.Gender;
import com.java.model.Payroll;
import com.java.model.Tax;


public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService empService = new EmployeeService();
        PayrollService payrollService = new PayrollService();
        TaxService taxService = new TaxService();
        FinancialRecordService finService = new FinancialRecordService();

        int choice;
        do {
            System.out.println("\n*** MENU ***");
            System.out.println("\n --- Employee Details ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Get Employee by ID");
            System.out.println("4. View All Employees");
            System.out.println("\n --- Payroll Details ---");
            System.out.println("5. Generate Payroll");
            System.out.println("6. Get Payroll by ID");
            System.out.println("7. Get Payroll for Employee");
            System.out.println("8. Get Payroll for Period");
            System.out.println("\n --- Tax Details ---");
            System.out.println("9. Calculate Tax");
            System.out.println("10. Get Tax by ID");
            System.out.println("11. Get Tax for Employee");
            System.out.println("12. Get Tax for Year");
            System.out.println("\n --- Financial Record Details ---");
            System.out.println("13. Add Financial Record");
            System.out.println("14. Get Financial Record by ID");
            System.out.println("15. Get Financial Records for Employee");
            System.out.println("16. Get Financial Records for Date");
            System.out.println("17. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(sc.next());

            try {
                switch (choice) {
                    case 1:
                        Employee emp = new Employee();
                        System.out.println("Enter First Name: ");
                        emp.setFirstName(sc.next());
                        System.out.println("Enter Last Name: ");
                        emp.setLastName(sc.next());
                        System.out.println("Enter Date of Birth (yyyy-mm-dd): ");
                        emp.setDateOfBirth(Date.valueOf(sc.next()));
                        System.out.println("Enter Gender (Male/Female/Other): ");
                        emp.setGender(Gender.valueOf(sc.next().toUpperCase()));
                        System.out.println("Enter Email: ");
                        emp.setEmail(sc.next());
                        System.out.println("Enter Phone Number: ");
                        emp.setPhoneNumber(sc.next());
                        System.out.println("Enter Address: ");
                        emp.setAddress(sc.next());
                        System.out.println("Enter Position: ");
                        emp.setPosition(sc.next());
                        System.out.println("Enter Joining Date (yyyy-mm-dd): ");
                        emp.setJoiningDate(Date.valueOf(sc.next()));
                        emp.setTerminationDate(null);
                        System.out.println(empService.addEmployee(emp));
                        break;
                    case 2:
                        Employee empToUpdate = new Employee();
                        System.out.println("Enter Employee ID to update: ");
                        empToUpdate.setEmployeeID(Integer.parseInt(sc.next()));

                        System.out.println("Enter First Name: ");
                        empToUpdate.setFirstName(sc.next());
                        System.out.println("Enter Last Name: ");
                        empToUpdate.setLastName(sc.next());
                        System.out.println("Enter Date of Birth (yyyy-mm-dd): ");
                        empToUpdate.setDateOfBirth(Date.valueOf(sc.next()));
                        System.out.println("Enter Gender (Male/Female/Other): ");
                        empToUpdate.setGender(Gender.valueOf(sc.next().toUpperCase()));
                        System.out.println("Enter Email: ");
                        empToUpdate.setEmail(sc.next());
                        System.out.println("Enter Phone Number: ");
                        empToUpdate.setPhoneNumber(sc.next());
                        System.out.println("Enter Address: ");
                        empToUpdate.setAddress(sc.next());
                        System.out.println("Enter Position: ");
                        empToUpdate.setPosition(sc.next());
                        System.out.println("Enter Joining Date (yyyy-mm-dd): ");
                        empToUpdate.setJoiningDate(Date.valueOf(sc.next()));
                        empToUpdate.setTerminationDate(null); 
                        System.out.println(empService.updateEmployee(empToUpdate));
                        break;
                    case 3:
                        System.out.println("Enter Employee ID: ");
                        int idToFind = Integer.parseInt(sc.next());
                        Employee empById = empService.getEmployeeById(idToFind);
                        System.out.println(empById);
                        break;
                    case 4:
                        List<Employee> empList = empService.getAllEmployees();
                        for (Employee e : empList) {
                            System.out.println(e);
                        }
                        break;
                    case 5:
                        System.out.println("Enter Employee ID: ");
                        int empId = Integer.parseInt(sc.next());
                        System.out.println("Enter Start Date (yyyy-mm-dd): ");
                        Date sDate = Date.valueOf(sc.next());
                        System.out.println("Enter End Date (yyyy-mm-dd): ");
                        Date eDate = Date.valueOf(sc.next());
                        System.out.println("Enter Basic Salary: ");
                        double basic = Double.parseDouble(sc.next());
                        System.out.println("Enter Overtime Pay: ");
                        double ot = Double.parseDouble(sc.next());
                        System.out.println("Enter Deductions: ");
                        double ded = Double.parseDouble(sc.next());
                        System.out.println(payrollService.generatePayroll(empId, sDate, eDate, basic, ot, ded));
                        break;
                    case 6:
                        System.out.println("Enter Payroll ID: ");
                        int payrollId = Integer.parseInt(sc.next());
                        Payroll payroll = payrollService.getPayrollById(payrollId);
                        System.out.println(payroll);
                        break;
                    case 7:
                        System.out.println("Enter Employee ID: ");
                        int empPayroll = Integer.parseInt(sc.next());
                        List<Payroll> payrollList = payrollService.getPayrollsForEmployee(empPayroll);
                        for (Payroll p : payrollList) {
                            System.out.println(p);
                        }
                        break;
                    case 8:
                        System.out.println("Enter Start Date (yyyy-mm-dd): ");
                        Date start = Date.valueOf(sc.next());
                        System.out.println("Enter End Date (yyyy-mm-dd): ");
                        Date end = Date.valueOf(sc.next());
                        List<Payroll> payrollsInPeriod = payrollService.getPayrollsForPeriod(start, end);
                        for (Payroll p : payrollsInPeriod) {
                            System.out.println(p);
                        }
                        break;
                    case 9:
                        System.out.println("Enter Employee ID: ");
                        int empTax = Integer.parseInt(sc.next());
                        System.out.println("Enter Tax Year: ");
                        int taxYear = Integer.parseInt(sc.next());
                        System.out.println(taxService.calculateTax(empTax, taxYear));
                        break;
                    case 10:
                        System.out.println("Enter Tax ID: ");
                        int taxId = Integer.parseInt(sc.next());
                        Tax tax = taxService.getTaxById(taxId);
                        System.out.println(tax);
                        break;
                    case 11:
                        System.out.println("Enter Employee ID: ");
                        int empTaxList = Integer.parseInt(sc.next());
                        List<Tax> taxes = taxService.getTaxesForEmployee(empTaxList);
                        for (Tax t : taxes) {
                            System.out.println(t);
                        }
                        break;
                    case 12:
                        System.out.println("Enter Tax Year: ");
                        int year = Integer.parseInt(sc.next());
                        List<Tax> taxList = taxService.getTaxesForYear(year);
                        for (Tax t : taxList) {
                            System.out.println(t);
                        }
                        break;
                    case 13:
                        System.out.println("Enter Employee ID: ");
                        int empRec = Integer.parseInt(sc.next());
                        System.out.println("Enter Description: ");
                        String desc = sc.next();
                        System.out.println("Enter Amount: ");
                        double amt = Double.parseDouble(sc.next());
                        System.out.println("Enter Record Type (Income / Expense / Tax Payment): ");
                        String type = sc.next();
                        System.out.println(finService.addFinancialRecord(empRec, desc, amt, type));
                        break;
                    case 14:
                        System.out.println("Enter Financial Record ID: ");
                        int recId = Integer.parseInt(sc.next());
                        FinancialRecord recordById = finService.getFinancialRecordById(recId);
                        System.out.println(recordById);
                        break;
                    case 15:
                        System.out.println("Enter Employee ID: ");
                        int empView = Integer.parseInt(sc.next());
                        List<FinancialRecord> records = finService.getFinancialRecordsForEmployee(empView);
                        for (FinancialRecord fr : records) {
                            System.out.println(fr);
                        }
                        break;
                    case 16:
                        System.out.println("Enter Record Date (yyyy-mm-dd): ");
                        Date recordDate = Date.valueOf(sc.next());
                        List<FinancialRecord> recordsByDate = finService.getFinancialRecordsForDate(recordDate);
                        if (recordsByDate.isEmpty()) {
                            System.out.println("No financial records found for the given date.");
                        } else {
                            for (FinancialRecord fr : recordsByDate) {
                                System.out.println(fr);
                            }
                        }
                        break;
                    case 17:
                        System.out.println("Exited..");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 17);
        sc.close();
    }
	

}
