import java.io.*;
import java.util.*;

class Solution {
    static int[][] ingre;
    static int N,maxC;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            String[] tmp = br.readLine().split(" ");
            N = Integer.parseInt(tmp[0]);
            maxC = Integer.parseInt(tmp[1]);

            ingre = new int[N][2];
            max=0;
            for(int i=0;i<N;i++)
            {
                tmp=br.readLine().split(" ");
                ingre[i][0]=Integer.parseInt(tmp[0]);
                ingre[i][1]=Integer.parseInt(tmp[1]);
            }

            dfs(0,0,0);
            System.out.println("#"+t+" "+max);
        }
    }
    static void dfs(int idx,int cal,int taste)
    {
        if(cal>maxC)
        {
            return;
        }
        if(idx==N)
        {
            if(taste>max)
            {
                max=taste;
            }
            return;
        }
        dfs(idx+1,cal,taste);
        dfs(idx+1,cal+ingre[idx][1],taste+ingre[idx][0]);
    }
}