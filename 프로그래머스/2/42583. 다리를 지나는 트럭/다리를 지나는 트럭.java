import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int t = 0;
        int sum=0,idx=0;
        Queue<int[]> q=new LinkedList();
        
        while(idx<truck_weights.length)
        {
            if(!q.isEmpty()&&q.peek()[1]+bridge_length<=t)
            {
                sum-=q.peek()[0];
                // System.out.println(t+"s "+Arrays.toString(q.peek()));
                q.poll();
            }
            if(sum+truck_weights[idx]<=weight&&q.size()<bridge_length)
            {
                
                sum+=truck_weights[idx];
                // System.out.println(truck_weights[idx]+" "+t);
                q.add(new int[] {truck_weights[idx++],t});
                if(idx==truck_weights.length)
                {
                    return t+bridge_length+1;
                }
            }
            t++;
        }
        
        return t;
    }
}