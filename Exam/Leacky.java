import java.util.Scanner;
import java.util.Random;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the bucket size: ");
        int bucketSize = scanner.nextInt();
        
        System.out.print("Enter the output rate: ");
        int outputRate = scanner.nextInt();
        
        System.out.print("Enter the number of seconds to simulate: ");
        int numSeconds = scanner.nextInt();
        
        Random random = new Random();
        int packetsRemaining = 0;
        
        System.out.println("Seconds | Packet received | Packet sent | Packets left | Packets dropped");
        System.out.println("------------------------------------------------------------------------");
        
        for (int i = 1; i <= numSeconds; i++) {
            int packetsReceived = random.nextInt(1000);
            packetsRemaining += packetsReceived;
            
            int packetsSent = Math.min(packetsRemaining, outputRate);
            int packetsDropped = Math.max(0, packetsRemaining - bucketSize);
            packetsRemaining = Math.min(bucketSize, packetsRemaining);
            packetsRemaining -= packetsSent;
            
            System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%d%n", i, packetsReceived, packetsSent, packetsRemaining, packetsDropped);
        }
        
        while (packetsRemaining != 0) {
            int packetsSent = Math.min(packetsRemaining, outputRate);
            int packetsDropped = Math.max(0, packetsRemaining - bucketSize);
            packetsRemaining = Math.min(bucketSize, packetsRemaining);
            packetsRemaining -= packetsSent;
            
            System.out.printf("-\t\t-\t\t%d\t\t%d\t\t%d%n", packetsRemaining, packetsDropped);
        }
    }
}



// Enter the bucket size: 10
// Enter the output rate: 4
// Enter the number of seconds to simulate: 10
// Seconds | Packet received | Packet sent | Packets left | Packets dropped
// ------------------------------------------------------------------------
//   1		          50		            4		            6		            40
//   2		          29		            4  		          6            		25
//   3		          93            		4            		6	            	89
//   4		          3              		4            		5	            	0
//   5	           	57	            	4            		6	             	52
//   6		          25	            	4            		6            		21
//   7		          86	             	4	            	6	             	82
//   8		          64	            	4	            	6	            	60
//   9		          34	            	4            		6	            	30
//   10		          78	  	          4	            	6            		74
