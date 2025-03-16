class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> ans;

        int l=0;
        int h=nums.size();

        while(l<h)
        {
            int m=l+(h-l)/2;
            
            if(nums.at(m)<target)
            {
                l=m+1;
            }
            else
            {
                h=m;
            }
            printf("%d %d %d\n",l,m,h);
        }

        if(l<nums.size()&&nums.at(l)==target)
        {
            ans.push_back(l);
            for(int i=l; i<nums.size(); i++)
            {
                if(nums.at(i)!=target)
                {
                    ans.push_back(i-1);
                    return ans;
                }
            }
            ans.push_back(nums.size()-1);
            return ans;
        }
        else
        {
            ans.push_back(-1);
            ans.push_back(-1);
        }

        return ans;
    }
};