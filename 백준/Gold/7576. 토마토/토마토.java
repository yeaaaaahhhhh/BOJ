import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp=br.readLine().split(" ");
		
		int M=Integer.parseInt(tmp[0]);
		int N=Integer.parseInt(tmp[1]);
		int[][] arr=new int[N][M];
		Queue<Pair> q=new LinkedList();
		int unripe=0;
		int days=0;
		for(int i=0;i<N;i++)
		{
			tmp=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				arr[i][j]=Integer.parseInt(tmp[j]);
				if(arr[i][j]==0)
					unripe++;
				if(arr[i][j]==1)
				{
					q.add(new Pair(i,j));
				}
			}
		}
		Queue<Pair> tq=new LinkedList();
		while(!q.isEmpty()&&unripe!=0)
		{
			days++;
			while(!q.isEmpty()) {
				Pair p= q.poll();
				int x=p.x;
				int y=p.y;
				if(x-1>=0&&arr[x-1][y]==0)
				{
					arr[x-1][y]=1;
					tq.add(new Pair(x-1,y));
					unripe--;
				}
				if(y-1>=0&&arr[x][y-1]==0)
				{
					arr[x][y-1]=1;
					tq.add(new Pair(x,y-1));
					unripe--;
				}
				if(x+1<N&&arr[x+1][y]==0)
				{
					arr[x+1][y]=1;
					tq.add(new Pair(x+1,y));
					unripe--;
				}
				if(y+1<M&&arr[x][y+1]==0)
				{
					arr[x][y+1]=1;
					tq.add(new Pair(x,y+1));
					unripe--;
				}
			}
			q=tq;
			tq=new LinkedList();
		}
		if(unripe!=0)
		{
			bw.write("-1\n");
		}
		else
		{
			bw.write(days+"\n");
		}
		bw.flush();
	}
}
class Pair
{
	int x,y;
	Pair(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}