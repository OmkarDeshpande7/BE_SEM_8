//program for server application 
import java.rmi.*; 
import java.rmi.registry.*; 
public class Server 
{ 
	public static void main(String args[]) 
	{ 
		try
		{ 
			
			Transfer obj = new TransferFile(); 

			// rmiregistry within the server JVM with 
			// port number 1900 
			LocateRegistry.createRegistry(1900); 

			
			Naming.rebind("rmi://localhost:1900"+ 
						"/getTransferFunc",obj); 
		} 
		catch(Exception ae) 
		{ 
			System.out.println(ae); 
		} 
	} 
} 
