import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp=br.readLine().split(" ");
        long[] arr=new long[3];
        for(int i=0;i<3;i++)
        {
        	arr[i]=Integer.parseInt(tmp[i]);
        }
        System.out.println(pow(arr[0],arr[1],arr[2]));
    }
    static long pow(long A,long B,long C)
    {
    	long res=1;
  
    	while(B>0)
    	{
    		if(B%2==1)
    		{
    			res=(res*A)%C;
    		}
    		B=B>>1;
    		A=(A*A)%C;
    	}
    	return res;
    }
}