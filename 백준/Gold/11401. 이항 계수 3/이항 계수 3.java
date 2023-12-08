import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static long p=1000000007;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp=br.readLine().split(" ");
		
		int N=Integer.parseInt(tmp[0]);
		int K=Integer.parseInt(tmp[1]);
		

		//nCk=n!/(k!(n-k)!)%p
		// => n!*(k!(n-k)!)^(p-2))%p
		
		long[] fact=new long[N+2];
		fact[0]=1;
		fact[1]=1;
		for(int i=2;i<=N+1;i++)
		{
			fact[i]=(fact[i-1]*i)%p;
		}
		long mom=(fact[K]*fact[N-K])%p;
		
		long yeokwon=square(mom, p-2);
		//System.out.println(yeokwon);
		long res=(fact[N]*yeokwon)%p;

		System.out.println(res);
		//System.out.println(square(2, 10));
		
	}
	static long square(long num,long exp)
	{
		long res=1;
		while(exp>0)
		{
			if(exp%2==1)
			{
				res*=num;
				res%=p;
			}
			num=(num*num)%p;
			exp/=2;
		}
		return res;
	}
}