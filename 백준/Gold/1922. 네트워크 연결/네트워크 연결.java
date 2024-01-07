import java.io.*;
import java.util.*;

class Main {
	static int[] par;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		ArrayList<int[]> route=new ArrayList<int[]>();
		par=new int[N];
		for(int i=0;i<N;i++)
		{
			par[i]=i;
		}
		for (int i = 0; i < M; i++) {

			String[] tmp = br.readLine().split(" ");

			int a = Integer.parseInt(tmp[0]) - 1;
			int b = Integer.parseInt(tmp[1]) - 1;
			int c = Integer.parseInt(tmp[2]);

			route.add(new int[] {a,b,c});
		}
		
		Collections.sort(route, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		int cnt=0;
		boolean[] visited=new boolean[N];
		int price=0;
		for(int i=0;i<M;i++)
		{
			int a=route.get(i)[0];
			int b=route.get(i)[1];
			int c=route.get(i)[2];
			
			if(a==b||(find(a)==find(b)))
			{
				continue;
			}
					
//			System.out.println(Arrays.toString(route.get(i)));
			
			price+=c;
			union(a,b);

//			System.out.println(Arrays.toString(par));
			
		}
		System.out.println(price);
	}
	static void union(int a,int b)
	{
		if(a>b)
		{
			par[find(a)]=find(b);
		}
		else
		{
			par[find(b)]=find(a);
		}
	}
	static int find(int node)
	{
		if(par[node]==node)
		{
			return node;
		}
		else
		{
			return par[node]=find(par[node]);
		}
	}
}