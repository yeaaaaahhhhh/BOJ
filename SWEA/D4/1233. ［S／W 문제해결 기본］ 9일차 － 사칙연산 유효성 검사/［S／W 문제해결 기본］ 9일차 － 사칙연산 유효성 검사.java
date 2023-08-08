import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Solution {
	static int N, M, R;
	static int[][] orgin;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			char[] arr = new char[N + 1];
			boolean flag = true;
			for (int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split(" ");
				int idx = Integer.parseInt(tmp[0]);
				arr[idx] = tmp[1].charAt(0);
				if (flag) {
					if ((tmp.length != 2 && (arr[idx] >= '0' && arr[idx] <= '9'))
							||(tmp.length == 2 && (arr[idx] < '0' || arr[idx] > '9')))
					{
						flag=false;
					}
				}
			}
			if (flag) {
				System.out.println("#" + t + " " + 1);
			} else {
				System.out.println("#" + t + " " + 0);
			}

		}
	}
}
