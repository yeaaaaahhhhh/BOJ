import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int len=Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> st=new Stack<>();
			int res=1;
			for(int i=0;i<len;i++)
			{
				char c=str.charAt(i);
				switch(c)
				{
				case '{':
				case '[':
				case '(':
				case '<':
					st.add(c);
					break;
				default:
					if(st.isEmpty())
					{
						res=0;
						break;
					}
					char pop=st.pop();
					if((pop=='{'&&c=='}')||(pop=='['&&c==']')
							||(pop=='('&&c==')')||(pop=='<'&&c=='>'))
					{
						
					}
					else
					{
						res=0;
						break;
					}
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
}
