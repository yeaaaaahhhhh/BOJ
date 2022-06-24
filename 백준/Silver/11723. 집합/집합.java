import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] arr=new boolean[20];
		int M=Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++)
		{
			String[] tmp=br.readLine().split(" ");
			int n=0;
			if(tmp.length!=1)
				n=Integer.parseInt(tmp[1])-1;
			switch (tmp[0]) {
				case ("add"):
					arr[n]=true;
					break;
				case ("remove"):
					arr[n]=false;
					break;
				case ("check"):
					if(arr[n])
						bw.write(1+"\n");
					else
						bw.write(0+"\n");
					break;
				case ("toggle"):
					arr[n]=!(arr[n]);
					break;
				case ("all"):
					for(int j=0;j<20;j++)
					{
						arr[j]=true;
					}
					break;
				case ("empty"):
					for(int j=0;j<20;j++)
					{
						arr[j]=false;
					}
					break;
				}
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}