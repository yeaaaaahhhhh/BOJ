import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");

			for (int j = 0; j < N; j++) {
				if (i > j)
					arr[i][j] += Integer.parseInt(tmp[j]);
				else
					arr[j][i] += Integer.parseInt(tmp[j]);
			}
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

		int minDiff=100000007;
		for (int n = 1; n < (int) (Math.pow(2, N - 1)); n++) {
			//System.out.println(Integer.toBinaryString(n));
			int[] score = new int[2];
			List<Integer>[] team=new ArrayList[2];
			team[0]=new ArrayList<Integer>();
			team[1]=new ArrayList<Integer>();
			for (int digit=0;digit<N;digit++) {
				//System.out.println("계산식: "+(int)(Math.pow(2, digit))+" "+(n & (int)(Math.pow(2, digit))));
				if ((n & (int)(Math.pow(2, digit))) !=0) {
					for(int p:team[1])
					{
						score[1]+=arr[digit][p];
					}
					team[1].add(digit);
				} else {
					for(int p:team[0])
					{
						score[0]+=arr[digit][p];
					}
					team[0].add(digit);
				}
			}
			if(minDiff>Math.abs(score[1]-score[0]))
			{
				minDiff=Math.abs(score[1]-score[0]);
			}
			//System.out.println(score[0]+" "+score[1]+" "+minDiff);
		}
		System.out.println(minDiff);
	}
}