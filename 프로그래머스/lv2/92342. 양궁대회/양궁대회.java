import java.util.ArrayList;
import java.io.*;
class Solution {
    static int maxScore=0;
    static ArrayList<int[]> arr=new ArrayList<int[]>();
    public int[] solution(int n, int[] info) {
        
        int[] shots= new int[11];
        bfs(0,0,n,info,shots);
        if(arr.isEmpty())
        {
            
            return new int[] {-1};
        }
        int area=0;
        int score=0;
        int res=0;
        for(int k=0;k<arr.size();k++)
        {
            int[] tmp=arr.get(k);
            for(int i=10;i>=0;i--)
            {
                if(tmp[i]!=0&&area<=i)
                {
                    if(area<i)
                    {
                        area=i;
                        score=tmp[i];
                    }
                    else if(score<tmp[i])
                    {
                        score=tmp[i];
                    }
                    res=k;
                    break;
                }
            }
        }
        return arr.get(res);
    }
    static void bfs(int area,int shot,int n,int[] info,int[] shots)
    {
        if(shot==n||area>10)
        {
            int apeach=0;
            int lion=0;
            for(int i=0;i<10;i++)
            {
                if(info[i]>shots[i])
                {
                    apeach+=10-i;
                }
                else if(info[i]==shots[i])
                {
                    if(info[i]!=0)
                    {
                        apeach+=10-i;
                    }
                }
                else
                {
                    lion+=10-i;
                }
            }
            if(lion>apeach&&lion-apeach>=maxScore)
            {
                if(lion-apeach!=maxScore)
                {
                    System.out.println(lion-apeach);
                    arr.clear();
                    maxScore=lion-apeach;
                }
                arr.add(shots);
            }
            return;
        }
        bfs(area+1,shot,n,info,shots);
        if(info[area]+1+shot<=n)
        {
            int[] ns=shots.clone();
            ns[area]=info[area]+1;
            bfs(area+1,shot+info[area]+1,n,info,ns);
        }
        if(area==10&&shot<n)
        {
            int[] ns=shots.clone();
            ns[area]=n-shot;
            bfs(area+1,n,n,info,ns);
        }
        
    }
}