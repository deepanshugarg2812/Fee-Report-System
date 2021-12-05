package com.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DbQueries;

public class AddAccountant extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		//Fetch the parameters from request
		String userid = req.getParameter("userid");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			//Get the Db connection
			Connection con = (Connection)req.getServletContext().getAttribute("DBObj");
			
			//check if connection is valid 
			if(con==null) {
				resp.sendRedirect("DbError.jsp");
			}
			
			//Create a prepared statement
			PreparedStatement ps = con.prepareStatement(DbQueries.addAccountantQuery);
			ps.setString(1, userid);
			ps.setString(2, username);
			ps.setString(3, password);
			
			ps.execute();
			
			resp.sendRedirect("viewAccountant.jsp");
		}
		catch(SQLException e) {
			//Redirect to same page
			System.out.println("Sql error occured");
			e.printStackTrace();
			resp.sendRedirect("addAccountant.jsp");
		}
	}

}
