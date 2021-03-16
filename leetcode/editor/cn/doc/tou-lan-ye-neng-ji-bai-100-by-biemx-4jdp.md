老年人刷题。

```Java []
class Solution {
    public boolean isUnique(String astr) {
        if (astr.length() > 1) {
            HashSet<Character> set = new HashSet<>(astr.length());
            for (char c : astr.toCharArray()) {
                if (!set.add(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
```
```Golang []
func isUnique(astr string) bool {
    if len(astr) > 1 {
        set := map[rune] bool {}
        for _, v := range astr {            
            if set[v] {
                return false
            }
            set[v] = true            
        }
    }
    return true
}
```
```Javascript []
/**
 * @param {string} astr
 * @return {boolean}
 */
var isUnique = function(astr) {
    return astr.length == new Set(astr).size;
};
```
```Python []
class Solution:
    def isUnique(self, astr: str) -> bool:
        return len(astr) == len(set(astr))
```
