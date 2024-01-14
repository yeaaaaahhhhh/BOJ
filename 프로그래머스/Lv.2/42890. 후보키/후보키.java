import java.util.*;
class Solution {
    static int cnt=0;
    
    public int solution(String[][] rel) {
        
        int len=rel[0].length;
        boolean[] visited=new boolean[1<<len];
        ArrayList<Integer> used=new ArrayList<>();//사용된 조합 리스트
        
        //System.out.println(Integer.toBinaryString(1<<len));
        // for(String[] r:rel)
        //     System.out.println(Arrays.toString(r));
        
        
        //bfs 큐 구성 : 길이,stat(비트마스킹)
        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->{
           return o1[0]-o2[0];
        });
        for(int i=0;i<len;i++)
        {
            q.add(new int[]{1,(1<<i)});
            visited[1<<i]=true;
        }
        
        qRe:while(!q.isEmpty())
        {
            int[] cur=q.poll();
            HashSet<String> hs=new HashSet<>();
            
            //최소성 만족하는지 확인
            for(int use:used)
            {
                if((use&cur[1])==use)
                {
                    continue qRe;
                }
            }
            
            //유일성 만족하는지 확인
            boolean unique=true;
            for(int j=0;j<rel.length;j++)
            {
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<len;i++)
                {
                    if((cur[1]&(1<<i))>0)
                    {
                        sb.append(rel[j][i]);
                    }
                }
                String nstr=sb.toString();
                if(hs.contains(nstr))
                {
                    unique=false;
                    break;
                }
                hs.add(nstr);
            }
            //후보 키이면 used에 추가
            if(unique)
            {
                used.add(cur[1]);
            }
            //아니면 bfs 추가 탐색
            else
            {
                 for(int i=0;i<len;i++)
                {
                    int nstat=(cur[1]|(1<<i));
                    if(!visited[nstat])
                    {
                        q.add(new int[]{cur[0]+1,nstat});
                        visited[nstat]=true;
                    }
                }
            }
        }
        
        // dfs(0,1,new ArrayList<String>(),0);
        return used.size();
    }
    
}