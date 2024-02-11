import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> maxq=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minq=new PriorityQueue<>();
        
        for(String op:operations)
        {
            String[] tmp=op.split(" ");
            
            int n=Integer.parseInt(tmp[1]);
            if(tmp[0].charAt(0)=='I')
            {
                maxq.add(n);
                minq.add(n);
            }
            else
            {
                if(minq.isEmpty()||maxq.isEmpty())
                {
                    continue;
                }
                if(n==1)
                {
                    int pop=maxq.poll();
                    minq.remove(pop);
                }
                else
                {
                    int pop=minq.poll();
                    maxq.remove(pop);
                }
                // System.out.println("max : "+maxq.toString());
                // System.out.println("min : "+minq.toString());
            }
        }
        
        if(minq.isEmpty())
        {
            return new int[] {0,0};
        }
        return new int[]{maxq.peek(),minq.peek()};
    }
}