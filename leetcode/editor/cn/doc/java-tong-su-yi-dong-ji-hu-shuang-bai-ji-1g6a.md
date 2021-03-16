### 解题思路
本题解采用了 **`双指针`** 的思想：
> 1、定义两个指针，分别指向 **最小数(0下标)** 和 **最大数(0下标)**
> 2、通过两个指针，来遍历数组：
>> 1. 两数之和 < 目标值，小数指针后移
>> 2. 两数之和 > 目标值，大数指针前移
>> 3. 两数之和 == 目标值，返回这两个数

### 运行结果
![image.png](https://pic.leetcode-cn.com/1614049358-eaEBGR-image.png)

### 代码

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || target <= 0) {
            return new int[0];
        }

        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 < p2) {
            int result = nums[p1] + nums[p2];
            if (result < target) {  // 两数之和 < 目标值，小数指针后移
                p1++;
            } else if (result > target) {  // 两数之和 > 目标值，大数指针前移
                p2--;
            } else {    // 两数之和 == 目标值，返回这两个数
                return new int[] {nums[p1], nums[p2]};
            }
        }

        return new int[0];
    }
}
```
打卡173天，加油！！！
明天就要离开工作岗位，坐飞机回家了
可能明天临晨更新题解，也可能晚上更新，总之还是会续更的，同学们也要一起加油🦆