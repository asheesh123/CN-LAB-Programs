import java.util.*;

public class DVR {
	int graph[][];//the weighted graph
	int adj[][];//to check if two vertices or routers are adjacent
	int dup[][];//just for duplication
	int next_hop[][];//the next hop should be taken
	int v;// #vertices
	int e;//#edges
	public static void main(String args[])
	{
	     Scanner sc = new Scanner(System.in);
	     DVR r = new DVR();
	     System.out.println("enter number of routers");
	     r.v=sc.nextInt();
	     System.out.println("enter number of edges");
	     r.e=sc.nextInt();
	     //declaration and initialization
	     r.graph=new int[r.v][r.v];
	     r.dup=new int[r.v][r.v];
	     r.adj=new int[r.v][r.v];
	     r.next_hop=new int[r.v][r.v];
	     for(int i=0;i<r.v;i++)
	     {
	    	 for(int j=0;j<r.v;j++)
	    	 {
	    		 r.dup[i][j]=0;
	    		 r.adj[i][j]=0;
	    		 r.next_hop[i][j]=0;
	    		 
	    		 if(i!=j)
	    		   r.graph[i][j]=1000;
	    		 else
	    			r.graph[i][j]=0; 
	    	 }
	     }
	     //taking input
	     for(int i=0;i<r.e;i++)
	     {
	    	 int s,d,cost;
	    	 System.out.println("enter edge information i.e., source, destination and cost");
	    	 System.out.println("source:");
	    	 s=sc.nextInt();s--;
	    	 System.out.println("destination:");
	    	 d=sc.nextInt();d--;
	    	 System.out.println("cost:");
	    	 cost=sc.nextInt();
	    	 r.graph[s][d]=cost;
	    	 r.graph[d][s]=cost;
	    	 r.adj[s][d]=1;
	    	 r.adj[d][s]=1;
	    	 r.next_hop[s][d]=d+1;
	    	 r.next_hop[d][s]=s+1;
	     }
	     System.out.println("Initial graph matrix is");
	     for(int i=0;i<r.v;i++)
	     {
	    	 for(int j=0;j<r.v;j++)
	    	 {
	    		 System.out.print(r.graph[i][j]+" ");
	    	 }
	    	 System.out.println();
	     }
	     //running modify_dist() function for v-1 times
	     for(int i=0;i<r.v-1;i++)
	     {
	    	 r.modify_dist();
	    	 for(int j=0;j<r.v;j++)
	    	 {
	    		 for(int k=0;k<r.v;k++)
	    		 {
	    			 if(r.dup[j][k]>0)
	    			 {
	    				 r.graph[j][k]=r.dup[j][k];
	    				 r.dup[j][k]=0;
	    			 }
	    		 }
	    	 }
	     }
	     System.out.println("at the end graph matrix is");
	     for(int i=0;i<r.v;i++)
	     {
	    	 for(int j=0;j<r.v;j++)
	    	 {
	    		 System.out.print(r.graph[i][j]+" ");
	    	 }
	    	 System.out.println();
	     }
	     System.out.println("at the end graph matrix for next hop is");
	     for(int i=0;i<r.v;i++)
	     {
	    	 for(int j=0;j<r.v;j++)
	    	 {
	    		 System.out.print(r.next_hop[i][j]+" ");
	    	 }
	    	 System.out.println();
	     } 
		sc.close();
	}
	void modify_dist()
	{
		for(int i=0;i<v;i++)
		{
			int adj_index[]=new int[v];
			int adj_length[]=new int[v];
			int index=0;
			for(int j=0;j<v;j++)
			{
				if(adj[i][j]==1)
				{
					adj_index[index++]=j;
				}
			}
			int index1=0;
			for(int j=0;j<index;j++)
			{
				adj_length[index1++]=graph[i][adj_index[j]];
			}
			for(int j=0;j<v;j++)
			{	
				int min=1000,min_index=0;
				if(i!=j)
				{
					for(int k=0;k<index;k++)
					{
						if(min>(adj_length[k]+graph[adj_index[k]][j]))
						{
							min=adj_length[k]+graph[adj_index[k]][j];
							min_index=adj_index[k];
						}
					}
					dup[i][j]=min;
					next_hop[i][j]=min_index+1;
				}
			}
		}	
	}
}
