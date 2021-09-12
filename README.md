# java2105-huangzihao-hotel 项目记录

## 2021-09-12

### 遇到如下问题

```mysql
select 
t_dishes_id dishesId,
t_cuisine_id cuisineId, 
t_dishes_name dishesName, 
t_dishes_price dishesPrice,
t_dishes_member_price dishesMemberPrice,
t_dishes_img dishesImg, 
t_dishes_introduction dishesIntroduction, 
t_dishes_status dishesStatus
from t_dishes
where t_cuisine_id = ?;

update t_dishes
set t_cuisine_id = ?,t_dishes_name = ?,t_dishes_price = ?,t_dishes_member_price = ?,t_dishes_img = ?,t_dishes_introduction = ?
where t_dishes_id = ?;

update t_dishes set t_dishes_status = 3 where t_dishes_id = ?;
```

​	首先是如上几个实例的SQL语句，在使用**QueryRunne**r的时候，会忘记把**字段**的别名设置成和**实体类**对应的**名称**。

​	再就是再进行换行的时候会把**逗号**漏下



```java
request.getRequestDispatcher(request.getContextPath() + "/backend/detail/foodtype/foodtype-update.jsp").forward(request,response);
```

在使用request的转发方法时，会忘记使用forward方法，导致前台进行测试时经常页面跳转不过去



剩下的就是一些细节上的问题。
