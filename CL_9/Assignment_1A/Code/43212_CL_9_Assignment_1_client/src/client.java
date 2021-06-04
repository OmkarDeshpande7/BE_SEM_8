import java.net.*;
import java.util.Scanner;
import java.io.*;
public class client   
{
  public static void main( String args[ ] ) throws Exception
  {
     Socket sock = new Socket( "127.0.0.1", 4000);

                   // reading the file name from keyboard. Uses input stream
     System.out.print("Enter the file name : ");
     BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
     String fname = keyRead.readLine();
                                         
	        // sending the file name to server. Uses PrintWriter
     OutputStream  ostream = sock.getOutputStream( );
     PrintWriter pwrite = new PrintWriter(ostream, true);
     pwrite.println(fname);  
     
     File obj = new File(fname);
     // reading file contents
	if(obj.exists()) {
	String str;
	
	Scanner fileRead = new Scanner(obj);
		
		while(fileRead.hasNextLine()) // reading line-by-line from file
		{
		str = fileRead.nextLine();  
		System.out.println(str);
		pwrite.println(str);
		}
		fileRead.close();
	}
	else {
		System.out.println("Cannot read file !");
	}
	
          	          // receiving the contents from server.  Uses input stream
//     InputStream istream = sock.getInputStream();
//     BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
     
//     String str;
//     while((str = socketRead.readLine())  !=  null) // reading line-by-line 
//     { 
//         System.out.println(str);          
//     } 
     pwrite.close(); keyRead.close();
     sock.close();
  }
}