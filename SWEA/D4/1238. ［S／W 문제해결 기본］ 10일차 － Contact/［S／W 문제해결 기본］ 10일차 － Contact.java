
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			String[] tmp = br.readLine().split(" ");

			int len = Integer.parseInt(tmp[0]);
			int st = Integer.parseInt(tmp[1]);

			boolean[] visited = new boolean[101];
			Arrays.fill(visited, true);
			ArrayList<Integer>[] list = new ArrayList[101];
			for (int i = 0; i < 101; i++) {
				list[i] = new ArrayList<Integer>();
			}
			tmp = br.readLine().split(" ");
			for (int l = 0; l < len / 2; l++) {
				int from = Integer.parseInt(tmp[l * 2]);
				int to = Integer.parseInt(tmp[l * 2 + 1]);

				if (!list[from].contains(to)) {
					visited[from]=false;
					visited[to]=false;
					list[from].add(to);
				}
			}
			//System.out.println(Arrays.toString(visited));

			LinkedList<Integer> q = new LinkedList<>();
			q.add(st);
			while (true) {
				Queue<Integer> tq = new LinkedList<Integer>();
				
				for(int idx=0;idx<q.size();idx++) {
					int cur = q.get(idx);
					//System.out.println(idx+" "+cur);

					for (int i = 0; i < list[cur].size(); i++) {
						int num = list[cur].get(i);
						if (!visited[num]) {
							visited[num] = true;
							tq.add(num);
						}
					}
				}
				if (tq.isEmpty()) {
					break;
				}
				q =(LinkedList<Integer>) tq;
			}
			
			System.out.println("#"+t+" "+Collections.max(q));
		}
	}

}