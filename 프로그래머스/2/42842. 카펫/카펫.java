class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum=(brown-4)/2;
        int mlt=yellow;
        for(int i=1;i<sum;i++)
        {
            if(i*(sum-i)==mlt)
            {
                return new int[] {sum-i+2,i+2};
            }
        }
        return answer;
    }
}