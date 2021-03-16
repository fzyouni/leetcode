### 解题思路

刚开始是想用全排列函数next_permutation做的，先用sort函数排序s1,再以s1为基准进行全排列，并在全排列的情况下逐一跟s2比较，但发现超时了。
然后脑筋一转，咦，如果一个字符串能重新排列后变成另一个字符串，那不就说明它们升序/降序是一样的吗？？？
所以就有如下解了:
### 代码

```cpp
class Solution {
public:
    bool CheckPermutation(string s1, string s2) {
    	if(s1.length()!=s2.length()) 
    		return false;
    	sort(s1.begin(),s1.end());	
    	sort(s2.begin(),s2.end());
    	// printf("s1:%s  s2:%s\n",s1.c_str(),s2.c_str());
		if(s1.compare(s2)==0)
			return true;
		return false;
	}
};
```