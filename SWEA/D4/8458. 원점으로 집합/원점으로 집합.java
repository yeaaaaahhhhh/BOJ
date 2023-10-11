import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		outer: for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			int[] dis = new int[N];

			for (int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split(" ");

				int y = Integer.parseInt(tmp[0]);
				int x = Integer.parseInt(tmp[1]);

				dis[i] = Math.abs(y) + Math.abs(x);
			}

			int k = 0;
			int sum = 0;
			// System.out.println((1<<N)-1);
			while (sum < 2001000000) {
				sum += k;
				int flag = 0;
				//System.out.println(sum+" "+k);
				for (int i = 0; i < N; i++) {
					if (dis[i] <= sum && dis[i] % 2 == sum % 2) {
						flag = flag | (1 << i);
					}
				}
				if (flag == (1 << N) - 1) {
					System.out.println("#" + t + " " + k);
					continue outer;
				}
				k++;
			}

			System.out.println("#" + t + " -1");

		}
	}
}
