package com.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DbQueries;

public class AddStudent extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		//Fetch the parameters from request
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("customRadio");
		String course = req.getParameter("course");
		int feeTotal = Integer.parseInt(req.getParameter("fee"));
		int feePaid = Integer.parseInt(req.getParameter("paid"));
		int feeDue = Integer.parseInt(req.getParameter("due"));
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		
		try {
			//Get the Db connection
			Connection con = (Connection)req.getServletContext().getAttribute("DBObj");
			
			//check if connection is valid 
			if(con==null) {
				resp.sendRedirect("DbError.jsp");
			}
			
			//Create a prepared statement
			PreparedStatement ps = con.prepareStatement(DbQueries.addStudent);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, gender);
			ps.setString(4, course);
			ps.setInt(5, feeTotal);
			ps.setInt(6, feePaid);
			ps.setInt(7, feeDue);
			ps.setString(8, address);
			ps.setString(9, phone);
			
			ps.execute();
			
			resp.sendRedirect("viewstudents");
		}
		catch(SQLException e) {
			//Redirect to same page
			System.out.println("Sql error occured");
			
			RequestDispatcher rd = req.getRequestDispatcher("addStudent.jsp");
			req.setAttribute("error", e.getMessage());
			rd.forward(req,resp);
		}
	}

}
