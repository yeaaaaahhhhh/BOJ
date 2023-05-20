//11:15까지
import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        Queue<Integer> del=new LinkedList<Integer>();
        Queue<Integer> pu=new LinkedList<Integer>();
        for(int i=n-1;i>=0;i--)
        {
            if(pickups[i]>0)
            {
                pu.add(i);
            }
            if(deliveries[i]>0)
            {
                del.add(i);
            }
        }
        while(!del.isEmpty()||!pu.isEmpty())
        {
            int c=0;
            if(del.isEmpty())
            {
            	answer+=pu.peek()+1;
            }
            else if(pu.isEmpty())
            {
            	answer+=del.peek()+1;
            }
            else {
            	answer+=Math.max(del.peek(),pu.peek())+1;
            }
            while(c<cap&&!del.isEmpty())
            {
            	if(deliveries[del.peek()]>cap-c)
            	{
            		deliveries[del.peek()]-=cap-c;
            		c=cap;
            	}
            	else
            	{
            		c+=deliveries[del.peek()];
            		deliveries[del.poll()]=0;
            	}
            }
            c=0;
            while(c<cap&&!pu.isEmpty())
            {
            	if(pickups[pu.peek()]>cap-c)
            	{
            		pickups[pu.peek()]-=cap-c;
            		c=cap;
            	}
            	else
            	{
            		c+=pickups[pu.peek()];
            		pickups[pu.poll()]=0;
            	}
            }
            // for(int i:deliveries)
            // {
            //     System.out.print(i+" ");
            // }
            // System.out.println();
            // for(int i:pickups)
            // {
            //     System.out.print(i+" ");
            // }
            // System.out.println();
            // System.out.println(answer);

        }
        return answer*2;
    }
}