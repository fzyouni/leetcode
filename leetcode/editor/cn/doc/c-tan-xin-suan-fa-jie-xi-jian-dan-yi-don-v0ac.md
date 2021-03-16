### 解题思路
解题思路非常简单，首先将ans设置为第一位数，然后sum为0
每当sum不小于0的时候我们就继续加，如果加后面的数使sum变小也没事，因为不会影响ans的值。
当sum值小于0时怎么加后面的数也会变小所以我们舍弃前面的值，从这个数开始重新算。

### 代码

```cpp
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int ans = nums[0], sum = 0;

        for(int i = 0; i < nums.size(); ++i)
        {
            if(sum>=0) sum+=nums[i];
            else sum = nums[i];
            //检查是否比答案要大
            ans = max(ans,sum);
        }
    return ans;
    }
};
```