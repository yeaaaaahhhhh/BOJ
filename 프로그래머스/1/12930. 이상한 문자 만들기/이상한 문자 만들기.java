class Solution {
    public String solution(String s) {
        StringBuilder sb=new StringBuilder();
        boolean upper=true;
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c==' ')
            {
                upper=true;
                sb.append(' ');
            }
            else
            {
                if(c>='a'&&c<='z'&&upper)
                {
                    sb.append((char)(c+('A'-'a')));
                }
                else
                {
                    sb.append(c);   
                }
                upper=!upper;
            }
        }
        return sb.toString();
    }
}