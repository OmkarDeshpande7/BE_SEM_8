<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Welcome</title>
  </head>
  <style>
    h1 {
      text-align: center;
    }

    html {
      background: url(bg1.jpg) no-repeat center fixed;
      background-size: cover;
    }
  </style>

  <body>
    <%
    response.setHeader("cache-control","no-cache,no-store,must-revalidate");//http
    response.setHeader("Pragma", "no-cache");//1.0
    response.setHeader("Expires", "0");//proxies
    if(session.getAttribute("fname")==null)
    response.sendRedirect("index.jsp"); %>
    <h1>Welcome ${fname} ${lname} </h1>

    <form action="Logout">
      <input type="submit" value="Logout" />
    </form>
  </body>
</html>
