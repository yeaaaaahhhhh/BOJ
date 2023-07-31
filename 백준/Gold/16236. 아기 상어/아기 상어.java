import java.util.*;
import java.io.*;
public class Main {
	static int[][] arr;
	static int N;
	static int[] shark= {0,0,2};
	static int[][] dst;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		for(int i=0;i<N;i++)
		{
			String[] tmp=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(tmp[j]);
				if(arr[i][j]==9)
				{
					shark[0]=i;
					shark[1]=j;
					arr[i][j]=0;
				}
			}
		}
		int time=0;
		int cnt=0;
		while(true)
		{
			int[] prey=findFish();
			//System.out.println(Arrays.toString(prey));
			if(prey[0]==-1)
			{
				break;
			}
			time+=prey[2];
			cnt++;
			arr[prey[0]][prey[1]]=0;
			shark[0]=prey[0];
			shark[1]=prey[1];
			if(cnt==shark[2])
			{
				shark[2]++;
				cnt=0;
			}
		}
		System.out.println(time);
		
	}
	static int[] findFish()
	{	
		int[] res= {-1,-1,-1};
		
		int[] dx= {0,1,0,-1};
		int[] dy= {-1,0,1,0};
		
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[] {shark[0],shark[1],1});
 		
		dst=new int[N][N];
		int min=Integer.MAX_VALUE;
		while(!q.isEmpty())
		{
			int[] cur=q.poll();
			for(int i=0;i<4;i++)
			{
				int ty=cur[0]+dy[i];
				int tx=cur[1]+dx[i];
				//System.out.println(Arrays.toString(cur));
				
				//가본적 없는 위치
				if(tx>=0&&tx<N&&ty>=0&&ty<N&&dst[ty][tx]==0)
				{
					//벽인지 확인
					if(arr[ty][tx]>shark[2])
					{
						dst[ty][tx]=Integer.MAX_VALUE;
					}
					
					else
					{
						dst[ty][tx]=cur[2];
						//현재 거리보다 min이 작으면 계속 q를 추가
						if(cur[2]<=min)
						{
							//현재 위치에 먹을 수 있는 물고기가 있따 == 더 먼곳은 조회 할 필요 없음
							if(arr[ty][tx]!=0&&arr[ty][tx]<shark[2])
							{
								//System.out.println(ty+" "+tx+" "+cur[2]);
								if(cur[2]<min)
								{
									min=cur[2];
									res=new int[] {ty,tx,cur[2]};
									//System.out.println("1 "+ty+" "+tx+" "+cur[2]);
								}
								else if(ty<res[0])
								{
									res=new int[] {ty,tx,cur[2]};
									//System.out.println("2 "+ty+" "+tx+" "+cur[2]);
								}
								else if(ty==res[0]&&tx<res[1])
								{
									res=new int[] {ty,tx,cur[2]};
									//System.out.println("3 "+ty+" "+tx+" "+cur[2]);
								}
							}

							q.add(new int[]{ty,tx,cur[2]+1});
							//System.out.println(ty+" "+tx+" "+cur[2]);

						}
					}
				}
			}
		}
		return res;
	}
	
	
}
