//8
import java.util.*;
class Solution {
    static int[] sum;
    static boolean[][] visited;
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static int h,w;
    public int solution(int[][] land) {
        
        h=land.length;
        w=land[0].length;
        
        sum=new int[w];
        visited=new boolean[h][w];
        for(int i=0;i<h;i++)
        {
            for(int j=0;j<w;j++)
            {
                if(land[i][j]==1&&!visited[i][j])
                {
                   findOil(i,j,land); 
                }
            }
        }
        
        int max=0;
        for(int i=0;i<w;i++)
        {
            if(max<sum[i])
            {
                max=sum[i];
            }
        }
        
        System.out.println(Arrays.toString(sum));
        return max;
    }
    
    static void findOil(int y,int x,int[][] land)
    {
        Set<Integer> hs=new HashSet<>();
        
        Queue<int[]> q=new LinkedList<>();
        
        q.add(new int[]{y,x});
        visited[y][x]=true;
        hs.add(x);
        int oil=1;
        
        while(!q.isEmpty())
        {
            int[] cur=q.poll();
            
            
            for(int d=0;d<4;d++)
            {
                int ty=cur[0]+dy[d];
                int tx=cur[1]+dx[d];
                
                if(ty>=h||ty<0||tx>=w||tx<0||land[ty][tx]==0||visited[ty][tx])
                {
                    continue;
                }
                
                oil++;
                visited[ty][tx]=true;
                hs.add(tx);
                q.add(new int[]{ty,tx});
            }
        }
        
        for(int i:hs)
        {
            sum[i]+=oil;    
        }
        
        // System.out.println(oil);
        
    }
}