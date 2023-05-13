import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			System.out.println("#" + test_case);
			int[][] arr = new int[N][N];
			int i = 1;
			int dir = 0;
			int x=0,y=0;
			arr[0][0]=1;
			while (i < N * N) {
				switch (dir) {
				case 0: 
					while(y+1<N&&arr[x][y+1]==0)
					{
						arr[x][++y]=++i;
					}
					break;
				case 1: 
					while(x+1<N&&arr[x+1][y]==0)
					{
						arr[++x][y]=++i;
					}
					break;
				case 2: 
					while(x-1>=0&&arr[x-1][y]==0)
					{
						arr[--x][y]=++i;
					}
					break;
				case 3: 
					while(y-1>=0&&arr[x][y-1]==0)
					{
						arr[x][--y]=++i;
					}
					break;
				}
				dir=(dir+1)%4;
			}
			for(int[] ta:arr)
			{
				for(int a:ta)
				{
					System.out.print(a+" ");
				}
				System.out.println();
			}
		}
	}
}