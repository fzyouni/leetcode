### 解题思路
这个题大家都很熟悉，虽然是一个动态规划问题，可以使用递归和正向递推，不过这里递推还是太浪费资源了，可以优化成尾递归。

### 代码（尾递归）

```cpp
class Solution {
public:
    int fib(int n) {

       return solution(n,1,1);   
    }
    int solution(int n,int t1,int t2){

        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return t2;
        }
        int tmp = (t1+t2) %  1000000007;      
        return solution(n-1,t2,tmp);     
    }
};
```

### 代码（正向递推）

```cpp
class Solution {
public:
    int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){

            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
};
```

