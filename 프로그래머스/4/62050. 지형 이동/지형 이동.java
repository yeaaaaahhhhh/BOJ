import java.util.*;
class Solution {

    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static boolean[][] visited;
    public int solution(int[][] land, int height) {
        int answer = 0;
        
        visited=new boolean[land.length][land[0].length];
        Queue<int[]> q=new LinkedList<int[]>();
        q.add(new int[] {0,0});
        PriorityQueue<int[]> unreachable=new PriorityQueue<int[]>((A,B)->A[2]-B[2]);
        while(!q.isEmpty())
        {
            while(!q.isEmpty())
            {
                int[] cur=q.poll();
                int y=cur[0];
                int x=cur[1];

                if(visited[y][x])
                {
                    continue;
                }
                visited[y][x]=true;

                for(int d=0;d<4;d++)
                {
                    int ty=y+dy[d];
                    int tx=x+dx[d];
                    if(ty<0||tx<0||ty>=land.length||tx>=land[0].length||visited[ty][tx])
                    {
                        continue;
                    }

                    int diff=Math.abs(land[y][x]-land[ty][tx]);

                    if(diff<=height)
                    {
                        q.add(new int[]{ty,tx});                   
                    }

                    else
                    {
                        unreachable.add(new int[]{ty,tx,diff});
                    }
                }
            }
            while(!unreachable.isEmpty())
            {
                int[] tmp=unreachable.poll();
                if(!visited[tmp[0]][tmp[1]])
                {
                    q.add(new int[]{tmp[0],tmp[1]});
                    answer+=tmp[2];
                    break;
                }
            }
        }
        return answer;
    }
}