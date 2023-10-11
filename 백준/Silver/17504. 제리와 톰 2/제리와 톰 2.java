import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        
        int a[]=new int[N];
        
        String[] tmp=br.readLine().split(" ");
        for(int i=0;i<N;i++)
        {
        	a[i]=Integer.parseInt(tmp[i]);
        }
        
        long son=1;
        long mom=a[N-1];
        for(int i=N-2;i>=0;i--)
        {
        	son+=a[i]*mom;
        	long swap=son;
        	son=mom;
        	mom=swap;
        }
        
        //System.out.println(son+" "+mom);
        long[] res=new long[] {mom-son,mom};
        
        long A=mom;
        long B=mom-son;
        
        //gdc(A,B)
        while(B!=0)
        {
        	long remain=A%B;
        	A=B;
        	B=remain;
        	//System.out.println(A+" "+B);
        }
        
        if(A!=0)
        {
        	res[0]/=A;
        	res[1]/=A;
        }
        
        System.out.println(res[0]+" "+res[1]);
    }

}