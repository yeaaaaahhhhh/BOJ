import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		int K = Integer.parseInt(tmp[2]);

		ArrayList<int[]>[] route = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			route[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < M; i++) {
			tmp = br.readLine().split(" ");
			int A = Integer.parseInt(tmp[0]) - 1;
			int B = Integer.parseInt(tmp[1]) - 1;
			int C = Integer.parseInt(tmp[2]);

			route[B].add(new int[] { A, C });
		}

		long[] v = new long[N];
		Arrays.fill(v, 10000000000L);

		PriorityQueue<Integer> q = new PriorityQueue<Integer>((o1, o2) -> {
			return (v[o1] - v[o2] > 0) ? 1 : -1;
		});

		tmp = br.readLine().split(" ");
		for (int i = 0; i < K; i++) {
			int p = Integer.parseInt(tmp[i]) - 1;
//			System.out.println(p);
			q.add(p);
			v[p] = 0;
		}

		int cnt = 0;
		boolean[] visited = new boolean[N];
		while (!q.isEmpty()) {
			int cur = q.poll();
			if(visited[cur])
			{
				continue;
			}
			visited[cur] = true;
			
			for (int[] r : route[cur]) {

				if (visited[r[0]]||v[r[0]] < v[cur] + r[1]) {
					continue;
				}
				v[r[0]] = v[cur] + r[1];
				q.add(r[0]);
			}
		}

		long max = 0;
		int idx = -1;
		for (int i = 0; i < N; i++) {
			if (max < v[i]) {
				max = v[i];
				idx = i + 1;
			}
		}
		System.out.println(idx);
		System.out.println(max);
	}
}