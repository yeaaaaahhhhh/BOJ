import java.io.*;
class Main
{
	static int N,M,R;
	static int[][] arr;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		String[] tmp=br.readLine().split(" ");
		N=Integer.parseInt(tmp[0]);
		M=Integer.parseInt(tmp[1]);
		R=Integer.parseInt(tmp[2]);
		arr=new int[N][M];
		for(int i=0;i<N;i++)
		{
			tmp=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				arr[i][j]=Integer.parseInt(tmp[j]);
			}
		}
		tmp=br.readLine().split(" ");
		for(int i=0;i<R;i++)
		{
			int menu=Integer.parseInt(tmp[i]);
			switch (menu)
			{
				case 1:
					upsideDown();
					break;
				case 2:
					leftsideRight();
					break;
				case 3:
					rightRotate();
					break;
				case 4:
					leftRotate();
					break;
				case 5:
					blockRotate();
					break;
				case 6:
					blockLotate();
					break;
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				bw.write(arr[i][j]+" ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void upsideDown()
	{
		int[][] tmp=new int[arr.length][arr[0].length];
		for(int i=0;i<arr.length;i++)
		{
			tmp[i]=arr[arr.length-i-1];
		}
		arr=tmp;
	}
	static void leftsideRight()
	{
		int[][] tmp=new int[arr.length][arr[0].length];
		for(int j=0;j<arr[0].length;j++)
		{
			for(int i=0;i<arr.length;i++)
			{
				tmp[i][j]=arr[i][arr[0].length-j-1];
			}
		}
		arr=tmp;
	}
	static void rightRotate()
	{
		int[][] tmp=new int[arr[0].length][arr.length];
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				tmp[j][arr.length-i-1]=arr[i][j];
			}
		}
		arr=tmp;
	}
	static void leftRotate()
	{
		int[][] tmp=new int[arr[0].length][arr.length];
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				tmp[arr[0].length-j-1][i]=arr[i][j];
			}
		}
		arr=tmp;
	}
	static void blockRotate()
	{
		int[][] tmp=new int[arr.length][arr[0].length];
		int px=0;
		int py=0;
		int nx=0;
		int ny=arr[0].length/2;
		for(int k=0;k<4;k++){
			if(k!=0)
			{
				px=nx;
				py=ny;
			if(k==1)
			{
				nx=arr.length/2;
				ny=arr[0].length/2;
			}else if(k==2)
			{
				nx=arr.length/2;
				ny=0;

			}else if(k==3)
			{
				nx=0;
				ny=0;
			}}
			for(int i=0;i<arr.length/2;i++)
			{
				for(int j=0;j<arr[0].length/2;j++)
				{
					tmp[i+nx][j+ny]=arr[i+px][j+py];
				}
			}
		}
		arr=tmp;
	}
	static void blockLotate()
	{
		int[][] tmp=new int[arr.length][arr[0].length];
		for(int k=0;k<4;k++){
			int x1,y1,x2,y2;
			if(k==0)
			{
				x1=0;y1=0;x2=arr.length/2;y2=0;
			}
			else if(k==1)
			{
				x1=arr.length/2;y1=0;x2=arr.length/2;y2=arr[0].length/2;
			}
			else if(k==2)
			{
				x1=arr.length/2;y1=arr[0].length/2;x2=0;y2=arr[0].length/2;
			}
			else
			{
				x1=0;y1=arr[0].length/2;x2=0;y2=0;
			}

			for(int i=0;i<arr.length/2;i++)
			{
				for(int j=0;j<arr[0].length/2;j++)
				{
					tmp[i+x2][j+y2]=arr[i+x1][j+y1];
				}
			}
		}
		arr=tmp;
	}
}