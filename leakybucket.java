import java.util.*;
import java.io.*;
class leakybucket {
	public static void main(String args[]) throws Exception {
		int size,rate,tno,count=0,drop,rem=0,r=0,flag=0;
		int inp[] = new int[25];		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the bucket size:");
			size=sc.nextInt();
		System.out.print("enter the output rate:");
			rate=sc.nextInt();
		System.out.print("Enter the total no. of packet:");
			tno=sc.nextInt();
		for(int i=1;i<=tno;i++) {
			System.out.print("Enter a size of packet number-"+i+":");
				inp[i]=sc.nextInt();
		}
		System.out.println("clock\t packet size\t\tAccept\t\tPacket Sent\t Packet Left");
		System.out.println("------------------------------------------------------------------------");
		for(int i=1;i<=tno;i++) {
			if(inp[i]+rem>size)
				flag=1;
			else {
				flag=0;
				if( inp[i]>rate) 
					rem=inp[i]+rem-rate;
				else {
					rem=inp[i]+rem-rate;
					if(inp[i]<rate && rem<0)
						rem=0;
					if(rem>inp[i])
						rem=rate-inp[i];
				}
			}
			if(inp[i]<rate && rem+inp[i]<rate)
				r=inp[i]+rem;
			else
				r=rate;
			if(flag==1)
				System.out.println(i+"\t\t"+inp[i]+"\t"+"\t"+"Packet Droppped"+"\t"+"0"+"\t\t"+rem);
			else
				System.out.println(i+"\t\t"+inp[i]+"\t\t"+inp[i]+"\t\t"+r+"\t\t"+rem);
		}
	}
}
