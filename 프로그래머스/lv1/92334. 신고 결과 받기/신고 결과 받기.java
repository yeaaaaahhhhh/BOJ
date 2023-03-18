import java.util.Map.Entry;
import java.util.*;

//9:50
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
         int[] answer = new int[id_list.length];
        
        Map<String,Integer> resultMap=new HashMap();
        Map<String,ArrayList<String>> hm=new HashMap();
        
        for (int i=0;i<report.length;i++)
        {
        	String[] tmp=report[i].split(" ");
        	String userId=tmp[0];
        	String reportedId=tmp[1];
        	
        	if(hm.containsKey(reportedId))
        	{
        		if(!hm.get(reportedId).contains(userId))//처음에 !안넣는 실수 -> 이렇게 할 경우 이름이 ab abc일때 문제가 생긴다.
        			hm.get(reportedId).add(userId);
        	}
        	else
        	{
        		ArrayList<String> arr=new ArrayList<String>();
        		arr.add(userId);
        		hm.put(reportedId,arr);
        	}
        }
        
        for (Entry<String,ArrayList<String>> a:hm.entrySet()) {//신고당한 사람, 신고한사람들
        	int reportNum=a.getValue().size();
        	if(reportNum>=k)
        	{
        		for(String id:a.getValue())
        		{
        			resultMap.put(id, resultMap.getOrDefault(id, 0)+1);
        		}
        	}
        	
        }
        for(int i=0;i<answer.length;i++)
        {
        	answer[i]=resultMap.getOrDefault(id_list[i],0);
        }
        return answer;
    }
}