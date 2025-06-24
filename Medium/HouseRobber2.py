# 213. House Robber II - 06.23.2025
from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])

        pastLoot1 = nums[0]
        currLoot1 = max(nums[0], nums[1])

        pastLoot2 = 0
        currLoot2 = nums[1]

        for i in range(2, len(nums)):
            temp1 = currLoot1
            temp2 = currLoot2
            currLoot1 = max(pastLoot1+nums[i], currLoot1)
            currLoot2 = max(pastLoot2+nums[i], currLoot2)
            pastLoot1 = temp1
            pastLoot2 = temp2
        
        return max(pastLoot1, currLoot2)