### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
    public String compressString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int len = S.length();
        for (int i = 0; i < len; i++) {
            if (i + 1 < len && (S.charAt(i) == S.charAt(i + 1))) {
                count++;
                continue;
            } else {
                sb.append(S.charAt(i));
                sb.append(count);
                count = 1;
            }
        }
        return sb.toString().length() >= S.length() ? S : sb.toString();
    }
}
```