import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> hm=new HashMap();
        
        for(int i=0;i<record.length;i++)
        {
            String[] tmp=record[i].split(" ");
            if(!tmp[0].equals("Leave"))
            {
                hm.put(tmp[1],tmp[2]);
            }
        }
        
        ArrayList<String> answer=new ArrayList();
        
        for(int i=0;i<record.length;i++)
        {
            String[] tmp=record[i].split(" ");
            if(tmp[0].equals("Enter"))
            {
                answer.add(hm.get(tmp[1])+"님이 들어왔습니다.");
            }
            else if(tmp[0].equals("Leave"))
            {
                answer.add(hm.get(tmp[1])+"님이 나갔습니다.");
            }
        }
        //System.out.println(hm);
        
        return answer.toArray(String[]::new);
    }
}