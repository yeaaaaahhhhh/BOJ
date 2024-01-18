import java.io.*;
import java.util.*;

class Main {
	static char[][] map;
	static int N,M,K;
	static int[] dy= {1,1,1,0,0,-1,-1,-1};
	static int[] dx= {1,0,-1,1,-1,1,0,-1};
	//static HashMap<Character,ArrayList<int[]>>[] hm;
	static HashMap<String,Integer> res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp=br.readLine().split(" ");
		
		N=Integer.parseInt(tmp[0]);
		M=Integer.parseInt(tmp[1]);
		K=Integer.parseInt(tmp[2]);
		
		map=new char[N][M];
		
		for(int i=0;i<N;i++)
		{
			String str=br.readLine();
			for(int j=0;j<M;j++)
			{
				map[i][j]=str.charAt(j);
			}
		}
		
//		hm=new HashMap[N*M];
		
//		for(int i=0;i<1;i++)
//		{
//			for(int j=0;j<1;j++)
//			{
//				int idx=i*M+j;
//				hm[idx]=new HashMap<Character, ArrayList<int[]>>();
//				
//				for(int d=0;d<8;d++)
//				{
//					int ty=(i+dy[d]+N)%N;
//					int tx=(j+dx[d]+M)%M;
//					System.out.println(i+" "+j+" "+ty+" "+tx);
//					
//					ArrayList<int[]> list = hm[idx].getOrDefault(map[ty][tx], new ArrayList<>());
//					
//					list.add(new int[] {ty,tx});
//					
//				}
//			}
//		}
		
		res= new HashMap<String, Integer>();
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				dfs(i,j,String.valueOf(map[i][j]));
			}
		}
		
		for(int i=0;i<K;i++)
		{
			String str=br.readLine();
			System.out.println(res.getOrDefault(str,0));
		}
	}
	static void dfs(int i,int j,String str)
	{
		res.put(str, res.getOrDefault(str, 0)+1);
		
		if(str.length()==5)
		{
			return;
		}
		
		int idx=i*M+j;
		
		for(int d=0;d<8;d++)
		{
			int ty=(i+dy[d]+N)%N;
			int tx=(j+dx[d]+M)%M;
			
			dfs(ty,tx,str+map[ty][tx]);
		}
		
	}
}