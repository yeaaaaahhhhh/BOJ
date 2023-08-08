import java.io.*;
import java.util.*;

class Main
{
	static int N,M,R;
	static int[][] arr;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] tmp=br.readLine().split(" ");
		N=Integer.parseInt(tmp[0]);
		M=Integer.parseInt(tmp[1]);
		R=Integer.parseInt(tmp[2]);
		
		arr=new int[N][M];
		
		for(int i=0;i<N;i++)
		{
			tmp=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				arr[i][j]=Integer.parseInt(tmp[j]);
			}
		}
		
		for(int step=0;step<Math.min(M, N)/2;step++)
		{
			Queue<Integer> q=new LinkedList();
			int xmin=step;
			int ymin=step;
			int xmax=N-step;
			int ymax=M-step;
			
			int x=step; 
			int y=step;
			while(y<ymax-1)
			{
				q.add(arr[x][y++]);
			}
			while(x<xmax-1)
			{
				q.add(arr[x++][y]);
			}
			while(y>ymin)
			{
				q.add(arr[x][y--]);
			}
			while(x>xmin)
			{
				q.add(arr[x--][y]);
			}
			
			//System.out.print(q.toString());
			for(int k=0;k<R;k++)
				q.add(q.poll());
			//System.out.print(q.toString());
			x=step;y=step;
			
			while(y<ymax-1)
			{
				arr[x][y++]=q.poll();
			}
			while(x<xmax-1)
			{
				arr[x++][y]=q.poll();
			}
			while(y>ymin)
			{
				arr[x][y--]=q.poll();
			}
			while(x>xmin)
			{
				arr[x--][y]=q.poll();
			}
		}
		
		for(int i=0; i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				bw.write(arr[i][j]+" ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}