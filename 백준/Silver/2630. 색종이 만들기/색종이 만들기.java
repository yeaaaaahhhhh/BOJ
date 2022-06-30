import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int[][] arr;
	static int[] paper=new int[2];
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		
		
		for(int i=0;i<N;i++)
		{
			String[] tmp=br.readLine().split(" ");			
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(tmp[j]);
			}
			
		}
		func(0,0,N);
		bw.write(paper[0]+"\n"+paper[1]);
		bw.flush();
		bw.close();
		br.close();
	}
	static void func(int x,int y,int size)
	{
		int color=arr[x][y];
		boolean check=false;
		for(int i=x;i<x+size;i++)
		{
			for(int j=y;j<y+size;j++)
			{
				if(arr[i][j]!=color)
				{
					check=true;
					break;
				}
			}
		}
		if(check)
		{
			func(x,y,size/2);
			func(x,y+size/2,size/2);
			func(x+size/2,y,size/2);
			func(x+size/2,y+size/2,size/2);
		}
		else
		{
			paper[color]+=1;
		}
	}

}