递增有序的数组 寻找两个数 ，这样的条件就宽泛了很多。

有序的数组可以考虑使用 二分查找，复杂度为O(nlogn)

还可以和leetcode 第一题两数之和解法类似，可以使用双指针和哈希的做法 复杂度O(n);
1 二分查找
![111.png](https://pic.leetcode-cn.com/1614992096-sUYZod-111.png)
```
class Solution {
public:
    bool Check(const vector<int>& v, int idx, int find) {
        return v[idx] >= find;
    }

    bool bSearch(const vector<int>& v, int l, int r, int find)
    {
        bool ret = false;
        if (l < 0 || l >= v.size() || r < 0 || r >= v.size()) return ret;

        while (l < r) {
            int mid = l+r >> 1;
            if (Check(v,mid,find)) r = mid;
            else l = mid + 1;
        }

        return v[l] == find;
    }

    vector<int> twoSum(vector<int>& nums, int target) {
        for (int i = 0; i < nums.size(); i++) {
            int find = target - nums[i];
            bool ret = false;
            if (find > nums[i]) {
                ret = bSearch(nums,i+1,nums.size()-1,find);
                if (ret) {
                    return vector<int>{nums[i], find};
                }
            }
            else if (find < nums[i]) {
                ret = bSearch(nums, 0, i - 1, find);
                if (ret) {
                    return vector<int>{nums[i], find};
                }
            }
            else {
                //说明查找的数字和nums[i]相等 直接查找该数字前后是否有该数即可
                if (i - 1 >= 0 && nums[i - 1] == nums[i]) return vector<int>{find, find};
                if (i + 1 < nums.size() && nums[i + 1] == nums[i]) return vector<int>{find, find};
            }
        }

        return vector<int>();
    }
};
```


2 哈希
```
class Solution {
public:
    unordered_set<int> ss;
    vector<int> twoSum(vector<int>& nums, int target) {
        for (int i = 0; i < nums.size(); i++) {
            int find = target - nums[i];
            if (find < 0) return vector<int>();
            if (ss.count(find) != 0) return vector<int>{nums[i], find};
            ss.insert(nums[i]);
        }

        return vector<int>();
    }
};
```


3 双指针
![222.png](https://pic.leetcode-cn.com/1614992178-JgFWrX-222.png)
![333.png](https://pic.leetcode-cn.com/1614992184-RnUukf-333.png)
```
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int l = 0; int r = nums.size() - 1;
        while (l < r) {
            if (target == nums[l] + nums[r]) {
                return vector<int>{nums[l], nums[r]};
            }
            else if (target > nums[l] + nums[r]) {    
                l++;
            }
            else if (target < nums[l] + nums[r]) {    
                r--;
            }
        }
        return vector<int>();
    }
};
```


[我的视频题解空间](https://space.bilibili.com/18508846)