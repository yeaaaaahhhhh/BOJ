
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			double[] minEdge = new double[N];
			
			Arrays.fill(minEdge, Integer.MAX_VALUE);
			minEdge[0]=0;

			int[][] island = new int[N][2];

			String[] tmp = br.readLine().split(" ");
			for(int i=0;i<N;i++)
			{
				island[i][0]=Integer.parseInt(tmp[i]);
			}
			tmp = br.readLine().split(" ");
			for(int i=0;i<N;i++)
			{
				island[i][1]=Integer.parseInt(tmp[i]);
			}
			double E=Double.parseDouble(br.readLine());
			
			
			boolean[] visited=new boolean[N];
			
			
			int node=0;
			int cnt=1;
			while(node!=-1)
			{
				//System.out.println(node);
				visited[node]=true;

				for(int i=0;i<N;i++)
				{
					if(node==i)
					{
						continue;
					}
					//int L=Math.abs(island[node][0]-island[i][0])+Math.abs(island[node][1]-island[i][1]);
					double L=Math.sqrt(Math.pow(island[node][0]-island[i][0],2)+Math.pow(island[node][1]-island[i][1],2));
					if(!visited[i]&&minEdge[i]>L)
					{
						minEdge[i]=L;
					}
				}
				
				double min=Double.MAX_VALUE;
				int minIdx=-1;
				for(int i=0;i<N;i++)
				{
					if(!visited[i]&&min>minEdge[i])
					{
						min=minEdge[i];
						minIdx=i;
					}
				}
				node=minIdx;
				//System.out.println(Arrays.toString(minEdge));
			}
			
			double res=0;
			
			for(int i=1;i<N;i++)
			{
				res+=E*minEdge[i]*minEdge[i];
			}
			
			System.out.println("#"+t+" "+Math.round(res));
		}
	}

}