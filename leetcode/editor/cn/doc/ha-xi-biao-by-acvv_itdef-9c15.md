算法1
(哈希) O(1) 
遍历字符串，使用哈希记录每个字符出现的次数
如果没有出现1次以上的记录 那么每个字符都是仅出现一次的
```
class Solution {
public:
    set<char> ss;
    bool isUnique(string astr) {
        for(int i = 0; i < astr.size();i++){
            if(ss.count(astr[i])!=0) return false;
            ss.insert(astr[i]);
        }

        return true;
    }
};
```

算法2
(哈希) O(1)O(1)
优化下速度 使用数组进行字符哈希
会被使用哈希数据结构 速度更快
```
class Solution {
public:
    int mm[300];
    bool isUnique(string astr) {
        for(int i = 0; i < astr.size();i++){
            if(mm[astr[i] -0] != 0) return false;
            mm[astr[i]-0]++;
        }

        return true;
    }
};
```
[我的视频题解空间](https://space.bilibili.com/18508846)
