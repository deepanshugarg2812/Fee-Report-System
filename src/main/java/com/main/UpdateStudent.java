package com.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DbQueries;

public class UpdateStudent extends HttpServlet{
	
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
			
			PreparedStatement ps = con.prepareStatement(DbQueries.fetchStudent);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Student> ar = new ArrayList<Student>();
			
			if(rs.next()) {
				Student student = new Student(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getInt(6) , rs.getInt(7) , rs.getInt(8) , rs.getString(9) , rs.getString(10));
				ar.add(student);
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
				req.setAttribute("error", "No result found");
				rd.forward(req,resp);
			}
			
			RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
			req.setAttribute("student", ar.get(0));
			rd.forward(req,resp);
		}
		catch(SQLException e) {
			//Redirect to same page
			System.out.println("Sql error occured");
			
			RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
			req.setAttribute("error", e.getMessage());
			rd.forward(req,resp);
		}
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		//Fetch the parameters from request
		int id = Integer.parseInt(req.getParameter("id"));
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
			PreparedStatement ps = con.prepareStatement(DbQueries.updateStudent);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, gender);
			ps.setString(4, course);
			ps.setInt(5, feeTotal);
			ps.setInt(6, feePaid);
			ps.setInt(7, feeDue);
			ps.setString(8, address);
			ps.setString(9, phone);
			ps.setInt(10,id);
			
			ps.execute();
			
			resp.sendRedirect("viewstudents");
		}
		catch(Exception e) {
			RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
			req.setAttribute("error", e.getMessage());
			rd.forward(req,resp);
		}
	}
}
