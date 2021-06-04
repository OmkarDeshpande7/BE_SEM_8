import java.util.Scanner;

class Process{
	public int id;
	public boolean active;

	public Process(int id){
		this.id=id;
		active=true;
	}

	}
public class Ring{
	int noOfProcesses;
	Process[] processes;
	Scanner sc;

	public Ring(){
		sc=new Scanner(System.in);
	}
	public void initialiseRing(){
		System.out.println("Enter no of processes");
		noOfProcesses=sc.nextInt();
		processes = new Process[noOfProcesses];
		for(int i=0;i<processes.length;i++){
			processes[i]= new Process(i);
		}
	}

	public int getMax(){
		int maxId=-99;
		int maxIdIndex=0;
		for(int i=0;i<processes.length;i++){
			if(processes[i].active && processes[i].id>maxId){
				maxId=processes[i].id;
				maxIdIndex=i;
		}
		}
		return maxIdIndex;
	}

	public void performElection(){
		if (processes[getMax()].id == 0){
			System.out.println("No processes left.");
			return;
		}
		System.out.println("Process "+ (processes[getMax()].id + 1) + " is Leader.");
		System.out.println("Assume Process no " + (processes[getMax()].id + 1) +" fails");
		processes[getMax()].active=false;
		System.out.println("Enter Election Initiated by process : ");
		int initiatorProcesss=sc.nextInt();

		int prev = initiatorProcesss-1;
		int next = prev+1;

		while(true){
			if(processes[next].active){
			System.out.println("Process "+ (processes[prev].id + 1) +" pass Election("+ (processes[prev].id + 1) +") to " + (processes[next].id + 1));
			prev=next;
			}

		next = (next+1)%noOfProcesses;
		if(next == initiatorProcesss-1){
			System.out.println("Process "+ (processes[prev].id + 1) +" pass Election("+ (processes[prev].id + 1) +") to " + (processes[next].id + 1));

			break;
		}
		}

		System.out.println("Process "+ (processes[getMax()].id + 1) + " becomes coordinator");
		int coordinator = processes[getMax()].id;

		prev = coordinator;
		next =(prev+1)%noOfProcesses;

		while(true){

			if(processes[next].active)
			{
			System.out.println("Process "+ (processes[prev].id + 1) +" pass Coordinator("+ (coordinator + 1) + ") message to process "+ (processes[next].id + 1)  );
			prev = next;
			}
			next = (next+1) % noOfProcesses;
			if(next == coordinator)
			{
			System.out.println("End Of Election ");
			break;
			}
		}

	}

	public static void main(String arg[]){
		Scanner sc=new Scanner(System.in);
		Ring r= new Ring();
		r.initialiseRing();
		while(true){
		System.out.println("1. Election\n2. Exit");
		int choice = sc.nextInt();
		switch(choice){
		case(1):
			r.performElection();
			break;
		case(2):
			return;
		default:
			return;
		}
		}	
	}

}