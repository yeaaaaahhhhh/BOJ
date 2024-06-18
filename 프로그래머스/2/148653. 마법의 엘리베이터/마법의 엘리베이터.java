class Solution {
    static int answer;
    public int solution(int storey) {
        answer=storey;
        dfs(storey,0);
        return answer;
    }
    public void dfs(int num,int cnt)
    {
        if(num==0)
        {
            if(answer>cnt)
                answer=cnt;
            return;
        }
        
        int cur=num%10;
        
        if(cur==5)
        {
            dfs(num/10,cnt+5);
            dfs(num/10+1,cnt+5);
        }
        else
        {
            if(cur<5)
            {
                dfs(num/10,cnt+cur);
            }
            else
            {
                dfs(num/10+1,cnt+10-cur);
            }
        }
    }
}

// -2000 -500 -50 -4
//5555
//5556 => +4 +4 +4 +6

//54 = 9 or 11
//15 = 6 or 7
//55 = 10 or 9
//45 = 
//16 = 7 or 6
//56 = 11 or 10