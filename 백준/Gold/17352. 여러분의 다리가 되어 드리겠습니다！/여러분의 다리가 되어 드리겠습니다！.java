import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        
        parent=new int[N];
        //init
        for(int i=0;i<N;i++)
        {
        	parent[i]=i;
        }
        for(int n=0;n<N-2;n++)
        {
        	String[] tmp=br.readLine().split(" ");
        	int a=Integer.parseInt(tmp[0])-1;
        	int b=Integer.parseInt(tmp[1])-1;
        	
        	
        	int para=findAnce(a);
        	int parb=findAnce(b);
        	if(para<parb) parent[parb]=para;
        	else parent[para]=parb;
        }
        //System.out.print(Arrays.toString(parent));
        
        for(int i=0;i<N;i++)
        {
        	parent[i]=findAnce(i);
        	if(parent[i]!=0)
        	{
        		System.out.print("1 "+(i+1));
        		return;
        	}
        }
        //System.out.println(Arrays.toString(parent));
    }
    static int findAnce(int i)
    {
    	while(true)
    	{
    		if(parent[parent[i]]==parent[i])
    		{
    			return parent[i];
    		}
    		parent[i]=parent[parent[i]];
    	}
    }
}