

### 第一种解法：直接用String的API
效率太差，而且要求也不是用这种方法，不过第一反应就是用这种方法做的。
用了54ms，47.3MB
```java
class Solution {
    public String replaceSpaces(String S, int length) {
        return S.substring(0, length).replaceAll(" ", "%20");
     }
}
```  

### 第二种解法：字符数组
用了11ms，47.7MB 
```java
class Solution {
    public String replaceSpaces(String S, int length) {    
        char[] ch = new char[length * 3];
        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == ' ') {
                ch[index++] = '%';
                ch[index++] = '2';
                ch[index++] = '0';
            } else {
                ch[index] = c;
                index++;
            }
        }
        return new String(ch, 0, index);
    }
}
```

### 第三种解法：使用StringBuilder
用了19ms，47.4MB 
```java
class Solution {
    public String replaceSpaces(String S, int length) {
        //
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ch = S.charAt(i);
            if (ch == ' ') {
                sb.append("%20");
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
```