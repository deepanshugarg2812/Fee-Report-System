package com.logins;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutUsers extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		//Delete the session
		req.getSession().invalidate();
		resp.sendRedirect("index.jsp");
	}

}
