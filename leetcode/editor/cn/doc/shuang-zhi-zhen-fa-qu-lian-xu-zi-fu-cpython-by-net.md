这是一道考验基本功的题目。

这道题考察的第一个点是如何找到字符串中连续的字符。方法是使用双指针，移动两个下标 `i` 和 `j`。过程如下图所示：

 [process](https://pic.leetcode-cn.com/97e85c6f75e8bc2df19ee4572359d9bca2ebbc2a3e365026991064c1e09e6e64.gif)

这道题考察的第二个点是构建字符串的时间复杂度。例如在 C++ 中，`res += s` 和 `res = res + s` 的含义是不一样的。前者是直接在 `res` 后面添加字符串；后者是用一个临时对象计算 `res + s`，会消耗很多时间和内存。

同样的，在 Java 中，要使用 `StringBuilder`，而不能直接用字符串相加。

使用这个方法，内存消耗能击败 100%：

![pass-c++](https://pic.leetcode-cn.com/3f4c4a2e9959f70279011ed1c25162d711ca50d537fbf7aa8b61817117150597.jpg)

![pass-java](https://pic.leetcode-cn.com/0f865ba41d597718d262339fb0ec2354081e5fc60533ec856ad8dc96880c5d0e.jpg)

![pass-python](https://pic.leetcode-cn.com/117937f6353d0a4d41b0a5d7a588ecb0fe7d3757edb2f4bffdce272064f3eb22.jpg)

以下是完整题解代码。

```C++ []
string compressString(string S) {
    int N = S.length();
    string res;
    int i = 0;
    while (i < N) {
        int j = i;
        while (j < N && S[j] == S[i]) {
            j++;
        }
        res += S[i];
        res += to_string(j - i);
        i = j;
    }

    if (res.length() < S.length()) {
        return res;
    } else {
        return S;
    }
}
```

```Java []
public String compressString(String S) {
    int N = S.length();
    int i = 0;
    StringBuilder sb = new StringBuilder();
    while (i < N) {
        int j = i;
        while (j < N && S.charAt(j) == S.charAt(i)) {
            j++;
        }
        sb.append(S.charAt(i));
        sb.append(j - i);
        i = j;
    }

    String res = sb.toString();
    if (res.length() < S.length()) {
        return res;
    } else {
        return S;
    }
}
```

```Python []
def compressString(self, S: str) -> str:
    N = len(S)
    res = ''
    i = 0
    while i < N:
        j = i
        while j < N and S[j] == S[i]:
            j += 1
        res += S[i] + str(j - i)
        i = j

    if len(res) < len(S):
        return res
    else:
        return S
```

如果你觉得本文对你有帮助，欢迎关注我的公众号《面向大象编程》，其中的《LeetCode 例题精讲》系列文章正在写作，不仅有题解，更能让你学会解题的通用思路，举一反三！

![wechat](https://pic.leetcode-cn.com/263aba002ca31e5f7275886b10c1db77d6f42a70b897049fcde8fc331b2b5a1d.jpg)