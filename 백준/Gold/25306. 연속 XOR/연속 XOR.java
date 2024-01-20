import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp=br.readLine().split(" ");
		long A=Long.parseLong(tmp[0]);
		long B=Long.parseLong(tmp[1]);
		
		System.out.println(xor(A,B));
//		System.out.println(xortest(A,B));
		
	}
	static long xor(long a,long b)
	{
		long res=a;
		
		long lmt1=(a/4)+1;
		long lmt2=(b/4);
		
//		System.out.println(lmt1*4+" "+lmt2*4);
		for(long i=a+1;i<lmt1*4;i++)
		{
			res=(res^i);
		}
		for(long i=lmt2*4;i<=b;i++)
		{
			res=(res^i);
		}
		return res;
	}
	static long xortest(long a,long b)
	{
		long res=a;
		for(long i=a+1;i<=b;i++)
		{
			res=res^i;
		}
		return res;
	}
}