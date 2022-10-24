class Solution {
    public String solution(String s) {
        String[] tmp=s.split(" ");
        int min=Integer.parseInt(tmp[0]);
        int max=Integer.parseInt(tmp[0]);
        for(int i=1;i<tmp.length;i++)
        {
            int a=Integer.parseInt(tmp[i]);
            if(max<a)
            {
                max=a;
            }
            if(min>a)
            {
                min=a;
            }
        }
        String answer=min+" "+max;
        return answer;
    }
}