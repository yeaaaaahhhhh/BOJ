import java.util.*;
import java.util.stream.Stream;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		
		int[][] map=new int[n][n];
		for(int i=0;i<n;i++)
		{
			Arrays.fill(map[i], 101);
			map[i][i]=0;
		}
		for(int i=0;i<m;i++)
		{
			tmp=br.readLine().split(" ");
			
			int a =Integer.parseInt(tmp[0])-1;
			int b =Integer.parseInt(tmp[1])-1;
			
			map[a][b]=1;
			map[b][a]=1;
		}
		
		for(int k=0;k<n;k++)
		{
			for(int x=0;x<n;x++)
			{
				for(int y=0;y<n;y++)
				{
					if(map[x][y]>map[x][k]+map[k][y])
					{
						map[x][y]=map[x][k]+map[k][y];
					}
				}
			}
		}
		
		int min=Integer.MAX_VALUE;
		int idx=-1;
		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=0;j<n;j++)
			{
				sum+=map[i][j];
			}
			if(sum<min)
			{
				min=sum;
				idx=i;
			}
		}
		System.out.println(idx+1);
	}

}