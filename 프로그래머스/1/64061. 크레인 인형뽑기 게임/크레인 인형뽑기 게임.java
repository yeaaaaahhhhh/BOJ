import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int len=board[0].length;
        Queue<Integer>[] list=new LinkedList[len];
        
        for(int i=0;i<len;i++)
        {
            list[i]=new LinkedList<>();
        }
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<len;j++)
            {
                if(board[i][j]!=0)
                {
                    list[j].add(board[i][j]);
                }
            }   
        }
        
        // for(Queue<Integer> li:list)
        // {
        //     System.out.println(li);
        // }
        
        int cnt=0;
        Stack<Integer> st=new Stack();
        for(int move:moves)
        {
            if(list[move-1].isEmpty())
            {
                continue;
            }
            if(!st.isEmpty()&&st.peek()==list[move-1].peek())
            {
                st.pop();
                list[move-1].poll();
                cnt+=2;
            }
            else{
                st.push(list[move-1].poll());
            }
            // System.out.println(st);
        }
        return cnt;
    }
}