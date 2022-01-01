import java.io.*;
import java.util.*;
public class bellmanford {
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter no.of vertices:");
		int nv=sc.nextInt();
		int adj_matrix[][]=new int[nv+1][nv+1];
		System.out.println("Enter adjecency matrix:");
		for(int sn=1;sn<=nv;sn++) {
			for(int dn=1;dn<=nv;dn++) {
				adj_matrix[sn][dn]=sc.nextInt();
				if(sn==dn) {
					adj_matrix[sn][dn]=0;
					continue;
				}
				if(adj_matrix[sn][dn] == 0) {
					adj_matrix[sn][dn]=999;
				}
			}
		}
		System.out.print("Enter source node:");
			int source=sc.nextInt();
		bellmanford bf=new bellmanford(nv);
		bf.bellmanevaluation(source,adj_matrix,nv);
		sc.close();
	}
	private int distance[];
	public bellmanford(int nv) {
		
		distance=new int[nv+1];
	}
	public void bellmanevaluation(int source,int adj_matrix[][],int nv) {
		for(int node=1;node<=nv;node++) {
			distance[node]=999;
		}
		distance[source]=0;
		for(int node=1;node<=nv;node++) {
			for(int sn=1;sn<=nv;sn++) {
				for(int dn=1;dn<=nv;dn++) {
					if(adj_matrix[sn][dn]!=999) {
						if(distance[dn]>(distance[sn]+adj_matrix[sn][dn])) {
							distance[dn]=distance[sn]+adj_matrix[sn][dn];
						}
					}
				}
			}
		}
		for( int sn=1;sn<=nv;sn++) {
			for(int dn=1;dn<=nv;dn++) {
				if(adj_matrix[sn][dn]!=999) {
					if(distance[dn]>(distance[sn]+adj_matrix[sn][dn])) {
						distance[dn]=distance[sn]+adj_matrix[sn][dn];
						System.out.println("graph contains negative edge cycles");
					}
				}
			}
		}
		for(int ver=1;ver<=nv;ver++) {
			System.out.println("distance from source "+source+" to destination "+ver+" is :"+distance[ver]);
		}
	}
}
