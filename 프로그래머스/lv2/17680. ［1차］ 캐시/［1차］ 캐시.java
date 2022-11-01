import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache=new LinkedList();
        if(cacheSize==0)
        {
            return 5*cities.length;
        }
        for (int i=0;i<cities.length;i++)
        {
                if(!cache.contains(cities[i].toUpperCase()))//miss
                {
                    if(cache.size()>=cacheSize)//cache is full
                    {
                        cache.remove(0);
                        cache.add(cities[i].toUpperCase());
                    }
                    else
                    {
                        cache.add(cities[i].toUpperCase());
                    }
                    //System.out.println("miss");
                    answer+=5;
                }
                else//hit
                {
                    cache.remove(cities[i].toUpperCase());
                    cache.add(cities[i].toUpperCase());
                    answer++;
                    //System.out.println("hit");
                }
        }
        
        return answer;
    }
}