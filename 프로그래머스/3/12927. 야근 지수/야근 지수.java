class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int[] cnt=new int[50000];
        for(int i=0;i<works.length;i++)
        {
            cnt[works[i]-1]++;
        }
        
        for(int i=50000-1;i>=0;i--)
        {
            
            int done= cnt[i]<n?cnt[i]:n;
            if(i!=0)
            {
                cnt[i-1]+=done;
            }
            cnt[i]-=done;
            n-=done;

            if(n==0)
            {
                for(int j=0;j<=i;j++)
                {
                    answer+=(long)cnt[j]*Math.pow(j+1,2);
                }
                break;
            }
        }
        return answer;
    }
}