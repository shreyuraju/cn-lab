import java.util.*;
import java.io.*;
public class bellmanford{
int n=0;
	public static void main(String args[]){
	int n=0;
	int source;
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the number of vertices");
	n=sc.nextInt();
	int a[][]=new int[n+1][n+1];
	System.out.println("enter the adjacency matrix");
	for(int sn=1;sn<=n;sn++){
	for(int dn=1;dn<=n;dn++){
		a[sn][dn]=sc.nextInt();
		if(sn==dn){
			a[sn][dn]=0;
			continue;
			}
		if(a[sn][dn]==0){
			a[sn][dn]=999;
			}
		}
	}
	for(int sn=1;sn<=n;sn++){
	for(int dn=1;dn<=n;dn++){
	System.out.print(a[sn][dn]);
	}
	System.out.println();
	}
	System.out.println("enter the source vertex");
	source=sc.nextInt();
	bellmanford bf=new bellmanford(n);
	bf.evaluation(source,a);
	sc.close();
	}
	private int distance[];
	public bellmanford(int n){
		this.n=n;
		distance=new int[n+1];
		}
	public void evaluation(int source,int a[][]){
		for(int node=1;node<=n;node++){
			distance[node]=999;
			}
			distance[source]=0;
		for(int node=1;node<=n;node++){
		for(int sn=1;sn<=n;sn++){
		for(int dn=1;dn<=n;dn++){
			if(a[sn][dn]!=999)
			{
				if(distance[dn]>distance[sn]+a[sn][dn]){
					distance[dn]=distance[sn]+a[sn][dn];}
			}
		}
	}
	}
	for(int sn=1;sn<=n;sn++){
	for(int dn=1;dn<=n;dn++){
		if (a[sn][dn]!=999){
		
		if(distance[dn]>distance[sn]+a[sn][dn]){
			distance[dn]=distance[sn]+a[sn][dn];
			System.out.println("the graph contains negative edge cycle");
			return;
			}
		}
		}
		}
		
		for(int vertex=1;vertex<=n;vertex++)
		System.out.println("distance of"+ source+"to"+vertex +"is:"+distance[vertex]);
		}
	
		}
		
		
			
		
							
	
