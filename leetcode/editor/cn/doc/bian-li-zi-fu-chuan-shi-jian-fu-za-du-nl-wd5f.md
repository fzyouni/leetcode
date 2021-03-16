### 解题思路

### 代码

```c
bool isUnique(char* astr){
    int n=strlen(astr);
    if(n<=0)return true;
    int fault=1;
    for(int i=0;i<n;i++)
    {
        int j=i+1;
        while(j<n)
        {
            if(astr[j]==astr[i])
            return false;
            j++;
        }
    }
    return true;
}
```