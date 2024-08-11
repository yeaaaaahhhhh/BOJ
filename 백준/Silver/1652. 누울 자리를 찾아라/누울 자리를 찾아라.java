import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
    	
    	int N=Integer.parseInt(br.readLine());
    	
    	boolean[][] map=new boolean[N][N];
    	for(int i=0;i<N;i++)
    	{
    		String[] tmp=br.readLine().split("");
    		for(int j=0;j<N;j++)
    		{
    			if(tmp[j].equals("."))
    			{
    				map[i][j]=false;
    			}
    			else
    			{
    				map[i][j]=true;
    			}
    		}
    	}
    	
    	//가로 구하기
    	
    	int horRes=0;
    	for(int i=0;i<N;i++)
    	{
    		int last=-1;
    		for(int j=0;j<N;j++)
    		{
    			if(map[i][j])
    			{
    				if(j-last>2)
    				{
    					horRes++;
    				}
    				last=j;
    			}
    		}
    		if(N-last>2)
			{
				horRes++;
			}
//    		System.out.println(i+" "+horRes);
    	}
    	
    	int verRes=0;
    	for(int i=0;i<N;i++)
    	{
    		int last=-1;
    		for(int j=0;j<N;j++)
    		{
    			if(map[j][i])
    			{
    				if(j-last>2)
    				{
    					verRes++;
    				}
    				last=j;
    			}
    		}
    		if(N-last>2)
			{
				verRes++;
			}
//    		System.out.println(i+" "+verRes);
    	}
    	
    	System.out.println(horRes+" "+verRes);
    }
}