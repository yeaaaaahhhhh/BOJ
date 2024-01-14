import java.io.*;
import java.util.*;

//이분탐색 키워드 검색해봤
class Main {
	static int[] par;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);

		int[] node = new int[N];
		int[] dist = new int[N - 1];
		for (int i = 0; i < N; i++) {
			node[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(node);

		for (int i = 0; i < N - 1; i++) {
			dist[i] = node[i + 1] - node[i];
		}

		int l = 1;
		int r = node[N - 1]-node[0]+1;

		while (l < r) {
			int m = l+(r-l) / 2;
			int cnt = 1;
			int sum = 0;
			//System.out.println(l+" "+r+" "+m);
			boolean able=false;
			for (int i = 0; i < N - 1; i++) {
				sum += dist[i];
				
				if (sum >= m) {
					cnt++;
					sum=0;
					// m 가능. 
					if (cnt == M) {
						able=true;
						l=m+1;
						break;
					}
				}
			}
			if(!able)
			{
				r=m;
			}
			

		}
		
		System.out.println(r-1);

	}
}