DROP DATABASE IF EXISTS PayXpert;
Create Database PayXpert;
Use PayXpert;

Create Table Employee (
    EmployeeID Int Primary Key Auto_Increment,
    FirstName Varchar(50) Not Null,
    LastName Varchar(50) Not Null,
    DateOfBirth Date Not Null,
    Gender Enum('Male', 'Female', 'Other') Not Null,
    Email Varchar(100) Unique Not Null,
    PhoneNumber Varchar(15) Unique Not Null,
    Address Text Not Null,
    Position Varchar(100) Not Null,
    JoiningDate Date Not Null,
    TerminationDate Date Null
);
Create Table Payroll (
    PayrollID Int Primary Key Auto_Increment,
    EmployeeID Int Not Null,
    PayPeriodStartDate Date Not Null,
    PayPeriodEndDate Date Null,
    BasicSalary Decimal(10,2) Not Null,
    OvertimePay Decimal(10,2) Default 0.00,
    Deductions Decimal(10,2) Default 0.00,
    NetSalary Decimal(10,2) Default 0.00,
    Foreign Key (EmployeeID) References Employee(EmployeeID) On Delete Cascade
);

Create Table Tax (
    TaxID Int Primary Key Auto_Increment,
    EmployeeID Int Not Null,
    TaxYear Year Not Null,
    TaxableIncome Decimal(10,2) Null,
    TaxAmount Decimal(10,2) Null,
    Foreign Key (EmployeeID) References Employee(EmployeeID) On Delete Cascade
);

Create Table FinancialRecord (
    RecordID Int Primary Key Auto_Increment,
    EmployeeID Int Not Null,
    RecordDate Date Not Null,
    Description Varchar(255) Not Null,
    Amount Decimal(10,2) Not Null,
    RecordType Enum('Income', 'Expense', 'Tax Payment') Not Null,
    Foreign Key (EmployeeID) References Employee(EmployeeID) On Delete Cascade
);

