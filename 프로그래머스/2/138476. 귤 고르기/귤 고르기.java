import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer,Integer> map=new HashMap();
        
        for(int i=0;i<tangerine.length;i++)
        {
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        ArrayList<Integer> list=new ArrayList(map.keySet());
        Collections.sort(list,new Comparator<Integer>(){
            public int compare(Integer a,Integer b)
            {
                return map.get(b)-map.get(a);
            }
        });
        int cnt=0;
        
        for(int i=0;i<list.size();i++)
        {
            int max=list.get(i);
            cnt+=map.get(max);
            // System.out.println(max+" "+cnt);
            if(cnt>=k)
            {
                return i+1;
            }
        }
        
        return 0;
    }
}