package com.login.Dao;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LoginDao {
	String sql1 = "select * from login where phone=? and password=?";
	String url = "jdbc:mysql://localhost:3306/assignment_login";
	String username = "root";
	String password = "123456";
	private Connection con;	
	public boolean check(HttpServletRequest request, String uname,String pass)
	{
	
		try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		    con = DriverManager.getConnection(url,username,password);
		    System.out.println("reaching mysql");
			PreparedStatement st = con.prepareStatement(sql1);
			st.setString(1, uname);
			st.setString(2, pass);
			System.out.println("connecting...");
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
			System.out.println("user found !");
			HttpSession session = request.getSession();
			session.setAttribute("fname",rs.getString(2));
			session.setAttribute("lname",rs.getString(3));
				return true;
			}
			System.out.println("no user");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
