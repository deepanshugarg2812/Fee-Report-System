package com.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DbQueries;

public class ViewStudents extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		
		try {
			//Get the Db connection
			Connection con = (Connection)req.getServletContext().getAttribute("DBObj");
			
			//check if connection is valid 
			if(con==null) {
				resp.sendRedirect("DbError.jsp");
			}
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(DbQueries.viewStudent);
			
			ArrayList<Student> ar = new ArrayList<Student>();
			
			while(rs.next()) {
				Student student = new Student(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getInt(6) , rs.getInt(7) , rs.getInt(8) , rs.getString(9) , rs.getString(10));
				ar.add(student);
			}
			
			RequestDispatcher rd = req.getRequestDispatcher("viewStudent.jsp");
			req.setAttribute("list", ar);
			rd.forward(req,resp);
		}
		catch(SQLException e) {
			//Redirect to same page
			System.out.println("Sql error occured");
			
			RequestDispatcher rd = req.getRequestDispatcher("viewStudent.jsp");
			req.setAttribute("error", e.getMessage());
			rd.forward(req,resp);
		}
	}

}
