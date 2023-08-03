
import java.io.*;


class Solution {
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++)
		{
			String[] tmp=br.readLine().split(" ");
			int N=Integer.parseInt(tmp[0]);
			int M=Integer.parseInt(tmp[1]);
			
			arr=new int[N][N];
			
			for(int i=0;i<N;i++)
			{
				tmp=br.readLine().split(" ");
				for(int j=0;j<N;j++)
				{
					arr[i][j]=Integer.parseInt(tmp[j]);
				}
			}
			int max=0;
			for(int i=0;i<N-M+1;i++)
			{
				for(int j=0;j<N-M+1;j++)
				{
					int res=catchFly(M,i,j);
					if(max<res)
						max=res;
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
	static int catchFly(int M,int x,int y)
	{
		int res=0;
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<M;j++)
			{
				res+=arr[x+i][y+j];
			}
		}
		return res;
	}
}