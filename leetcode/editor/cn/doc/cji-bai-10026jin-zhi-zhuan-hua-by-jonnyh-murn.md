### 解题思路
题很简单，只需要注意1 - A而不是0 - A
所以每次转化前需要：
`n -= 1;`
### 代码

```cpp
class Solution {
public:
    string convertToTitle(int n) {
        stack<char> S;
        while(!S.empty())
        {
            S.pop();
        }
        string s = "";
        while(n)
        {
            n -= 1;
            int a = n % 26;
            S.push('A' + a);
            n = n / 26;

        }
        while(!S.empty())
        {
            s += S.top();
            S.pop();
        }
        return s;
    }
};
```