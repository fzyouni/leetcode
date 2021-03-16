```java
class Solution {
    public boolean isPowerOfThree(int x) {
        double n = (double)x;  //注意要用double/float 否则5/3=1
		while(n>=3) {  //不断除3, 最后为1则是3的幂
			n/=3;
		}
        return n==1?true:false;
    }
}
```