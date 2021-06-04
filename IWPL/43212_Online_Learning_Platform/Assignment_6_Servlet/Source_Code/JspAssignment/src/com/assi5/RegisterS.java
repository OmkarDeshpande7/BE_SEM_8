package com.assi5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/RegisterS")
public class RegisterS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterS() {
        super();
    }
    private Connection con;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		String email = request.getParameter("emailid");
		
		String sql1 = "INSERT INTO login values(?,?,?,?,?,?,?,?,?,?)";
		String url = "jdbc:mysql://localhost:3306/assignment_login";
		String user_name = "root";
		String passworddb = "123456";
		
		
		try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		    con = DriverManager.getConnection(url,user_name,passworddb);
		    System.out.println("connecting...db");
			PreparedStatement st = con.prepareStatement(sql1);
			st.setString(1, firstname);
			st.setString(2, lastname);
			st.setString(3, phone);
			st.setString(4, username);
			st.setString(5, password);
			st.setString(6, email);
			System.out.println("connecting...");
			 st.executeUpdate();
			 
			//JOptionPane.showMessageDialog(null, "Registered Successfully");
			 
			response.sendRedirect("index.jsp");
			return;
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
