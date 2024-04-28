import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] tmp = br.readLine().split(" ");
			
			
			int M = Integer.parseInt(tmp[0]);
			int N = Integer.parseInt(tmp[1]);
			int x = Integer.parseInt(tmp[2])-1;
			int y = Integer.parseInt(tmp[3])-1;

			
			
			int max=N*M/gcd(N,M);
//			System.out.println(max);
			int res=-1;
			int times=0;
			while(true)
			{
				int year=times*M+x;
//				System.out.println("year : "+year);
				if(year>max)
				{
					break;
				}
				if(year%N==y)
				{
					res=year;
					break;
				}
				times++;
			}
			if(res!=-1)
			{
				res++;
			}
			System.out.println(res);
		}
		
	}
	// 유클리드 호제법
	static int gcd(int n1,int n2)
	{
		int res=-1;
		while(true)
		{
			res=n1%n2;
			if(res==0)
			{
				break;
			}
			n1=n2;
			n2=res;
		}
		return n2;
	}

}