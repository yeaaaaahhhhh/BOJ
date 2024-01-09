import java.util.*;
class Solution {
    static int n;
    static int[][] route;
    static int max;
    static boolean[][] visited;
    static int[] pinfo;
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        n=info.length;
        route=new int[n][3];
        visited=new boolean[1<<n][n];
        pinfo=info;
        int len=(1<<n)-1;
        //System.out.println((1<<n)-1);
        
        for(int i=0;i<n;i++)
        {
            Arrays.fill(route[i],-1);
        }
        for(int i=0;i<n-1;i++)
        {
            int par=edges[i][0];
            int chd=edges[i][1];
            
            route[chd][0]=par;
            
            //왼쪽 자식 없음
            if(route[par][1]==-1)
            {
                route[par][1]=chd;
            }
            else
            {
                route[par][2]=chd;
            }
            
        }
        
        dfs(0,1,0,1);
        return max;
    }
    static void dfs(int node,int sheep,int wolf,int status)
    {
        if(sheep<=wolf)
        {
            return;
        }
        //System.out.println(node+" "+sheep+" "+wolf+" "+Integer.toBinaryString(status));
        int tinfo=pinfo[node];
        pinfo[node]=-1;
        if(max<sheep)
        {
            max=sheep;
        }
        for(int i=0;i<3;i++)
        {
            int dest=route[node][i];
            if(dest==-1||visited[status][dest])
            {
                continue;    
            }
            visited[status][dest]=true;
            if(pinfo[dest]==0)//양
            {
                dfs(dest,sheep+1,wolf,status+(1<<dest));   
            }
            else if(pinfo[dest]==1)//늑대
            {
                dfs(dest,sheep,wolf+1,status);
            }
            else
            {
                dfs(dest,sheep,wolf,status);
            }
        }
        pinfo[node]=tinfo;
    }
}