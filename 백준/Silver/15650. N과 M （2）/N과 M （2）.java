import java.io.*;
import java.util.*;
class Main
{
	static int N,M;
	static boolean[] arr;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] tmp=br.readLine().split(" ");
		N=Integer.parseInt(tmp[0]);
		M=Integer.parseInt(tmp[1]);
		
		arr=new boolean[N];
		
		
		dfs(new ArrayList<Integer>());
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void dfs(ArrayList<Integer> list) throws IOException
	{
		if(list.size()==M)
		{
			for(int i:list)
			{
				bw.write(i+1+" ");
			}
			bw.newLine();
		}
		else
		{
			int max=0;
			if(list.size()>0)//오름차순이 될수있도록 지금 선택되있는 값들보다 더 큰 값 선택하도록
			{
				max=list.get(list.size()-1)+1;
			}
			for(int i=max;i<N;i++)
			{
				if(!arr[i])//방문x
				{
					arr[i]=true;
					ArrayList nList=(ArrayList) list.clone();
					nList.add(i);
					dfs(nList);
					arr[i]=false;
				}
			}
		}
	}
	
}