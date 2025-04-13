

class Solution {
public:
    string mergeAlternately(string word1, string word2) {

        int idx1=0, idx2=0;
        string res;

        while (res.length() < word1.length()+word2.length())
        {
            //string 에는 \0가 포함되지 않음.
            if (idx1<word1.length())
                res.push_back(word1[idx1++]);
            if (idx2 < word2.length())
                res.push_back(word2[idx2++]);
            //std::cout << res.length()<< endl;
        }
        return res;
    }
};