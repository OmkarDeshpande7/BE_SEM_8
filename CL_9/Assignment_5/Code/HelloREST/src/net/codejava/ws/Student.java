package net.codejava.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.*;

import org.json.JSONArray;
import org.json.JSONObject;

@Path("/student")
public class Student {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getlist() {

    	try{  
    		  
    		List<HashMap<String, String>> obj1 = new ArrayList<HashMap<String, String>>();
    	 
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");  
    		Connection con=DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/assignment_login","root","123456");  
    		//here assignment_login is database name, root is username and password  
    		Statement stmt=con.createStatement();  
    		ResultSet rs=stmt.executeQuery("select * from students;");  
    		while(rs.next())
    		{
    			
			HashMap<String, String> obj = new HashMap<>();


			obj.put("id", rs.getString(1));
			obj.put("fname", rs.getString(2));
			obj.put("lname", rs.getString(3));
			obj.put("course", rs.getString(4));
			obj1.add(obj); 
    		}
    		 
      	    con.close();
	      	System.out.println(obj1);
      	    return Response
      	    		.status(200)
      	    		.header("Access-Control-Allow-Origin", "*")
      	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
      	            .header("Access-Control-Allow-Credentials", "true")
      	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
      	            .header("Access-Control-Max-Age", "1209600")
      	            .entity(obj1)
      	            .build();
    			
    	
    		
    		}catch(Exception e){ System.out.println(e);
    		 JSONArray obj1 = new JSONArray();
    		 obj1.put(1,"failure");
    		 
    		}
    	
		List<HashMap<String, String>> obj1 = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> obj = new HashMap<>();
		obj.put("status", "fail");		
		obj1.add(obj);
   	 
   	 return Response
	    		.status(200)
	    		.header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(obj1)
	            .build();

    }
	
	

}
