package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentVO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection con=null;
	public void init() {
		final String Db_name = "greattug_gw_pratice_CD";
		final String userName = "greattug_pratice";
		final String password = "Test1234##";
		final String port = "3306";
		final String ip = "103.50.160.116";
		final String url = "jdbc:mysql://" + ip + ":" + port + "/" + Db_name;
		final String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(jdbc_driver);
			con = DriverManager.getConnection(url, userName, password);
	 } catch (SQLException e1) {
			e1.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		try
		{
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery("select *from StudentData");
		while(rs.next())
		{
			pw.println(rs.getString(1));
			pw.println(rs.getString(2));
			pw.println(rs.getString(3));
			pw.println(rs.getString(4));
			pw.println(rs.getString(5));
			pw.println("<br>");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
