### 解题思路
400年的整数倍（如1600年）的3月1日都是星期三，计算和0年（实际不存在，只是为了避免负数范围足够大）3月1日的距离。
为什么选3月1日呢？这样可以避免闰年里是否包含2月29日的判断问题，我们可以将3月1日视为每年的第一天。
为什么选400年的整数倍呢？因为此法考虑到100年不闰与400年闰的问题，选取正好400年的整数倍可以让year/4-year/100+year/400直接表示闰年带来的天数。

### 代码

```cpp
class Solution {
public:
    string dayOfTheWeek(int day, int month, int year) {
        month-=2;
        if(month<=0){
            month+=12;
            year--;
        }
        static int map[]={0,31,61,92,122,153,184,214,245,275,306,337};
        static string data[]={"Wednesday","Thursday","Friday","Saturday","Sunday","Monday","Tuesday"};
        int d=day-1+map[month-1]+year*365+year/4-year/100+year/400; // 0/3/1
        return data[d%7];
    }
};
```