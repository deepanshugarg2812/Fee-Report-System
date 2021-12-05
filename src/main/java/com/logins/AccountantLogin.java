package com.logins;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DbQueries;

public class AccountantLogin extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		//Fetch the parameters from request
		
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
			PreparedStatement ps = con.prepareStatement(DbQueries.loginQueryAccountant);
			ps.setString(1, username);
			ps.setString(2, password);
			
			//Fetch the data in result set interface
			ResultSet rs = ps.executeQuery();
			
			
			//Using if because of bd level constraint on single primary userid
			if(rs.next()) {
				String userId = rs.getString(1);
				System.out.println("Current user is => " + userId);
				
				//Set the session
				HttpSession session = req.getSession(true);
				session.setAttribute("userid", userId);
				session.setAttribute("usertype", "accountant");
				session.setAttribute("username", username);
				
				//Send redirect to admin page
				resp.sendRedirect("accountant.jsp");
			}
			else {
				System.out.println("Error while login");
				resp.sendRedirect("index.jsp");
			}
		}
		catch(SQLException e) {
			//Redirect to same page
			System.out.println("Sql error occured");
			e.printStackTrace();
			resp.sendRedirect("index.jsp");
		}
	}
	
}
