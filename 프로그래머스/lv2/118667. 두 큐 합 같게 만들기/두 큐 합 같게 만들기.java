import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        Queue<Integer> q1=new LinkedList();
        Queue<Integer> q2=new LinkedList();
        
        long sum1=0;
        long sum2=0;
        
        int len=(queue1.length+queue2.length)*2;
        
        for(int i: queue1)
        {
        	q1.add(i);
        	sum1+=i;
        }
        for(int i: queue2)
        {
        	q2.add(i);
        	sum2+=i;
        }
        
        int cnt=0;
        while(!q1.isEmpty()||!q2.isEmpty())
        {
        	int v;
        	if(cnt>len)
        		break;
        	if(sum1>sum2)
        	{
        		v=q1.poll();
        		q2.add(v);
        		sum1-=v;
        		sum2+=v;
        		cnt++;
        	}
        	else if (sum1<sum2)
        	{
           		v=q2.poll();
        		q1.add(v); 
        		sum2-=v;
        		sum1+=v;
        		cnt++;
        	}
        	else
        	{
        		return cnt;
        	}
        }
        
        return -1;
    }
}