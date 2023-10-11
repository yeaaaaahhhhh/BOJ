import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static final int p=1234567891;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[] fac=new long[1000001];
		fac[0]=1;
		for(int i=1;i<fac.length;i++)
		{
			fac[i]=fac[i-1]*i%p;
		}
//		System.out.println(Arrays.toString(fac));
		
//		System.out.println(power(2,10));
		for (int t = 1; t <= T; t++) {
			String[] tmp = br.readLine().split(" ");
			
			int N=Integer.parseInt(tmp[0]);
			int R=Integer.parseInt(tmp[1]);
			
			long a=fac[N]%p;
			long b=power(fac[R],p-2)%p;
			long c=power(fac[N-R],p-2)%p;
			
			//System.out.println(a+" "+b+" "+c);
			System.out.println("#"+t+" "+a*b%p*c%p);
			
		}
		
		
	}
	static long power(long pac, int n)
	{
		long res=1;
		while(n>0)
		{
			if(n%2==1)
			{
				res=res*pac%p;
			}
			n=n>>1;
			pac=pac*pac%p;
		}
		return res;
	}
}