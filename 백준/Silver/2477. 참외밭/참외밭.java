import java.util.*;
import java.io.*;
public class Main {
	
	static ArrayList<int[]> list=new ArrayList();
	static Stack<Integer>[] st=new Stack[3];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		Queue<int[]> q=new LinkedList();
		int[] cnt=new int[4];
		for(int i=0;i<6;i++)
		{
			String[] tmp=br.readLine().split(" ");
			int dir=Integer.parseInt(tmp[0])-1;
			int len=Integer.parseInt(tmp[1]);
			q.add(new int[] {dir,len});
			cnt[dir]++;
		}
		boolean flag=false;
		int big=1;
		int small=1;
		int smlCnt=0;
		while(!q.isEmpty())
		{
			int[] crt=q.poll();
			if(cnt[crt[0]]==1)
			{
				big*=crt[1];
				flag=true;
				continue;
			}
			else if(flag&&cnt[crt[0]]==2)
			{
				if(smlCnt>0&&smlCnt<3)
				{
					small*=crt[1];
				}
				smlCnt++;
			}
			else//flag가 false일때 cnt==2인 애들 처리
			{
				q.add(crt);
			}
		}
		//System.out.println(big+" "+small);
		System.out.println(N*(big-small));
	}
}
