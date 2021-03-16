最简单的思路就是先用哈希表记录所有字符的次数，再遍历查看是否有次数大于1的，有则return false，无则返回true
```两遍哈希 []
class Solution {
public:
    bool isUnique(string astr) {
        unordered_map<char, int> cnts;
        for (auto& c : astr) cnts[c]++;
        for (auto& c : astr) {
            if (cnts[c] > 1) return false;
        }
        return true;
    }
};
```
```一遍哈希 []
class Solution {
public:
    bool isUnique(string astr) {
        unordered_map<char, int> cnts;
        for (auto& c : astr) {
            if (cnts[c] == 0) cnts[c]++;
            else return false;
        }
        return true;
    }
};
```
由于本题数据范围较小，可以采用一个int的32位来替代哈希表储存26个字母的状态
```
class Solution {
public:
    bool isUnique(string astr) {
        int cnts = 0;
        for (auto& c : astr) {
            int i = c - 'a';
            if ((cnts >> i & 1) == 0) cnts |= (1 << i);
            else return false;
        }
        return true;
    }
};
```


