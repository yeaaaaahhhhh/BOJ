import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int M = Integer.parseInt(tmp[1]);

			int[] snacks = new int[N];
			
			int max=-1;
			tmp = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(tmp[i]);
				if (snacks[i] < M) {
					for (int j = 0; j < i; j++) {
						int sum=snacks[i]+snacks[j];
						if(sum<=M&&sum>max)
						{
							max=sum;
						}
					}
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}

}
