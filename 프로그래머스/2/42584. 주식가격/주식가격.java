import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] res=new int[prices.length];
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();

        for(int t=0;t<prices.length;t++)
        {
            while(!st.isEmpty()&&st.peek()>prices[t])
            {
                int pop=st.pop();
                for(Integer time:hm.get(pop))
                {
                    res[time]=t-time;
                }
                hm.remove(pop);
            }
            
            if(!st.isEmpty()&&st.peek()==prices[t])
            {
                hm.get(prices[t]).add(t);
            }
            else
            {
                st.push(prices[t]);
                hm.put(prices[t],new ArrayList<Integer>());
                hm.get(prices[t]).add(t);
            }
        }
        
        while(!st.isEmpty())
        {
            int pop=st.pop();
            for(Integer time:hm.get(pop))
            {
                res[time]=prices.length-1-time;
            }
            hm.remove(pop);
        }
        // System.out.println(hm);
        return res;
    }
}