# [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)
***
### 思路

1. 首先，不可避免的是要遍历数组，上来就先写好for循环
2. 遍历的同时要记录两个值：一是子数组的和tmpSum；二是子数组的和在变化过程中产生的最大值res
3. 本题最重要的部分在于子数组的和的计算，核心代码就是
`tmpSum = Math.max(tmpSum + num, num);`
4. 下面开始啰嗦地解释以上代码：
为什么是tmpSum + num 和 num 之间取最大值呢？
i. 我们可以先考虑一下什么时候tmpSum + num会小于num，也就是当前数num之前的数的和是负数的时候，如果之前的数加起来是负数，又何必要把它加上呢？直接从当前数num开始新的子数组不就好了？这种情况下tmpSum = num
ii. 那什么时候tmpSum + num会大于num呢？就是当前数num之前的数加起来是正数，因为本题并没有限制子数组的长度，只要之前的tmpSum是正数，可以增加子数组和的大小，就给它加进来。这种情况下tmpSum = tmpSum + num
5. 子数组和tmpSum每变化一次，res都要记录一下最大值，只要大了就更新
### 代码
```java []
class Solution {
    public int maxSubArray(int[] nums) {
        int tmpSum = 0, res = nums[0];
        for(int num : nums){
            tmpSum = Math.max(tmpSum + num, num);
            res = Math.max(res, tmpSum);
        }
        return res;
    }
}
```

```python3 []
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        tmp_sum = 0
        res = nums[0]
        for num in nums:
            tmp_sum = max(tmp_sum + num, num)
            res = max(res, tmp_sum)
        return res
```

**复杂度分析**
- 时间复杂度：O(N)
- 空间复杂度：O(1)
