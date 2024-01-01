import java.math.*;
import  java.util.*;
import java.util.Random;
import java.io.*;
import java.lang.*;
public class P2{
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		int drop=0,mini,i,o_rate,b_size,nsec,p_remain=0;
		int packet[]=new int[100];
		System.out.println("Enter the bucket size:");
		b_size=s.nextInt();
		System.out.println("Enter the output rate:");
		o_rate=s.nextInt();
		System.out.println("Enter the number of seconds to simulate:");
		nsec=s.nextInt();
		Random rand=new Random();
		for(i=0;i<nsec;i++)
			packet[i]=(rand.nextInt(1000));
		System.out.println("Seconds | Packet recieved | Packet sent | Packets left | Packets dropped");
		System.out.println("------------------------------------------------------------------------");
		for(i=0;i<nsec;i++){
			p_remain+=packet[i];
			if(p_remain>b_size){
				drop=p_remain-b_size;
				p_remain=b_size;
				System.out.print(i+1+"		");
				System.out.print(packet[i]+"		");
				mini=Math.min(p_remain,o_rate);
				System.out.print(mini+"		");
				p_remain=p_remain-mini;
				System.out.print(p_remain+"		");
				System.out.print(drop+"		");
				System.out.println("		");
				drop=0;
			}
		}
		while(p_remain!=0){
			if(p_remain>b_size){
				drop=p_remain-b_size;
			}
			mini=Math.min(p_remain,o_rate);
			System.out.print("		"+p_remain+"		"+mini);
			p_remain=p_remain-mini;
			System.out.println("		"+p_remain+"		"+drop);
			drop=0;
		}
	}	
}


// OUTPUT:
// Enter the bucket size:
// 10
// Enter the output rate:
// 4
// Enter the number of seconds to simulate:
// 10
// Seconds | Packet recieved | Packet sent | Packets left | Packets dropped
// ------------------------------------------------------------------------
// 1		962		4		6		952				
// 2		613		4		6		609				
// 3		670		4		6		666				
// 4		170		4		6		166				
// 5		230		4		6		226				
// 6		677		4		6		673				
// 7		405		4		6		401				
// 8		281		4		6		277				
// 9		938		4		6		934				
// 10		224		4		6		220				
// 	     6	  4		2	 	 0
// 	     2	  2		0		 0
