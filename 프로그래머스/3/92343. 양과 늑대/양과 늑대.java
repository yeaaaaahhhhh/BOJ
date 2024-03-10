import java.util.*;
class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        ArrayList<Integer>[] map=new ArrayList[info.length];
        
        for(int i=0;i<info.length;i++)
        {
            map[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<edges.length;i++)
        {
            int par=edges[i][0];
            int chd=edges[i][1];
            map[par].add(chd);
            map[chd].add(par);
        }
        
        boolean[][] visited=new boolean[1<<info.length][info.length];
        
        Queue<State> q=new LinkedList();
        q.add(new State(1,0,0,1));
        visited[0][0]=true;
        
        while(!q.isEmpty())
        {
            State cur=q.poll();
            // System.out.println(cur);
            if(cur.s>answer)
            {
                answer=cur.s;
            }
            for(int chd:map[cur.loc])
            {

                State node=new State(cur.s,cur.w,chd,(cur.vst|(1<<chd)));
                //언제든 방문한적 없음
                if((cur.vst&(1<<chd))==0){
                    if(info[chd]==0)
                    {
                        node.s++;   
                    }
                    else
                    {
                        node.w++;
                    }
                }
                
                if(visited[node.vst][chd]||node.s<=node.w)
                {
                    continue;
                }
                
                q.add(node);
                visited[node.vst][chd]=true;
            }
        }
        return answer;
    }
}
class State{
    int s=0;
    int w=0;
    int loc;
    int vst;
    public State(int s,int w,int loc)
    {   
        this.s=s;
        this.w=w;
        this.loc=loc;
    }
    public State(int s,int w,int loc, int vst)
    {
        this.s=s;
        this.w=w;
        this.loc=loc;
        this.vst=vst;
    }
    public String toString()
    {
        return this.s+" "+this.w+" "+this.loc+" "+this.vst;
    }
}