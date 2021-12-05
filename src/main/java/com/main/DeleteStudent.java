package com.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DbQueries;

public class DeleteStudent extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		try {
			//Get the Db connection
			Connection con = (Connection)req.getServletContext().getAttribute("DBObj");
			
			//check if connection is valid 
			if(con==null) {
				resp.sendRedirect("DbError.jsp");
			}
			
			//Create a prepared statement
			PreparedStatement ps = con.prepareStatement(DbQueries.deleteStudent);
			ps.setInt(1, id);
			
			ps.execute();
			
			resp.sendRedirect("viewstudents");
		}
		catch(SQLException e) {
			//Redirect to same page
			System.out.println("Sql error occured");
			
			resp.sendRedirect("viewstudents");
		}
	}

}