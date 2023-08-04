import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//8:35

//9:58 풀이 종료 => 1:25 소요
public class Main {
    static int[] dy={-1,1,0,0};
    static int[] dx={0,0,1,-1};
    static Shark[] sharks;
    static int R;
    static int C;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] tmp=br.readLine().split(" ");

        R=Integer.parseInt(tmp[0]);
        C=Integer.parseInt(tmp[1]);
        M=Integer.parseInt(tmp[2]);
        int[][] arr=new int[R][C];
        for(int i=0;i<R;i++)
            Arrays.fill(arr[i],-1);
        sharks=new Shark[M];
        for(int i=0;i<M;i++)
        {
            tmp=br.readLine().split(" ");
            int y=Integer.parseInt(tmp[0])-1;
            int x=Integer.parseInt(tmp[1])-1;
            int s=Integer.parseInt(tmp[2]);
            int d=Integer.parseInt(tmp[3])-1;
            int z=Integer.parseInt(tmp[4]);

            Shark cur=new Shark(y,x,s,d,z);
            sharks[i]=cur;
            arr[y][x]=i;
        }

        int res=0;
        for(int x=0;x<C;x++) {
            int caught = fishing(x, arr);
            if (caught != -1) {
                sharks[caught].dead = true;
                res += sharks[caught].z;
                //System.out.println(sharks[caught].y + " " + sharks[caught].x);
            }
            arr = moveSharks();
//            for (int i = 0; i < R; i++) {
//                System.out.println(Arrays.toString(arr[i]));
//            }
        }
        System.out.println(res);
    }
    static int[][] moveSharks()
    {
        for(int i=0;i<M;i++)
        {
            if(sharks[i].dead)
            {
               continue;
            }
            int ty=sharks[i].y;
            int tx=sharks[i].x;
            int dir=sharks[i].d;
            //System.out.println("전 : "+ty+" "+tx+" "+dir);
            for(int j=0;j<sharks[i].s;j++)
            {
                if(ty+dy[dir]>=0&&ty+dy[dir]<R&&tx+dx[dir]>=0&&tx+dx[dir]<C)
                {
                    ty+=dy[dir];
                    tx+=dx[dir];
                }
                else {
                    j--;
                    if(dir==0)
                        dir=1;
                    else if(dir==1)
                        dir=0;
                    else if(dir==2)
                        dir=3;
                    else
                        dir=2;
                }
            }
            //System.out.println("후 : "+ty+" "+tx+" "+dir);
            sharks[i].y=ty;
            sharks[i].x=tx;
            sharks[i].d=dir;
        }
        int[][] arr=new int[R][C];
        for(int i=0;i<R;i++)
            Arrays.fill(arr[i],-1);

        for(int i=0;i<M;i++)
        {
            if(sharks[i].dead)
            {
               continue;
            }
            int y=sharks[i].y;
            int x=sharks[i].x;
            //상어 두마리 만남.
            if(arr[y][x]!=-1)
            {
                if(sharks[i].z>sharks[arr[y][x]].z)
                {
                    sharks[arr[y][x]].dead=true;
                    arr[y][x]=i;
                }
                //기존이 더 큼(무게가 같으면 고려할 필요 없음)
                else {
                    sharks[i].dead = true;
                }
            }
            else {
                arr[y][x]=i;
            }
        }
        return arr;
    }
    static int fishing(int x,int[][] arr)
    {
        for(int i=0;i<R;i++)
        {
            if(arr[i][x]!=-1)
            {
                return arr[i][x];
            }
        }
        return -1;
    }
}
//최대 결과 1,000,000,000,000
class Shark
{
    int y;
    int x;
    int s;
    int d;
    int z;
    boolean dead;

    public Shark(int y, int x, int s, int d, int z) {
        this.y = y;
        this.x = x;
        this.s = s;
        this.d = d;
        this.z = z;
        this.dead=false;
    }
}