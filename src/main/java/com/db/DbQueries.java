package com.db;

public class DbQueries {
	
	//Login queries
	public static String loginQueryAdmin = "select userid from users where username = ? and password = ? and usertype = 'admin';";
	public static String loginQueryAccountant = "select userid from users where username = ? and password = ? and usertype = 'accountant';";
	
	
	//Add accountant query
	public static String addAccountantQuery = "insert into users values(?,?,?,'accountant');";
	
	//Get number of accountant
	public static String getCountOfAccountant = "select count(*) from users where usertype='accountant';";
	
	//Get accountant list 
	public static String getAccountantList = "select * from users where usertype='accountant' limit ?,?;";
	
	//Insert student
	public static String addStudent = "insert into students(name,email,gender,course,feetotal,feepaid,feedue,address,phone) values(?,?,?,?,?,?,?,?,?);";
	
	//Fetch all students
	public static String viewStudent = "select * from students;";
	
	public static String deleteStudent = "delete from students where id = ?;";
	
	//Select particular student
	public static String fetchStudent = "select * from students where id = ?;";
	
	//Update the students details
	public static String updateStudent = "update students set name = ? , email = ?, gender = ?,course = ?, feetotal = ? ,feepaid = ?,feedue = ?,address = ? ,phone = ? where id = ?;";
}
