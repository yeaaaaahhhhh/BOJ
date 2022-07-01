import java.io.*;
import java.util.*;

class Main {
	static int N,S;
	static int[] arr;
	static int res=0;
	static int max=0;
	static int flag=0;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] tmp=br.readLine().split(" ");
		N=Integer.parseInt(tmp[0]);
		S=Integer.parseInt(tmp[1]);
		arr=new int[N];
		tmp=br.readLine().split(" ");
		
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(tmp[i]);
		}
		for(int i=1;i<=N;i++)
		{
			func(0,i);
			max=0;
		}
		bw.write(res+"\n");
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void func(int len,int L)
	{
		if(len==L)
		{
			int sum=0;
			for(int i=0;i<N;i++)
			{
				if((flag&(1<<i))>0)
					sum+=arr[i];
			}
			if(sum==S)
			{
				res++;
			}
			return;
		}
		else
		{
			for(int i=max;i<N;i++)
			{
				flag|=(1<<i);
				max=i+1;
				func(len+1,L);
				flag&=~(1<<i);
			}
		}
	}
	

}