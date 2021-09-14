java2105-huangzihao-hotel 项目记录

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



## 2021-09-13

- Tomcat忽略war包的项目名

```xml
<Host name="localhost"  appBase="webapps" unpackWARs="true" autoDeploy="true">
    
     <Context docBase="项目路径/项目名" path="" reloadable="false"/>
    
</Host>

```

> ​	在Tomcat安装目录下的conf目录下server.xml文件中，找到<Host></Host>标签，在其中加上上面代码块中中间的代码

## 2021-09-14

```java
public void setCurrentPage(Integer currentPage) {
        if (0 >= currentPage) {
            //判断传入的当前页是否合理
            this.currentPage = 1;
        } else {
            if (currentPage <= this.totalPage) {
                //判断传入的当前页是否超过最大页数
//                this.currentPage = this.totalPage;
                this.currentPage = currentPage;
            } else {
                this.currentPage = this.totalPage;
                //大于总页数的时候，让当前页保持，不改变
            }
        }
}
```

```java
Integer start = (pageBean.getCurrentPage() - 1) * pageBean.getPageSize();
if (start < 0) {
   start = 0;
}
```

> ​	需要在这里判断一下，否则计算的起始位置会变成负数
