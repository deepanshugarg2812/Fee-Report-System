package com.listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DbObjectCreation implements ServletContextListener{
	
	Connection con = null;
	ServletContext sc;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		this.sc = sce.getServletContext();
		
		String connectionString = this.sc.getInitParameter("connectionstring");
		String username = this.sc.getInitParameter("username");
		String password = this.sc.getInitParameter("password");
		
		try {
			con = DriverManager.getConnection(connectionString,username,password);
			this.sc.setAttribute("DBObj", con);
			System.out.println("Database connection successfully obtained");
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Error while connecting to the database");
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if(con!=null) {
			try {
				con.close();
				System.out.println("Closed the DB connection");
			}
			catch(SQLException e) {
				System.out.println("Error while closeing the connection to DB");
			}
		}
		else {
			System.out.println("Connection was not established previosly");
		}
	}

}
