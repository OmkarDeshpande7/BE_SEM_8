import java.rmi.*;
public interface Transfer extends Remote 
{ 
    // Declaring the method prototype 
    public String transfer(String filename) throws Exception; 
} 