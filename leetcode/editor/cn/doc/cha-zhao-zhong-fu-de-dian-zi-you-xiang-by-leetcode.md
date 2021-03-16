#### 方法一：使用 `GROUP BY` 和临时表

**算法**

重复的电子邮箱存在多次。要计算每封电子邮件的存在次数，我们可以使用以下代码。

```mysql [d8EiS4CT-MySQL]
select Email, count(Email) as num
from Person
group by Email;
```


```
| Email   | num |
|---------|-----|
| a@b.com | 2   |
| c@d.com | 1   |
```

以此作为临时表，我们可以得到下面的解决方案。

```mysql [GeXvS7ji-MySQL]
select Email from
(
  select Email, count(Email) as num
  from Person
  group by Email
) as statistic
where num > 1
;
```


#### 方法二：使用 `GROUP BY` 和 `HAVING` 条件

向 `GROUP BY` 添加条件的一种更常用的方法是使用 `HAVING` 子句，该子句更为简单高效。

所以我们可以将上面的解决方案重写为：

```mysql [ShYdkDn6-MySQL]
select Email
from Person
group by Email
having count(Email) > 1;
```
