import java.util.*;
import java.io.*;
class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++)
		{
			int sum=0;
			int D=Integer.parseInt(br.readLine());
			String[] tmp=br.readLine().split(" ");
			
			int[] box=new int[101];
			int max=-1;
			int min=101;
			for(int i=0;i<100;i++)
			{
				int n=Integer.parseInt(tmp[i]);
				sum+=n;
				if(max<n)
					max=n;
				if(min>n)
				{
					min=n;
				}
				for(int j=1;j<n;j++)
				{
					box[j]++;
				}
			}
			double avg=sum*1.0/100;
			
			int cnt=0;
			while(cnt<D)
			{
				if(max<avg)
				{
					break;
				}
				if(box[max]<=D-cnt)
				{
					cnt+=box[max];
					box[max--]=0;
				}
				else
				{
					cnt+=D-cnt;
					box[max]-=D-cnt;
				}
			}
			
			D=cnt;
			cnt=0;
			while(cnt<D)
			{
				if(100-box[min]<=D-cnt)
				{
					cnt+=100-box[min];
					box[min++]=100;
				}
				else
				{
					box[min]+=D-cnt;
					break;
				}
			}
			System.out.println("#"+t+" "+(max-min+1));
		}
		

	}
}
