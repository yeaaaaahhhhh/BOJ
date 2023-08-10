import java.io.*;
import java.util.*;

class Solution {
    static int win,lose;
    static int[] teamA,teamB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {

            win=0;
            lose=0;

            String[] tmp = br.readLine().split(" ");

            boolean[] card=new boolean[19];
            teamA=new int[9];
            for(int i=0;i<9;i++)
            {
                teamA[i]=Integer.parseInt(tmp[i]);
                card[teamA[i]]=true;
            }
            int idxB=0;
            teamB=new int[9];
            for(int i=1;i<19;i++)
            {
                if(!card[i])
                {
                    teamB[idxB++]=i;
                }
            }

//            System.out.println(Arrays.toString(teamA));
//            System.out.println(Arrays.toString(teamB));
            dfs(0,0,0,0);
            System.out.println("#"+t+" "+win+" "+lose);
        }
    }

    static void dfs(int visited,int idx,int scoreA,int scoreB)
    {
        if(idx>=9){
            if(scoreA>scoreB)
            {
                win++;
            }
            else if(scoreB>scoreA) {
                lose++;
            }
            return;
        }

        for (int i=0;i<9;i++)
        {
            if((visited&(1<<i))==0)
            {
                if(teamA[idx]>teamB[i])
                {
                    dfs(visited|(1<<i),idx+1,scoreA+teamA[idx]+teamB[i],scoreB);
                }
                else {
                    dfs(visited|(1<<i),idx+1,scoreA,scoreB+teamA[idx]+teamB[i]);
                }
            }
        }
    }
}