import java.util.*;
class Solution 
{
    public int solution(int[] priorities, int location) 
    {
        int answer = 0;
        int len=priorities.length;
        boolean[] visited=new boolean[len];
        
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<len;i++)
        {
            if(!list.contains(priorities[i]))
            {
                list.add(priorities[i]);
            }
        }
        Collections.sort(list);
        Collections.reverse(list);
        //System.out.println(list);
        
        int idx=0;
        int cnt=0;
        while(!list.isEmpty())
        {
            int max=list.get(0);
            int lidx=idx;
            for(int i=0;i<len;i++)
            {
                int cur=(idx+i)%len;
                if(!visited[cur]&&max==priorities[cur])
                {
                    cnt++;
                    if(cur==location)
                    {
                        return cnt;
                    }
                    visited[cur]=true;
                    lidx=cur;
                }
            }
            list.remove(0);
            idx=lidx;
        }
        return cnt;
    }
}