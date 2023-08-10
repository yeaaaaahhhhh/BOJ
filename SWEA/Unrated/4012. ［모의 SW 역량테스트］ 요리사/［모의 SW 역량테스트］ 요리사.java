import java.io.*;
import java.util.*;

class Solution {
    static int[][] arr;
    static int N;
    static int min;
    static boolean[] team;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][];
            min=Integer.MAX_VALUE;

            for(int i=0;i<N;i++)
            {
                arr[i]=new int[i+1];
            }

            for(int i=0;i<N;i++)
            {
                String[] tmp = br.readLine().split(" ");

                for(int j=0;j<N;j++)
                {
                    if(i>j)
                    {
                        arr[i][j]+=Integer.parseInt(tmp[j]);
                    }
                    else {
                        arr[j][i]+=Integer.parseInt(tmp[j]);
                    }
                }
            }
            team=new boolean[N];
            team[0]=true;
            dfs(1,1);

            System.out.println("#"+t+" "+min);
        }
    }

    static void dfs(int idx,int people)
    {
        if(idx==N){
            if(people==N/2)
            {
                //System.out.println(Arrays.toString(team));
                int idxA=0,idxB=0;
                int[] teamA=new int[N/2];
                int[] teamB=new int[N/2];
                for(int i=0;i<N;i++)
                {
                    if(team[i]==true)
                    {
                        teamA[idxA++]=i;
                    }
                    else {
                        teamB[idxB++]=i;
                    }
                }
                int sumA=getSum(teamA);
                int sumB=getSum(teamB);
                //System.out.println(sumA+" "+sumB);
                if(min>Math.abs(sumA-sumB))
                {
                    min=Math.abs(sumA-sumB);
                }

            }
            return;
        }
        //System.out.println(idx+" "+people);
        dfs(idx+1,people);
        team[idx]=true;
        dfs(idx+1,people+1);
        team[idx]=false;
    }
    static int getSum(int[] team)
    {
        int res=0;
        for(int i=N/2-1;i>0;i--)
        {
            for(int j=0;j<i;j++)
            {
                res+=arr[team[i]][team[j]];
            }
        }
        return res;
    }
}