import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer=0;
        int cnt=0;
        boolean[] visited=new boolean[n];
        Queue<Integer> q=new LinkedList<>();

        
        for(int k=0;k<n;k++){
            
            if(visited[k])
            {
                continue;
            }
            q.add(k);
            visited[k]=true;
            while(!q.isEmpty())
            {
                int cur=q.poll();
                for(int i=0;i<n;i++)
                {
                    if(cur!=i&&computers[cur][i]==1&&!visited[i])
                    {
                        q.add(i);
                        visited[i]=true;
                        cnt++;
                    }
                }
            }
            answer++;
            
        }
        return answer;
    }
}