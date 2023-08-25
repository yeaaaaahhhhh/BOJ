
import java.util.*;
import java.io.*;

public class Solution {
	static ArrayList<int[]> cores;
	static int max,maxLen,N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			int[][] map=new int[N][N];
			cores=new ArrayList<>();
			max=0;
			maxLen=0;
			for(int i=0;i<N;i++)
			{
				String[] tmp=br.readLine().split(" ");
				
				for(int j=0;j<N;j++)
				{
					map[i][j]=Integer.parseInt(tmp[j]);
					//0 빈칸 1 코어 2 전선
					if(map[i][j]==1)
						cores.add(new int[] {i,j});
				}
			}
			dfs(0,0,0,map);
			System.out.println("#"+t+" "+maxLen);
		}
	}
	
	static void dfs(int idx,int cnt,int len,int[][] map)
	{
		if(idx==cores.size())
		{
			if(max<cnt)
			{
				max=cnt;
				maxLen=len;
			}
			else if(max==cnt&&len<maxLen)
			{
				maxLen=len;
			}
			return;
		}
		
		int[] cur=cores.get(idx);
		if(cur[0]==0||cur[1]==0||cur[0]==N-1||cur[1]==N-1)
		{
			dfs(idx+1,cnt,len,map);
			return;
		}
		int[] dy= {0,0,1,-1};
		int[] dx={1,-1,0,0};
		
		for(int d=0;d<4;d++)
		{
			int[][] tmap=new int[N][N];
			for(int i=0;i<N;i++)
			{
				tmap[i]=map[i].clone();
			}
			
			int ty=cur[0]+dy[d];
			int tx=cur[1]+dx[d];
			boolean ended=true;//해당방향으로 벽까지 가서 연결할 수 있는지
			int tlen=0;
			while(ty>=0&&ty<N&&tx>=0&&tx<N)
			{
				if(tmap[ty][tx]==0)
				{
					tmap[ty][tx]=2;
					tlen++;
				}
				else
				{
					ended=false;
					break;
				}
				ty+=dy[d];
				tx+=dx[d];
			}
			if(ended)
			{
				dfs(idx+1,cnt+1,len+tlen,tmap);
			}
		}
		dfs(idx+1,cnt,len,map);
	}

}