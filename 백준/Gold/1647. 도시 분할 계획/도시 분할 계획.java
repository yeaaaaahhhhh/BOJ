import java.io.*;
import java.util.*;

public class Main {

	static int[] par;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);

		par = new int[N];
		for (int i = 0; i < N; i++) {
			par[i] = i;
		}

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[2]-b[2];
			}
		});

		for (int i = 0; i < M; i++) {
			tmp = br.readLine().split(" ");
			int[] arr = new int[3];
			arr[0] = Integer.parseInt(tmp[0]) - 1;
			arr[1] = Integer.parseInt(tmp[1]) - 1;
			arr[2] = Integer.parseInt(tmp[2]);

			pq.add(arr);
		}
		
		
		int cnt = N - 2;
		int res = 0;
		if(cnt==0)
		{
			System.out.println(res);
			return;
		}
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (findPar(cur[0]) == findPar(cur[1])) {
				continue;
			}
//			System.out.println(Arrays.toString(cur));
//			System.out.println(Arrays.toString(par));
			
			res+=cur[2];
			union(cur[0],cur[1]);
			

			if(--cnt==0)
			{
				break;
			}
			
		}
		System.out.println(res);
	}
	static void union(int a,int b)
	{
		findPar(a);
		findPar(b);
		if(par[a]>par[b])
		{
			par[par[a]]=par[b];
		}
		else
		{
			par[par[b]]=par[a];
		}
	}

	static int findPar(int node) {
		if (par[node] == node) {
			return node;
		}
		return (par[node] = findPar(par[node]));
	}

}