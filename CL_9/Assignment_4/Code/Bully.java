import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Bully 
{
    static boolean[] state = new boolean[5];
    static int coordinator;

    public static void up(int up)//4 
    {
        if (state[up - 1])// 0 1 2 3 4 
        {
            System.out.println("PROCESS " + up + " IS ALREADY UP");
        } 
        else 
        {
            int i;
            Bully.state[up - 1] = true;
            System.out.println("PROCESS " + up + "HELD ELECTION");
            if (up > Bully.coordinator){
                System.out.println(up + " ELECTED ITSELF AS CO-ORDINATOR.");
                Bully.coordinator = up;
                return;
            }
            for (i = up+1; i <= 5; i++) 
            {
                System.out.println("ELECTION MESSAGE SENT FROM PROCESS " + up + " TO PROCESS " + i );
            }
            for (i = 5; i >= up; i--) 
            {
                if (!state[i - 1]) continue;
                System.out.println("ALIVE MESSAGE SENT FROM PROCESS " + i + " TO PROCESS" + up);
                break;
            }
        }
        System.out.println("PROCESS " + Bully.coordinator + " IS CO-ORDINATOR.");
    }

    public static void down(int down)
    {
        if (!state[down - 1])
        {
            System.out.println("PROCESS " + down + " IS ALREADY DOWN.");
        } 
        else 
        {
            Bully.state[down - 1] = false;
        }
        if (Bully.coordinator==down){
            Bully.coordinator=Integer.MIN_VALUE;
        }
    }

    public static void mess(int mess) 
    {
        if (state[mess - 1])
        {
            if (Bully.coordinator > mess) 
            {
                System.out.println("CO-ORDINATOR IS " + Bully.coordinator);
            } 
            else 
            {
                int i;
                System.out.println("PROCESS " + mess + " HELD ELECTION.");
                for (i = mess; i < 5; ++i) 
                {
                    System.out.println("ELECTION MESSAGE SENT FROM PROCESS " + mess + " TO PROCESS " + (i + 1));
                }
                for (i = 5; i >= mess; i--) 
                {
                    if (!state[i - 1]) continue;
                    System.out.println("CO-ORDINATOR MESSAGE SENT FROM PROCESS " + i + " TO ALL.");
                    Bully.coordinator=i;
                    break;
                }
            }
        } 
        else 
        {
            System.out.println("Prccess " + mess + " is down");
            Bully.up(mess);
        }
    }

    public static void main(String[] args) 
    {
        int choice;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; ++i) 
        {
            Bully.state[i] = true;
        }
        Bully.coordinator = 5;
        System.out.println("Process 5 is coordinator");
        do 
        {
            System.out.println("1. BRING PROCESS UP");
            System.out.println("2. BRING PROCESS DOWN");
            System.out.println("3. SEND A MESSAGE");
            System.out.println("4. EXIT");
            choice = sc.nextInt();
            switch (choice) 
            {
                case 1: 
                {
                    System.out.println("ENTER PROCESS NUMBER");
                    int up = sc.nextInt();
                    if (up == Bully.coordinator) 
                    {
                        System.out.println("Process " + up + " is co-ordinator");
                        Bully.state[Bully.coordinator-1] = true;
                        break;
                    }
                    Bully.up(up);
                    break;
                }
                
                case 2: 
                {
                    System.out.println("ENTER PROCESS NUMBER - ");
                    int down = sc.nextInt();
                    Bully.down(down);
                    break;
                }
                case 3: 
                {
                    System.out.println("ENTER PROCESS NUMBER - ");
                    int mess = sc.nextInt();
                    Bully.mess(mess);
                }
            }
        } while (choice != 4);
    }
}
