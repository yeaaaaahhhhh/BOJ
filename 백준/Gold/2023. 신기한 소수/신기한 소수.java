import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());

        func(0,N,0);
    }
    static void func(int idx,int N,int num)
    {
        if(idx>=N)
        {
            System.out.println(num/10);
            return;
        }
        for(int i=0;i<10;i++)
        {
            if(idx==0&&i==0)
            {
                i=2;
            }
            int cur=num+i;
            boolean flag=true;
            for(int j=2;j<Math.min(Math.sqrt(cur)+1,cur-1);j++)
            {
                if(cur%j==0)
                {
                    flag=false;
                    break;
                }
            }
            if(flag)
            {
                //System.out.println(cur);
                func(idx+1,N,cur*10);
            }
        }
    }
}
