import java.util.*;
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int N=lock.length;
        int M=key.length;
        int len=N+2*M-2;
        int[][] map=new int[len][len];
        for(int i=0;i<len;i++){
            Arrays.fill(map[i],1);
        }
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                map[M-1+i][M-1+j]=lock[i][j];
            }
        }
        // for(int i=0;i<len;i++)
        // {
        //     System.out.println(Arrays.toString(map[i]));
        // }
        
        
        for(int i=0;i<4;i++){
            for(int y=0;y<M-1+N;y++)
            {
                stg:for(int x=0;x<M-1+N;x++)
                {
                    // System.out.println("y x : "+y+" "+x);
                    for(int r=0;r<N;r++)
                    {
                        for(int c=0;c<N;c++)
                        {
                            int ky=M-1-y+r;
                            int kx=M-1-x+c;
                            int ly=M-1+r;
                            int lx=M-1+c;
                            // System.out.println(ky+" "+kx+": "++ly+" "+lx);
                            if(ky<0||ky>=M||kx<0||kx>=M)
                            {
                                if(map[ly][lx]==1)
                                    continue;
                                else
                                    continue stg;
                            }
                            if(ly<M-1||ly>M-1+N||lx<M-1||lx>M-1+N)
                            {
                                continue;
                            }
                            
                            if(key[ky][kx]==map[ly][lx])
                            {
                                continue stg;
                            }
                            
                        }
                    }
                    System.out.println(y+" "+x);
                    return true;
                }
            }
            key=turnClock(key);
        }
        return false;
    }
    static int[][] turnClock(int[][] arr)
    {
        int N=arr.length;
        int[][] res=new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                res[j][N-i-1]=arr[i][j];
            }
        }
        System.out.println("turn");
        for(int i=0;i<N;i++)
        {
            System.out.println(Arrays.toString(res[i]));
        }
        return res;
    }
}