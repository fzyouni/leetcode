//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = '()'
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = '()[]{}'
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = '(]'
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = '([)]'
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = '{[]}'
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2228 👎 0


import java.util.HashMap;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        //长度为奇数的时候，直接返回异常
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c1 : c) {
            if (map.containsKey(c1)) {
                stack.push(c1);
            } else if (!stack.empty() && map.get(stack.peek()) == c1) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
