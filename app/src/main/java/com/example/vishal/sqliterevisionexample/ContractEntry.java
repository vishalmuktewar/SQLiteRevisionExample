package com.example.vishal.sqliterevisionexample;

public class ContractEntry {
    public static final String DATABASE_NAME = "upshot_revision";
    public static final int VERSION = 1;
    public static final String ID = "id";
    public static final String TABLE_NAME = "Contract";
    public static final String EMPLOYEE_NAME = "Emp_Name";
    public static final String EMPLOYEE_PHONE_NUMBER = "Emp_Phone";
    public static final String EMPLOYEE_SALARY = "Emp_Salary";
    public static final String EMPLOYEE_ADDRESS = "Emp_Address";


    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( " + ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                            + EMPLOYEE_NAME + " TEXT," + EMPLOYEE_PHONE_NUMBER + " TEXT,"
                                            + EMPLOYEE_SALARY + " TEXT," + EMPLOYEE_ADDRESS + " TEXT )";

}
