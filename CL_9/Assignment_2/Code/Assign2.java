import mpi.*;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
public class Assign2{
	public static void main(String args[]) throws Exception{
		MPI.Init(args);
		int id = MPI.COMM_WORLD.Rank()+1, token1;
		int size = MPI.COMM_WORLD.Size();
		Random rand = new Random(); 
		List<Integer> temp = new ArrayList<Integer>();
		
		Scanner inFile1 = new Scanner(new File("file"+id+".txt"));
		Scanner ansFile = new Scanner(new File("ansFile.txt"));
		//Thread.sleep(200);
		Thread.sleep(rand.nextInt(200));
		while (inFile1.hasNext()) {

		token1 = Integer.parseInt(inFile1.next());
		temp.add(token1);
		}
		inFile1.close();
		//Thread.sleep(200);
		token1 = Integer.parseInt(ansFile.next());
		int ans = token1 + temp.get(0) + temp.get(1);
		
		
		FileWriter fileWrite = new FileWriter("ansFile.txt");
		
		fileWrite.write(ans+" ");         
		
		fileWrite.close();
			

   	 	
			
		

		
		System.out.println("Process ID "+ id + " Added " + temp.get(0) + "," +  temp.get(1));

		System.out.println("");
		System.out.println(ans);

		MPI.Finalize();
		
	}

}

//Commands::
//export MPJ_HOME=[Path of mj express folder]
//javac -cp $MPJ_HOME/lib/mpj.jar Assign2.java
//$MPJ_HOME/bin/mpjrun.sh -np [no. of machines to be created] Assign2 
