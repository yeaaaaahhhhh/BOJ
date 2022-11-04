class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if(s.length()==4||s.length()==6)
        {
            try{
                Integer.parseInt(s);
            }catch(NumberFormatException e)
            {
                return answer;
            }
            return true;
        }
        return answer;
    }
}