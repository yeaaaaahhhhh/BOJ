import java.io.*;
//9:20 시작
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] tmp=br.readLine().split(" ");
        int N=Integer.parseInt(tmp[0]);
        int M=Integer.parseInt(tmp[1]);

        tmp=br.readLine().split(" ");
        int[] arr=new int[N];
        int r=0;
        for(int i=0;i<N;i++)
        {
            arr[i]=Integer.parseInt(tmp[i]);
            r+=arr[i];
        }

        int l=1;
        while(l<r)
        {
            int m=l+(r-l)/2;

            boolean flag=true;

            int[] ray=new int[M];
            int idx=0;
            for(int i=0;i<N;i++)
            {
                if(arr[i]>m)
                {
                    flag=false;
                    break;
                }
                if(ray[idx]+arr[i]>m) {
                    idx++;
                    if(idx>=M) {
                        flag=false;
                        break;
                    }
                }
                ray[idx]+=arr[i];
            }
            if(!flag)//저장불가, 파일크기가 작음
            {
                l=m+1;
            }
            else {
                r=m;
            }
            //System.out.println(l+" "+r+" "+m);
        }
        System.out.println(l);
    }

}

