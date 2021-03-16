
### 1，使用数组解决
因为英文字母的大小是小于128的，我们可以使用一个长度为128的数组来解决
```
    public boolean isUnique(String astr) {
        int[] arr = new int[128];
        for (int i = 0; i < astr.length(); i++) {
            //把字符和数组关联
            if (arr[astr.charAt(i)] != 0)
                return false;
            arr[astr.charAt(i)]++;
        }
        return true;
    }
```

### 2，位运算解决
这题说的是判断字符是否唯一，但没说包含哪些字符，如果是只包含英文字母的话，直接使用一个long类型的数字即可，因为long类型是64位，大写字母'A'的ASCII码是65，小写字母'z'的ASCII码是122，两者相差58（122-65+1=58，加1是因为这里要包含大写字母'A'），是小于64的。我们用每一位存储每一个字符，比如右边第1位存储大写字符'A'，右边第2位存储大写字符'B'……，以此类推。然后再遍历字符串中的字符，先判断对应的位置是否是1，如果是1，就表示已经存在了，直接返回false，如果对应的位置不是1，说明这个字符还没出现过，然后把对应的位置置为1。
![image.png](https://pic.leetcode-cn.com/1600614468-NoGrLg-image.png)


```
    public boolean isUnique(String astr) {
        long bits = 0;
        int size = astr.length();
        for (int i = 0; i < size; i++) {
            int move = astr.charAt(i) - 'A';
            if ((bits & (1L << move)) != 0) {
                //有重复的，直接返回false
                return false;
            } else {
                //标记当前位置有这个字符
                bits |= (1L << move);
            }
        }
        return true;
    }
```


### 3，两两比较
使用两层循环，每两个两个进行比较
```
    public boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            for (int j = i + 1; j < astr.length(); j++) {
                if (astr.charAt(i) == astr.charAt(j))
                    return false;
            }
        }
        return true;
    }
```

### 4，使用集合set
把数组元素一个个添加到集合set中，如果添加失败，说明集合set中已经有相同的值，直接返回false
```
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            //如果有重复的直接返回false
            if (!set.add(astr.charAt(i)))
                return false;
        }
        return true;
    }
```

### 5，使用String的indexOf方法
使用String的indexOf方法，每遍历一个字符就要判断后面是否还有相同的字符，如果有，说明有重复的，直接返回false
```
    public boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            //查看后面是否有当前字符
            if (astr.indexOf(c, i + 1) != -1)
                return false;
        }
        return true;
    }
```


### 6，使用String的indexOf和lastIndexOf方法

```
    public boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            //判断当前字符从前面和后面索引是否相同，如果不相同，
            //说明有重复的字符，直接返回false
            if (astr.indexOf(c) != astr.lastIndexOf(c))
                return false;
        }
        return true;
    }
```

<br>

**如果觉得有用就给个赞吧，你的赞是给我最大的鼓励，也是我写作的最大动力**

![image.png](https://pic.leetcode-cn.com/d56a80459005b444404d2ad6fbaabdabecd2b9ed3cb2cf432e570c315ae2fcf7-image.png)
##### 查看更多答案，可扫码关注我微信公众号“**[数据结构和算法](https://img-blog.csdnimg.cn/20200807155236311.png)**”