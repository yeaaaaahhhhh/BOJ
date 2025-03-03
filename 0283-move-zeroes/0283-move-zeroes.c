void moveZeroes(int* nums, int numsSize) {
	int idx = 0;
	for (int i = 0;i < numsSize;i++)
	{
		int cur = nums[i];
		if(cur!=0)
		{
			if(idx!=i)
			{
				nums[i] = nums[idx];
				nums[idx] = cur;
			}
			idx++;
		}
	}
}