import java.io.*;
import java.util.*;

class Solution {
	static char[][] map;
	static char[] DIR= {'^','>','v','<'};
	static int[] tank;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] tmp = br.readLine().split(" ");
			int H = Integer.parseInt(tmp[0]);
			int W = Integer.parseInt(tmp[1]);

			map = new char[H][W];
			tank=new int[3];
			for (int h = 0; h < H; h++) {
				String str = br.readLine();
				for (int i = 0; i < W; i++) {
					map[h][i]=str.charAt(i);
					for(int j=0;j<4;j++)
					{
						if(DIR[j]==map[h][i])
						{
							tank[0]=h;
							tank[1]=i;
							tank[2]=j;
						}
					}
				}
			}
			
			int N=Integer.parseInt(br.readLine());
			String str = br.readLine();
			for(int i=0;i<N;i++)
			{
				//System.out.print(str.charAt(i));
				switch(str.charAt(i))
				{
				case 'U':
					tank[2]=0;
					map[tank[0]][tank[1]]=DIR[0];
					if(tank[0]-1>=0&&map[tank[0]-1][tank[1]]=='.')
					{
						map[tank[0]-1][tank[1]]=DIR[0];
						map[tank[0]][tank[1]]='.';
						tank[0]--;
					}
					break;
				case 'D':
					tank[2]=2;
					map[tank[0]][tank[1]]=DIR[2];
					if(tank[0]+1<map.length&&map[tank[0]+1][tank[1]]=='.')
					{
						map[tank[0]+1][tank[1]]=DIR[2];
						map[tank[0]][tank[1]]='.';
						tank[0]++;
					}
					break;
				case 'L':
					tank[2]=3;
					map[tank[0]][tank[1]]=DIR[3];
					if(tank[1]-1>=0&&map[tank[0]][tank[1]-1]=='.')
					{
						map[tank[0]][tank[1]-1]=DIR[3];
						map[tank[0]][tank[1]]='.';
						tank[1]--;
					}
					break;
				case 'R':
					tank[2]=1;
					map[tank[0]][tank[1]]=DIR[1];
					if(tank[1]+1<map[0].length&&map[tank[0]][tank[1]+1]=='.')
					{
						map[tank[0]][tank[1]+1]=DIR[1];
						map[tank[0]][tank[1]]='.';
						tank[1]++;
					}
					break;
				case 'S':
					shoot();
					//print();
					break;
				}
			}
			System.out.print("#"+t+" ");
			print();
		}
	}
	static void shoot()
	{
		int[] dy= {-1,0,1,0};
		int[] dx= {0,1,0,-1};
		int dir=tank[2];
		int ty=tank[0]+dy[dir];
		int tx=tank[1]+dx[dir];
		
		while(ty>=0&&ty<map.length&&tx>=0&&tx<map[0].length)
		{
			if(map[ty][tx]=='#')
			{
				break;
			}
			else if(map[ty][tx]=='*')
			{
//				System.out.println("found *");
				map[ty][tx]='.';
				break;
			}
			ty+=dy[dir];
			tx+=dx[dir];
		}
	}
	static void print()
	{
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[0].length;j++)
			{					
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
