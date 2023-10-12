class Solution {
    static int res=0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers,0,target,0);
        return res;
    }
    static void dfs(int[] numbers,int stg,int target,int sum)
    {
        if(stg==numbers.length)
        {
            if(target==sum)
            {
                res++;
            }
            return;
        }
        
        dfs(numbers,stg+1,target,sum-numbers[stg]);
        dfs(numbers,stg+1,target,sum+numbers[stg]);
    }
}