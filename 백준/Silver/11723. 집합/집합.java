
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		int S=0;
		
		for(int i=0;i<N;i++)
		{
			String[] tmp=br.readLine().split(" ");
			int n;
			switch(tmp[0])
			{
			case "add":
				n=Integer.parseInt(tmp[1]);
				S=S|1<<(n-1);
				break;
			case "remove":
				n=Integer.parseInt(tmp[1]);
				S=S&~(1<<n-1);
				break;
			case "check":
				n=Integer.parseInt(tmp[1]);
	
				if((S&(1<<n-1))>>(n-1)==1)
				{
					bw.write("1\n");
				}
				else
				{
					bw.write("0\n");
				}
				break;
			case "toggle":
				n=Integer.parseInt(tmp[1]);
				//System.out.println(Integer.toBinaryString(S));
				if((S&(1<<n-1))>>(n-1)==1)
				{
					S=S&~(1<<n-1);
				}
				else
				{
					S=S|1<<(n-1);
				}
				break;
			case "all":
				S=(1<<20)-1;
				break;
			case "empty":
				S=0;
				break;
			}
			
		}
		bw.flush();
	}
}