### 解题思路
进制转换：字符数组从左至右遍历，用算式s[i] - 'A' + 1将字符转换为数字，循环*26即可

### 代码

```c
int titleToNumber(char * s){
    int re = 0;
    for (int i = 0; s[i] != '\0'; i++) {//从左至右高位到低位
        int num = s[i] - 'A' + 1;
        re = re * 26 + num;
    }
    return re;
}



```