import java.util.*;
import java.io.*;
class node
{
	int v;
	node left;
	node right;
	node(int v)
	{
		this.v=v;
		left=null;
		right=null;
	}
}
public class Main
{
	static void postorder(node root,BufferedWriter bw) throws IOException
	{
		if(root.left!=null)
			postorder(root.left, bw);
		if(root.right!=null)
			postorder(root.right,bw);
		bw.write(root.v+"\n");
	}
	public static void main(String[] args) throws Exception
	{
		ArrayList<Integer> arr1=new ArrayList();
		input(arr1);
		node tree=getTree(arr1);
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		postorder(tree,bw);
		bw.flush();
	}
	static void input(ArrayList arr) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String tmp;
		while(!(tmp=br.readLine()).isEmpty())
		//백준용(null로 끝나는 입력값)while((tmp=br.readLine())!=null)
		{
			arr.add(Integer.parseInt(tmp));
		}
	}
	static node getTree(ArrayList<Integer> arr)
	{
		node root=new node(arr.get(0));
		for(int i=1;i<arr.size();i++)
		{
			node parent=root;
			while(true)
			{
				if(parent.v>arr.get(i))
				{
					if(parent.left==null)
					{
						parent.left=new node(arr.get(i));
						break;
					}
					else
					{
						parent=parent.left;
					}
				}
				else
				{
					if(parent.right==null)
					{
						parent.right=new node(arr.get(i));
						break;
					}
					else
					{
						parent=parent.right;
					}
				}
			}
		}
		return root;
	}
	
	
}