import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
    	String input= br.readLine();
    	
    	int[] cnt=new int[10];
    	
    	for(char ch:input.toCharArray()){
    		cnt[ch-'0']++;
    	}
    	
    	//System.out.println(Arrays.toString(cnt));
    	
    	StringBuilder sb=new StringBuilder();
    	
    	for(int i=9;i>=0;i--)
    	{
    		for(int j=0;j<cnt[i];j++)
    		{
    			sb.append((char)(i+'0'));
    		}
    	}
    	System.out.println(sb.toString());
    }
}