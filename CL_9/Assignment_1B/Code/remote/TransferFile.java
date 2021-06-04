import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.*; 
import java.rmi.server.*; 


public class TransferFile extends UnicastRemoteObject 
                         implements Transfer 
{ 
    
    TransferFile() throws RemoteException 
    { 
        super(); 
    } 
  
     
    public String transfer(String str) 
                       throws Exception
    { 
    	String[] temp = str.split("###",2);
    	File obj = new File(temp[0]);
        
		if(obj.createNewFile()) {
			String str;
			FileWriter fileWrite = new FileWriter(temp[0]);
		
			fileWrite.write(temp[1]);         
			
			fileWrite.close();
			}
		return "Done";
    } 
}