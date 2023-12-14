import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		long N=Long.parseLong(br.readLine());
		
		
		//피사노 주기 사용
		//m=1,000,000=10^6
		final int period=(int) (15*Math.pow(10, 5));
		
		//System.out.println(period);
		
		
		long[] arr=new long[period+1];
		arr[0]=0;
		arr[1]=1;
		for(int i=2;i<period+1;i++)
		{
			arr[i]=(arr[i-1]+arr[i-2])%1000000;
		}
		
		int idx=(int)(N%period);
		System.out.println(arr[idx]);
		
	}
}