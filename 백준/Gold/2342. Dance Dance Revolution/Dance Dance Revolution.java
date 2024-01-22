import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int[] arr;
	static int[][] rel= {{0,2,2,2,2},{0,1,3,4,3},{0,3,1,3,4},{0,4,3,1,3},{0,3,4,3,1}};
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		N = tmp.length-1;
		arr = new int[N];
		dp=new int[N][5][5];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}

		System.out.println(repeat(0,0,0));

	}

	static int repeat(int left, int right,int n) {
		if(n==N)
		{
			return 0;
		}
		if(dp[n][left][right]!=0)
		{
			return dp[n][left][right];
		}
		return dp[n][left][right]=Math.min(repeat(arr[n],right,n+1)+rel[left][arr[n]],
				repeat(left,arr[n],n+1)+rel[right][arr[n]]);
	}

}