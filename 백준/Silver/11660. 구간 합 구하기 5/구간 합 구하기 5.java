import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);

		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += Integer.parseInt(tmp[j]);
				if (i == 0) {
					arr[i][j] = sum;
				}
				else
				{
					arr[i][j]=sum+arr[i-1][j];
				}
			}
		}

//    	for(int i=0;i<N;i++)
//    	{
//    		System.out.println(Arrays.toString(arr[i]));
//    	}

		for (int m = 0; m < M; m++) {
			tmp = br.readLine().split(" ");
			int a1 = Integer.parseInt(tmp[0]) - 1;
			int a2 = Integer.parseInt(tmp[1]) - 1;
			int b1 = Integer.parseInt(tmp[2]) - 1;
			int b2 = Integer.parseInt(tmp[3]) - 1;

			int res = arr[b1][b2];
			if(a1!=0)
			{
				res-=arr[a1-1][b2];
			}
			if(a2!=0)
			{
				res-=arr[b1][a2-1];
			}
			if(a1!=0&&a2!=0)
			{
				res+=arr[a1-1][a2-1];
			}
			System.out.println(res);
		}

	}
}