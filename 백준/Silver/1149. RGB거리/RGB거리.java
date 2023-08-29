import java.io.*;
import java.util.*;

public class Main {
	static int[] r,b,g;
	static int N;
	public static void main(String[] args)
	{
		N=0;
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			N=Integer.parseInt(br.readLine());
			r=new int[N];
			b=new int[N];
			g=new int[N];
			for(int i=0;i<N;i++)
			{
				String[] tmp=br.readLine().split(" ");
				r[i]=Integer.parseInt(tmp[0]);
				b[i]=Integer.parseInt(tmp[1]);
				g[i]=Integer.parseInt(tmp[2]);
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		for(int i=1;i<N;i++)
		{
			r[i]+=Math.min(b[i-1], g[i-1]);
			b[i]+=Math.min(r[i-1], g[i-1]);
			g[i]+=Math.min(b[i-1],r[i-1]);
		}
		System.out.println(Math.min(r[N-1],Math.min(b[N-1], g[N-1])));
		
	}
}
