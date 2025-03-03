void moveZeroes(int* nums, int numsSize) {
	
	int zeroCnt = 0;
	int idx = 0;
	for (int i = 0;i < numsSize;i++)
	{
		int cur = nums[i];
		if(cur!=0)
		{
			nums[idx++] = cur;
		}
	}
	while (idx < numsSize)
	{
		nums[idx++] = 0;
	}
}