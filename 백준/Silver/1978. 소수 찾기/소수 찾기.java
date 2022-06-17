import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static int N;
	static int[] arr;
	static int res=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		String[] tmp=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(tmp[i]);
		}
		
		bw.write(func()+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int func()
	{
		int res=0;
		for(int i=0;i<N;i++)
		{
			boolean check=false;
			if(arr[i]!=1) {
			for(int j=arr[i]-1;j>1;j--)
			{
				if(arr[i]%j==0)
				{
					check=true;
					//System.out.println(arr[i]+" "+j);
					break;
				}
			}}
			else
			{
				check=true;
			}
			if(!check)
			{
				res++;
			}
		}
		return res;
	}
}