//10:30
import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        final int MAXVAL=20000001;
        int[][] price=new int[n][n];
        // ArrayList<int[]>[] list=new ArrayList[n]; 
        
        //set
        for(int i=0;i<n;i++)
        {
            // list[i]=new ArrayList();
            Arrays.fill(price[i],MAXVAL);
            price[i][i]=0;
        }
        
        for(int[] fare:fares)
        {
            int st=fare[0]-1;
            int ds=fare[1]-1;
            int v=fare[2];
            price[st][ds]=v;
            price[ds][st]=v;
        }
        
        // for(int i=0;i<n;i++)        
        // {
        //     for(int[] arr:list[i]){
        //         System.out.print(Arrays.toString(arr)+" ");
        //     }
        //     System.out.println();
        // }
        for(int m=0;m<n;m++)
        {
            for(int y=0;y<n;y++)
            {
                for(int x=0;x<n;x++)
                {
                    price[x][y]=Math.min(price[x][y],price[x][m]+price[m][y]);
                    price[y][x]=price[x][y];
                }
            }
        }
        
        // for(int i=0;i<n;i++)        
        // {
        //     System.out.println(Arrays.toString(price[i]));
        // }
        
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(price[s-1][i]==MAXVAL||price[i][a-1]==MAXVAL||
              price[i][b-1]==MAXVAL)
            {
                continue;
            }
            int pr=price[s-1][i]+price[i][a-1]+price[i][b-1];
            if(res>pr)
            {
                res=pr;
            }
        }
        return res;
    }
}