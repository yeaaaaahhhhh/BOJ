class Solution {
    public int solution(int n) {
        int answer = 1;
        int sum=0;
        for(int i=1;i<n;i++)
        {
            sum+=i;
            if(sum>=n)
            {
                break;
            }
            if((n-sum)%(i+1)==0)
            {
                answer++;
            }
        }
        return answer;
    }
}