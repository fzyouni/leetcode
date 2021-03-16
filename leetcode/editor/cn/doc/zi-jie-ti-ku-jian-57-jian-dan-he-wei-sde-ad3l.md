### 方法一：高效的双指针。
1. 之所以高效，是因为一个指针 i 初始在最左边，另一个指针 j 初始在最右边。让它们循环向中间逼近，直到找出答案。
#
### 先放C++代码，思路简单易懂。
```cpp
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        if (nums.size() == 1) {
            return {};
        }

        int i = 0, j = nums.size() - 1;

        while (i < j) {
            if (nums[i] + nums[j] == target) {
                return {nums[i], nums[j]};
            }
            else if (nums[i] + nums[j] < target) {
                ++ i;
            }
            else {
                -- j;
            }
        }

        return {};
    }
};
```
### 执行结果截图：
![image.png](https://pic.leetcode-cn.com/1608188352-rCsuFf-image.png)
#
### Tracker
1. 1刷：2020/12/17
