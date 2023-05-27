import java.util.*;
//12:00까지
class Solution {
    public int[] solution(int[] fees, String[] records) {

        HashMap <String,Integer> res=new HashMap<>();
        HashMap <String,Integer> hm=new HashMap<>();

        for (int rec=records.length-1;rec>=0;rec--)
        {
            String[] info=records[rec].split(" ");
            if(info[2].equals("OUT"))
            {
                String[] time=info[0].split(":");
                int outTime=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
                hm.put(info[1],outTime);
            }
            else
            {
                if(hm.containsKey(info[1]))
                {
                    String[] time=info[0].split(":");
                    int inTime=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
                    int outTime=hm.remove(info[1]);
                    res.put(info[1],res.getOrDefault(info[1],0)+outTime-inTime);
                }
                else {
                    String[] time=info[0].split(":");
                    int inTime=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
                    int outTime=23*60+59;
                    res.put(info[1],res.getOrDefault(info[1],0)+outTime-inTime);
                }
            }
        }

        System.out.println(res.toString());

        ArrayList<String> arr=new ArrayList<>(res.keySet());
        int[] answer=new int[arr.size()];
        Collections.sort(arr);
        for(int i=0;i<arr.size();i++)
        {
            int min=res.get(arr.get(i));
            int fee=0;
            if(min<=fees[0])
            {
                fee=fees[1];
            }
            else {
                fee= (int) (fees[1]+Math.ceil((double) (min-fees[0])/fees[2])*fees[3]);
            }
            answer[i]=fee;
        }
        return answer;
    }
}