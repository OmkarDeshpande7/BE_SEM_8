import java.net.*;    
import java.io.File;
import java.io.*;
public class server   
{
  public static void main(String args[]) throws Exception
  {                           // establishing the connection with the server
     ServerSocket sersock = new ServerSocket(4000);
     System.out.println("Server ready for connection");
     Socket sock = sersock.accept();            // binding with port: 4000
     System.out.println("Connection is successful and wating for filename : ");
                                                                                                 
                               // reading the file name from client
     InputStream istream = sock.getInputStream( );
     BufferedReader fileRead =new BufferedReader(new InputStreamReader(istream));
     String fname = fileRead.readLine( );
     
     File obj = new File(fname);
                             // reading file contents
     if(obj.createNewFile()) {
     String str;
     FileWriter fileWrite = new FileWriter(fname);
     while((str = fileRead.readLine()) !=  null) // reading line-by-line from file
     {
//    	System.out.println(str);
    	fileWrite.write(str);         // sending each line to client
     }
     fileWrite.close();
     System.out.println("File Successfully Transferred !");
     }
     else {
    	 System.out.println("Cannot create File !");
     }
     
     sock.close();  sersock.close();       // closing network sockets

      fileRead.close(); 
  }
}