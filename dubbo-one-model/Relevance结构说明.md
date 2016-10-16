测试类在dubbo-one-service-B项目test下的aa.mine.service.RelevanceTest

实体对象的关联关系：单向、双向--其主要区别在于关联关系的控制在哪一方，还是双方都存在关联关系的属性访问。

1、employee和detailInfo为一对一关联关系
     使用 @OneToOne 注解可以建立实体Bean之间的一对一关系，一对一关系有3种情况。
     • 关联的实体都共享同样的主键——通过@PrimaryKeyJoinColumn 注解定义了一对一的关联关系。(外键必须为唯一约束)
     • 一个实体通过外键关联到另一个实体的主键——通过@JoinColumn注解定义一对一的关联关系。
     • 通过关联表来保存两个实体之间的关联关系
   本例只测试常用的情况：第二种。

2、company => department => employee 为一对多的关联关系

3、employee和position为多对多的关联关系