//11시
//목표 1. 사용자별 금액 맞추기
//할인을 하되,
//목표 2. 판매액 증가 => 플러스 가입안한사람에게도 할인
class Solution {
    static int[] bought;
    //static int crtSum=0;
    static int membership=0;
    static int earned=0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer=new int[2];
        bought=new int[users.length];
        dfs(0,emoticons.length,users,emoticons);
        answer[0]=membership;
        answer[1]=earned;
        return answer;
    }
    static void dfs(int stg,int N,int[][] users,int[] emoticons)
    {
        if(stg>=N)
        {
            int memN=0;
            int sum=0;
            for(int i=0;i<users.length;i++)
            {
                if(bought[i]>=users[i][1])
                {
                    memN++;
                }
                else
                {
                    sum+=bought[i];
                }
            }
            if(memN>membership||(memN==membership&&sum>earned))
            {
                membership=memN;
                earned=sum;
                //System.out.println(memN+" "+sum);
            }
            return;    
        }
        int[] tBought=bought.clone();
        int emoji=emoticons[stg];
        for(int i=0;i<users.length;i++)
        {
            if(users[i][0]<=10)
            {
                bought[i]+=emoji*0.9;
            }
        }
        dfs(stg+1,N,users,emoticons);
        bought=tBought.clone();
        for(int i=0;i<users.length;i++)
        {
            if(users[i][0]<=20)
            {
                bought[i]+=emoji*0.8;
            }
        }
        dfs(stg+1,N,users,emoticons);
        
        bought=tBought.clone();
        for(int i=0;i<users.length;i++)
        {
            if(users[i][0]<=30)
            {
                bought[i]+=emoji*0.7;
            }
        }
        dfs(stg+1,N,users,emoticons);
        
        bought=tBought.clone();
        for(int i=0;i<users.length;i++)
        {
            if(users[i][0]<=40)
            {
                bought[i]+=emoji*0.6;
            }
        }
        dfs(stg+1,N,users,emoticons);
        //bought=tBought.clone();
    }
}