import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int SIZE = 100001;
		String[] tmp = br.readLine().split(" ");

		int N = Integer.parseInt(tmp[0]);
		int K = Integer.parseInt(tmp[1]);

		int[] map = new int[SIZE];
		Arrays.fill(map, -1);
		
		int maxTime=Integer.MAX_VALUE;
		int cnt=0;
		
		Queue<int[]> q = new LinkedList<>();
		map[N] = 0;
		q.add(new int[] { N, 0 });// 위치, 초 넣기
		if(N==K)
		{
			maxTime=0;
			cnt++;
		}
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int loc = cur[0];
			int sec = cur[1];
			
			if(sec==maxTime)
			{
				break;
			}

			if (loc - 1 >= 0 && (map[loc - 1] == sec+1||map[loc-1]==-1)) {
				map[loc - 1] = sec + 1;
				q.add(new int[] { loc - 1, sec + 1 });
				if(loc-1==K)
				{
					maxTime=sec+1;
					cnt++;
				}
			}
			if (loc + 1 < SIZE && (map[loc + 1] == sec+1||map[loc+1]==-1)) {
				map[loc + 1] = sec + 1;
				q.add(new int[] { loc + 1, sec + 1 });
				if(loc+1==K)
				{
					maxTime=sec+1;
					cnt++;
				}
			}
			if (loc * 2 < SIZE && (map[loc * 2] == sec+1||map[loc*2]==-1)) {
				map[loc * 2] = sec + 1;
				q.add(new int[] { loc * 2, sec + 1 });
				if(loc*2==K)
				{
					maxTime=sec+1;
					cnt++;
				}
			}
		}

		//System.out.println(Arrays.toString(map));
		System.out.println(maxTime);
		System.out.println(cnt);

	}
}