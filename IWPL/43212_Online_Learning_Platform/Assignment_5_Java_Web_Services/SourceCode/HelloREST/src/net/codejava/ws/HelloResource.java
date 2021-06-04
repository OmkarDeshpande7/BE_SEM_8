package net.codejava.ws;
import javax.ws.rs.Consumes;

//https://www.codejava.net/java-ee/web-services/java-restful-web-services-tutorial-for-beginner-with-jersey-and-tomcat
//https://www.youtube.com/watch?v=N1UzS9ojuUY&list=PLR2yPNIFMlL-dbPvTJtCYfE9TE6IwcEDf&index=3
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import org.glassfish.jersey.server.Uri;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map; 


@Path("/authenticate")
public class HelloResource {

@GET
@Produces(MediaType.APPLICATION_JSON)
public Response sayJsonHello(@PathParam("id") String id,@PathParam("pass") String pass,@Context UriInfo uriInfo) {  	
	try{  
			
JSONArray obj1 = new JSONArray();

String temp = uriInfo.getRequestUri().getQuery();

System.out.println(temp);

String[] params = temp.split("&");  
Map<String, String> map = new HashMap<String, String>();

		for (String param : params) {  
			String name = param.split("=")[0];  
			String value = param.split("=")[1];  
			map.put(name, value);  
			
			System.out.println(name+" "+value);
		}  
	
	
		System.out.print(map.get("id")+map.get("pass"));
		
		String phone = map.get("id");
		String password = map.get("pass");
		
	
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/assignment_login","root","123456");  
	//here sonoo is database name, root is username and password  
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from login where phone=\""+phone+"\"and password=\""+password+"\";");  
	if(rs.next())
	{
		
		HashMap<String, String> obj = new HashMap<String, String>();
		obj.put("ok", "yes");

		obj1.put(obj);
	
	con.close();
		
	return Response
			.status(200)
			.header("Access-Control-Allow-Origin", "*")
			.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
			.header("Access-Control-Allow-Credentials", "true")
			.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
			.header("Access-Control-Max-Age", "1209600")
			.entity(obj)
			.build();
		

	
	}
	else
	{
		
		con.close();
		HashMap<String, String> obj = new HashMap<String, String>();
			obj.put("ok", "no");
		return Response
				.status(201)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600")
				.entity(obj)
				.build();
	}
	

	
	}catch(Exception e){ System.out.println(e);
	
	HashMap<String, String> obj = new HashMap<String, String>();
	obj.put("ok", "no");
	return Response
			.status(201)
			.header("Access-Control-Allow-Origin", "*")
			.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
			.header("Access-Control-Allow-Credentials", "true")
			.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
			.header("Access-Control-Max-Age", "1209600")
			.entity(obj)
			.build();
	}

	
}


@GET
@Path("/company")
@Produces(MediaType.APPLICATION_JSON)
public java.util.List<Map<String, String>> getlist() {
	
	java.util.List<Map<String,String>> mymap1 = new ArrayList<Map<String, String>>();
	
	try{  
		
		java.util.List<Map<String,String>> mymap = new ArrayList<Map<String, String>>();
			
		Map<String,String> obj1 = new HashMap<String,String>();
		
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/login","root","");  
			
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from company;");  
		while(rs.next())
		{
			
			//JSONObject obj = new JSONObject();
			Map<String,String>obj=new HashMap<String,String>();
			
			System.out.println(obj);
			
			obj.put("name", rs.getString(2));
			obj.put("type", rs.getString(3));
			obj.put("ctc", String.valueOf(rs.getInt(4)));
			obj.put("location", rs.getString(5));
			

			mymap.add(obj);
	
			System.out.println(obj);	
		}	
		con.close();
		
		System.out.println("here");
		System.out.println(mymap);
		return mymap;

		}catch(Exception e){ System.out.println(e);
			JSONArray obj1 = new JSONArray();
			obj1.put(1,"failure");	
		}
	JSONArray obj1 = new JSONArray();
	obj1.put(1,"failure");
	return mymap1;	
}

}