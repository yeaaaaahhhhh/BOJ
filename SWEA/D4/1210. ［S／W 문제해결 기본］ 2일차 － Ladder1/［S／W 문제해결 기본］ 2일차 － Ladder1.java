import java.util.*;
import java.io.*;
class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++)
		{
			int T=Integer.parseInt(br.readLine());
			int[][] map=new int[100][100];

			int x=0,y=0;
			for(int i=0;i<100;i++)
			{
				String[] tmp=br.readLine().split(" ");
				for(int j=0;j<100;j++)
				{
					map[i][j]=Integer.parseInt(tmp[j]);
					if(i==99&&map[i][j]==2)
					{
						y=i;
						x=j;
//						System.out.println("출발"+y+" "+x);
					}
				}
			}
			while(y>0)
			{
				if(x-1>=0&&map[y][x-1]==1)
				{
					while(x-1>=0)
					{
						x--;
						if(map[y-1][x]==1)
						{
							break;
						}
					}
				}
				else if(x+1<100&&map[y][x+1]==1)
				{
					while(x+1>=0)
					{
						x++;
						if(map[y-1][x]==1)
						{
							break;
						}
					}
				}
				y--;
			}
			System.out.println("#"+t+" "+x);
		}
		

	}
}
