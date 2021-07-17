import java.io.*;
import java.util.*;

public class Main {
	public static int[] mlt=new int[300];
	public static int[] arr=new int[50000];
	public static void main(String[] args) throws Exception {
		mlt[0]=1;
		mlt[1]=4;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int input=Integer.parseInt(br.readLine());
		System.out.println(func(input));

	}
	static int func(int input)
	{
		for(int i=1;i<=input;i++)
		{
			int res=input;
			for(int j=0;j<300;j++)
			{
				if(mlt[j]==0)
				{
					mlt[j]=(j+1)*(j+1);
				}
				if(mlt[j]>i)
				{
					break;
				}
				else if(mlt[j]==i)
				{
					res=1;
					break;
				}
				
				int rest=i-mlt[j];
				if(arr[rest]==0)
				{
					System.out.println("Something went wrong");
				}
				int a=1+arr[rest];
				if(a<res)
				{
					res=a;
				}
			}
			arr[i]=res;
			//System.out.println(i+" "+res);
		}
		return arr[input];
	}
}
