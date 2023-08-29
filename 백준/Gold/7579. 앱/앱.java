import java.io.*;
import java.util.*;
import java.util.Map.Entry;


//바보짓 1 : 비용 배열 크기를 101로 둠
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);

		int[][] app = new int[N][2];

		tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			app[i][0] = Integer.parseInt(tmp[i]);
		}
		int sum=1;
		tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			app[i][1] = Integer.parseInt(tmp[i]);
			sum+=app[i][1];
		}
		
		Arrays.sort(app,new Comparator<int[]>() {
			public int compare(int[] a,int[] b)
			{
				return a[1]-b[1];
			}
		});
//		for(int[] ap:app)
//			System.out.println(Arrays.toString(ap));
		
		
		long[][] dp=new long[N][sum];
		for(int j=app[0][1];j<sum;j++)
		{
			dp[0][j]= app[0][0];
		}
		for(int i=1;i<N;i++)
		{
			for(int j=0;j<sum;j++)
			{
				//비교 : 원래 dp 값,현재 앱 값, 이전 앱들 합이랑 현재 앱 더한것
				// 허용된 코스트 버짓보다 앱의 비용이 더 적을 때 가능
				if(j>=app[i][1])
				{
					dp[i][j]=Math.max(dp[i-1][j], app[i][0]+dp[i-1][j-app[i][1]]);
				}
				else
				{
					dp[i][j]=dp[i-1][j];
				}
			}
			//System.out.println(Arrays.toString(dp[i]));
		}

		
		for(int i=0;i<sum;i++)
		{
			if(dp[N-1][i]>=M)
			{	
				System.out.println(i);
				break;
			}
		}
	
		
	}
}
