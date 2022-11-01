import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Queue <Character> q=new LinkedList();
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            {
                q.add('(');
            }
            else
            {
                if(q.isEmpty())
                {
                    return false;
                }
                q.remove();
            }
        }
        if(!q.isEmpty())
            return false;
        return answer;
    }
}