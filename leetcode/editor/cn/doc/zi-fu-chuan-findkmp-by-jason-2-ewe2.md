# 解法一 字符串find
思路:

本题与[796. 旋转字符串](https://leetcode-cn.com/problems/rotate-string/)完全一致.

C = A + A;

那么，C.find(B) != string::npos即为解。


```cpp
class Solution {
public:
    bool rotateString(string A, string B) {
        if(A.size() != B.size()){
            return false;
        }
        string C = A;
        C += A;

        return C.find(B) != string::npos;
    }
};
```

# 解法二 KMP算法
用kmp算法取代find函数。

KMP算法的原理和实现，我在题目[28. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/)的[题解](https://leetcode-cn.com/problems/implement-strstr/solution/kmpsuan-fa-by-jason-2-ro9a/)中做过完整的讨论，请移步。

在A中查找B时，如果匹配的字符超过A的长度，用取模的方式，从A的开头处再查找。

当A与B不匹配的距离超过B的长度时,说明A不可能变成B.

```
class Solution {
public:
    bool rotateString(string A, string B) {
        if(A.size() != B.size()){
            return false;
        }

        if(A== B){
            return true;
        }
        if(A.empty()){
            return B.empty();
        }

        if(B.empty()){
            return false;
        }
        vector<int> f(B.size()+1);
        getFail(B,f);

        int i = 0;
        int j = 0;
        while(i-j < B.size()){
            int ii = i % A.size();//取模绕到A的开头处
            while(j && B[j] != A[ii]){
                j = f[j];
            }
            if(B[j] == A[ii]){
                j++;
            }
            if(j == B.size()){
                return true;
            }
            ++i;
        }
        return false;
    }

    void getFail(const string& P,vector<int>& f){
        f[0] = 0;
        f[1] = 0;
        for(int j=1;j<P.size();++j){
            int k = f[j];
            while(k && P[k] != P[j]){
                k = f[k];
            }
            if(P[k] == P[j]){
                f[j+1] = k+1;
            }else{
                f[j+1] = 0;
            }
        }
    }
};
```
