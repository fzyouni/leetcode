//给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。 
//
// 输入为三个整数：day、month 和 year，分别表示日、月、年。 
//
// 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "F
//riday", "Saturday"}。 
//
// 
//
// 示例 1： 
//
// 输入：day = 31, month = 8, year = 2019
//输出："Saturday"
// 
//
// 示例 2： 
//
// 输入：day = 18, month = 7, year = 1999
//输出："Sunday"
// 
//
// 示例 3： 
//
// 输入：day = 15, month = 8, year = 1993
//输出："Sunday"
// 
//
// 
//
// 提示： 
//
// 
// 给出的日期一定是在 1971 到 2100 年之间的有效日期。 
// 
// Related Topics 数组 
// 👍 33 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        month -= 2;
        if (month <= 0) {
            month += 12;
            year--;
        }
        int map[] = {0, 31, 61, 92, 122, 153, 184, 214, 245, 275, 306, 337};
        String[] data = {"Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};
        int d = day - 1 + map[month - 1] + year * 365 + year / 4 - year / 100 + year / 400; // 0/3/1
        return data[d % 7];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
