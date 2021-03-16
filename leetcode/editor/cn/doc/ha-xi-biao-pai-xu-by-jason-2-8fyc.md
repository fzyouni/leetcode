# 解法一 双哈希表
思路:
本题与 [242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/f)完全一致。
构建两个哈希表hash和hash2。
用hash统计s中的字符和个数。
用hash2统计t中的字符和个数。

最后比较hash == hash2 为解。

```cpp
class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size()){
            return false;
        }
        vector<int> hash(26),hash2(26);
        for(int i=0;i<s.size();++i){
            hash[s[i] - 'a']++;
            hash2[t[i] - 'a']++;
        }
        return hash == hash2;
    }
};
```

# 解法二 排序
思路：

对s中的字符排序，构成字符串s'。
对t中的字符排序，构成字符串t'。

比较s' == t' 为解。

```
class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size()){
            return false;
        }
        sort(s.begin(),s.end());
        sort(t.begin(),t.end());
        return s == t;
    }
};
```
