import java.io.*;
import java.util.*;

//10:30
public class Main {
    static int min;
    static int K;
    static int[][] ops;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp=br.readLine().split(" ");

        int N=Integer.parseInt(tmp[0]);
        int M=Integer.parseInt(tmp[1]);
        K=Integer.parseInt(tmp[2]);

        int [][] arr=new int[N][M];

        for(int i=0;i<N;i++)
        {
            tmp=br.readLine().split(" ");

            for(int j=0;j<M;j++)
            {
                arr[i][j]=Integer.parseInt(tmp[j]);
            }
        }
        ops=new int[K][];
        for(int i=0;i<K;i++)
        {
            tmp=br.readLine().split(" ");
            int r=Integer.parseInt(tmp[0]);
            int c=Integer.parseInt(tmp[1]);
            int s=Integer.parseInt(tmp[2]);
            ops[i]=new int[]{r,c,s};
        }

        min=Integer.MAX_VALUE;

        dfs(0,0,arr);
        System.out.println(min);
    }
    static void dfs(int visited,int idx,int[][] arr)
    {
        if(idx>=K)
        {
            int res=Integer.MAX_VALUE;
            for(int i=0;i<arr.length;i++)
            {
                int sum=0;
                for(int j=0;j<arr[i].length;j++)
                {
                    sum+=arr[i][j];
                }
                if(res>sum)
                {
                    res=sum;
                }
            }
            if(res<min)
            {
                min=res;
            }
            return;
        }

        for(int i=0;i<K;i++)
        {
            if((visited&(1<<i))==0)
            {
                dfs(visited|(1<<i),idx+1,rotate(ops[i][0],ops[i][1],ops[i][2],arr));
            }
        }
    }
    static int[][] rotate(int r,int c,int s,int[][] arr)
    {
        int[] dy={0,1,0,-1};
        int[] dx={1,0,-1,0};
        int[][] res=new int[arr.length][];
        for(int i=0;i<arr.length;i++)
        {
            res[i]=arr[i].clone();
        }
        for(int st=1;st<=s;st++) {
            int minY = r - st-1;
            int minX = c - st-1;
            int maxY = r + st-1;
            int maxX = c + st-1;
            int dir=0;
            int ty=minY;
            int tx=minX;
            do
            {
                res[ty+dy[dir]][tx+dx[dir]]=arr[ty][tx];
                ty+=dy[dir];
                tx+=dx[dir];
                if((tx==maxX&&ty==maxY)||(tx==maxX&&ty==minY)||
                        (tx==minX&&ty==maxY)||(tx==minX&&ty==minY))
                {
                    dir++;
                }
            }while(tx!=minX||ty!=minY);
        }
//        for(int[] re:res)
//        {
//            System.out.println(Arrays.toString(re));
//        }
//        System.out.println();
        return res;
    }
}