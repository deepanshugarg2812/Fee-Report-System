package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import com.db.DbQueries;

public class ViewAccountant{
	//Connection ob of db
	Connection con = null;
	
	int currIndex = 0;
	int offset = 5;
	int count = 0;
	
	public void getConnection(ServletContext sc) {
		con = (Connection) sc.getAttribute("DBObj");
		
		if(con==null) {
			System.out.println("SQL error occured");
		}
	}
	
	public void getNoOfPages() {
		if(con==null) {
			return;
		}
		
		Statement ps;
		
		try {
			ps = con.createStatement();
			ResultSet rs = ps.executeQuery(DbQueries.getCountOfAccountant);
			
			if(rs.next()) {
				System.out.println(rs.getInt(1));
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL error occured");
		}
	}
	
	public ArrayList<Accountant> getAccountant() {
		if(con==null) {
			return null;
		}
		
		ArrayList<Accountant> arr = new ArrayList<Accountant>();
		
		try {
			PreparedStatement ps = con.prepareStatement(DbQueries.getAccountantList);
			ps.setInt(1, currIndex);
			ps.setInt(2, currIndex + offset);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Accountant ac = new Accountant();
				ac.accountantId = rs.getString(1);
				ac.accountantUsername = rs.getString(2);
				
				arr.add(ac);
			}
			
			currIndex += offset + 1;
		}catch(SQLException e) {
			System.out.println("SQL error occured");
		}
		
		return arr;
	}
}
