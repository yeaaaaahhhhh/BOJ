import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] map=new int[board.length][board[0].length];
        for(int i=0;i<skill.length;i++)
        {
            int[] sk=skill[i];
            int dmg=((sk[0]==1)?-1:1)*sk[5];
            
            map[sk[1]][sk[2]]+=dmg;
            if(sk[3]+1<map.length)
            {
                map[sk[3]+1][sk[2]]-=dmg;
            }
            if(sk[4]+1<map[0].length)
            {
                map[sk[1]][sk[4]+1]-=dmg;
            }
            if((sk[3]+1<map.length)&&(sk[4]+1<map[0].length))
            {
                map[sk[3]+1][sk[4]+1]+=dmg;
            }
        }
        for(int i=1;i<map.length;i++)
        {
            
            for(int j=0;j<map[0].length;j++)
            {
                map[i][j]+=map[i-1][j];
            }
           
        }
        for(int i=0;i<map.length;i++)
        {
            for(int j=1;j<map[0].length;j++)
            {
                map[i][j]+=map[i][j-1];
            }
            
        }
        for(int i=0;i<map.length;i++)
        {
            // System.out.println(Arrays.toString(map[i]));
             for(int j=0;j<map[0].length;j++)
            {
                if(board[i][j]+map[i][j]>0)
                {
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}