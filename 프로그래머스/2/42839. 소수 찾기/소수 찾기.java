import java.util.*;
class Solution {
    static boolean[] sieve;
    static ArrayList<Integer> list;
    public int solution(String numbers) {
        int answer = 0;
        final int MAX_NUM=10000001;
        sieve=new boolean[MAX_NUM];
        list=new ArrayList<Integer>();
        sieve[0]=true;
        sieve[1]=true;
        for(int i=2;i<MAX_NUM;i++)
        {
            if(sieve[i])
            {
                continue;
            }
            int mlt=2;
            while(true)
            {
                int res=i*mlt;
                if(res>=MAX_NUM)
                    break;
                sieve[res]=true;
                mlt++;
            }
        }
        
        int[] num=new int[10];
        for(int i=0;i<numbers.length();i++)
        {
            num[numbers.charAt(i)-'0']++;
        }
        
        dfs(num,0,0,numbers.length());
        
        //System.out.println(list.toString());
        
        for(int li:list)
        {
            if(!sieve[li])
                answer++;
        }
        return answer;
    }
    static void dfs(int[] num,int sum,int stg,int len)
    {
        if(!list.contains(sum))
            list.add(sum);
        if(stg==len)
        {
            return;    
        }
        for(int i=0;i<10;i++)
        {
            if(num[i]>0)
            {
                num[i]--;
                dfs(num,sum*10+i,stg+1,len);
                num[i]++;
            }
        }
        
    }
}