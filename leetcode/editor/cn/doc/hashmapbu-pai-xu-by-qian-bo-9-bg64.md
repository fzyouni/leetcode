### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        for(int i = 0; i < s2.length(); i++){
            if(map.containsKey(s2.charAt(i))){
                map.put(s2.charAt(i),map.get(s2.charAt(i)) - 1);
                if(map.get(s2.charAt(i)) < 0){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
```