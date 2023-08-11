import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1,int[] o2)
			{
				if(o1[1]==o2[1])
				{
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
		});
		for(int i=0;i<N;i++)
		{
			String[] tmp=br.readLine().split(" ");
			
			pq.add(new int[]{Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1])});
		}
		
		int res=0;
		int time=0;
		while(!pq.isEmpty())
		{
			int[] cur=pq.poll();
			if(cur[0]>=time)
			{
				time=cur[1];
				res++;
				//System.out.println(cur[0]+" "+cur[1]);
			}
		}
		System.out.println(res);
	}
}

