import java.io.*;
import java.util.*;

class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] input=br.readLine().split(" ");
		
		int N=Integer.parseInt(input[0]);
		int K=Integer.parseInt(input[1]);
		
		int[][] arr=new int[N][2];
		for(int i=0;i<N;i++)
		{
			input=br.readLine().split(" ");
			
			arr[i][0]=Integer.parseInt(input[0]);
			arr[i][1]=Integer.parseInt(input[1]);
			
		}
		//Arrays.sort(arr,(o1,o2)->o1[0]>o2[0]? 1:-1); //람다식으로 comparable


		int[] res=new int[K+1];
		for(int i=0;i<N;i++)
		{
			int[] tres=res.clone();
			int w=arr[i][0];
			int v=arr[i][1];
			for(int j=0;j<K+1;j++)
			{
				if(j>=w)
				{
					tres[j]=Math.max(tres[j],v+res[j-w]);
				}
			}
			res=tres.clone();
		}
		
		System.out.println(res[K]);
//		for(int i=0;i<K+1;i++)
//		{
//			System.out.println(i+" "+res[i]);
//		}
	}
}