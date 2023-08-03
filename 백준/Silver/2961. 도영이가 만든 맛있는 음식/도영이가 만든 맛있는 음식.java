
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		int[][] arr=new int[N][2];
		for(int i=0;i<N;i++)
		{
			String[] tmp=br.readLine().split(" ");
			arr[i][0]=Integer.parseInt(tmp[0]);
			arr[i][1]=Integer.parseInt(tmp[1]);
		}
		
		int len=(1<<N);
		int min=Integer.MAX_VALUE;
		
		for(int i=1;i<len;i++)
		{
			int[] taste= {1,0};
			for(int j=0;j<N;j++)
			{
				if(((i>>j)&1)==1)
				{
					taste[0]*=arr[j][0];
					taste[1]+=arr[j][1];
				}
			}
			int res=Math.abs(taste[0]-taste[1]);
			//System.out.println(taste[0]+" "+taste[1]);
			
			if(min>res)
				min=res;
		}
		System.out.println(min);
	}
}