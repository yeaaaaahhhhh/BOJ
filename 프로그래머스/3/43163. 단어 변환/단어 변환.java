
class Solution {
    static boolean[] visited;
    static int res=Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited=new boolean[words.length];
        dfs(words,begin,target,0);
        if(res==Integer.MAX_VALUE)
        {
            res=0;
        }
        return res;
    }
    static void dfs(String[] words,String begin,String target,int depth)
    {
        if(depth>res)
        {
            return;
        }
        if(begin.equals(target))
        {
            if(res>depth)       
            {
                System.out.println(begin+" "+target);
                res=depth;
            }
            return;
        }
    

        for(int i=0;i<words.length;i++)
        {
            if(!visited[i]&&canChange(begin,words[i]))
            {
                visited[i]=true;
                dfs(words,words[i],target,depth+1);
                visited[i]=false;
            }
        }   
    }

    static boolean canChange(String a,String b)
    {
        int cnt=0;
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)!=b.charAt(i))
            {
                if(++cnt>1)
                {
                    return false;
                }
            }
        }
        return true;
    }

}