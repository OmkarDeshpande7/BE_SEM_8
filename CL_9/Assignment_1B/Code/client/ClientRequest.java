//program for client application 
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.rmi.*;
import java.util.Scanner; 
public class ClientRequest 
{ 
	public static void main(String args[]) 
	{ 
		String answer,str = null; 
		try
		{ 
			System.out.print("Enter the file name : ");
			BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
			String fname = keyRead.readLine();
			File obj = new File(fname);
			
			if(obj.exists()) {
			str=fname + "###";
			
			Scanner fileRead = new Scanner(obj);
				
				while(fileRead.hasNextLine()) 
				{
				str += fileRead.nextLine();  
				}
				fileRead.close();
			}
			else
				System.out.println("File does not exist !");
			Transfer access = (Transfer)Naming.lookup("rmi://localhost:1900"+ "/getTransferFunc"); 
			
			answer = access.transfer(str); 
			System.out.println(answer);

		} 
		catch(Exception ae) 
		{ 
			System.out.println(ae); 
		} 
	} 
} 
