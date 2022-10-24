class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        while(s.length()>1)
        {
            answer[0]++;
            int tmplen=s.length();
            s=s.replace("0","");
            answer[1]+=tmplen-s.length();
            s=Integer.toBinaryString(s.length());
        }
        return answer;
    }
}