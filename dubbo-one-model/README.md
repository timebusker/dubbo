dubbo-one-model
      对象实体，应用jpa技术实现对象实体与数据关联
	  
	  JPA全称Java Persistence API.JPA通过JDK 5.0注解或XML描述对象－关系表的映射关系，并将运行期的实体对象持久化到数据库中。
	  
	  使用这个会报错 Dependancy error result in NoSuchMethodError: PersistenceUnitInfo.getSharedCacheMode()Ljavax/persistence/SharedCacheMode
	  <dependency> 
	  	<groupId>javax.persistence</groupId> 
	  	<artifactId>persistence-api</artifactId> 
		<version>1.0</version> 
	  </dependency>
	  
	  建议更换为：
	    <dependency>
			<groupId>org.hibernate.javax.persistence</groupId>
			<artifactId>hibernate-jpa-2.1-api</artifactId>
			<version>1.0.0.Final</version>
		</dependency>
		
	  具体实例查看：aa.mine.model.Message
	  
	  
	  使用JPA创建实体和数据库表的关系映射：Hibernate 可以对类的属性或者getter方法进行注解。属性对应field类别，方法的 getXxx()对应property类别。
	        常用注解：
			     @Entity 声明一个类为实体Bean。
				 @Table  说明此实体类映射的表名,目录,schema的名字。
				 @Id     声明此表的主键。
				 @GeneratedValue 定义主键的增长策略。我这里一般交给底层数据库处理，所以调用了名叫generator的增长方式，由下边的@GenericGenerator实现
				 @GenericGenerator hibernate内部的主键增长方式.
				 
				 @UniqueConstraint 将对应的字段设置唯一性标识(注：UniqueConstraint只在hibernate.hbm2ddl.auto设置为create-drop才会起作用)
				 
				 @Version 注解用于支持乐观锁版本控制。一般可以用 数字 或者 timestamp 类型来支持 version.
				 @Column  用于映射对应的字段,其中参数详解如下：
				     (1)     name 可选，列名(默认值是属性名)
					 (2)     unique 可选，是否在该列上设置唯一约束(默认值false)
					 (3)     nullable 可选，是否设置该列的值可以为空(默认值true)
					 (4)     insertable 可选，该列是否作为生成的insert语句中的一个列(默认值true)
					 (5)     updatable 可选，该列是否作为生成的update语句中的一个列(默认值true)
					 (6)     columnDefinition 可选，为这个特定列覆盖SQL DDL片段 (这可能导致无法在不同数据库间移植)
					 (7)     table 可选，定义对应的表(默认为主表)
					 (8)     length 可选，列长度(默认值255)
					 (9)     precision 可选，列十进制精度(decimal precision)(默认值0)
					 (10)    scale 可选，如果列十进制数值范围(decimal scale)可用,在此设置(默认值0)
				@Transient 被注解成 @Transient 的 getter 方法或属性，将不会被持久化（自己测试，只有放在getter方法内才起作用）
				@Basic     所有没有定义注解的属性，等价于在其上面添加了 @Basic注解可以声明属性的获取策略 ( fetch strategy ) 
				           fetch:抓取策略,延时加载与立即加载，optional:指定在生成数据库结构时字段是否允许为 null.
				@Temporal  可使用 @Temporal 注解来调整精度
				
		
			JAP实体关联映射：
                    一对一：@OneToOne、@PrimaryKeyJoinColumn、@JoinColumn
                    一对多：@OneToMany（双向、单向）一对多双向关联跟多对一是一样的,在多端生成一个外键,不生成第三张表来管理对应关系,由外键来管理对应关系 
                    多对一：@ManyToOne
                    多对多：@ManyToMany
				
				总结：	
				（1）、在为指明关联字段时，默认是主键作为外键，可通过以下做定义： 
				       @JoinColumn(name = "cateId", referencedColumnName="cateName")//关联表的cateName属性在当前表中的标示字段名称cateId
					   
				（2）、关联实体之间可通过cascade = CascadeType.DETACH) // 当前实体和cate的关系
				       中的cascade指定两个实体的映射关系。
					   
				（3）、在实体中通过mappedBy = "cateId" 指定了这个实体是被关系维护端的那个属性所维护，当我们设置了，mappedBy后，使关系成为双向的时候
				
				（4）、一对多的单向关联：只需要在一端增加对关联属性的访问（eg：A（控制端）和B关联，通过A可以查到B，但通过B查不到A）
				       一对多的双向关联：（eg：A（控制端）和B关联，通过A可以查到B，通过B查到A）
					                     在jpa中应该尽量映射成双向关联而不是单向，而且尽量不要让1的一端来控制关联关系，而应该使用多的一端来控制关联关系，
					                     双向的1-N和N-1是完全相同的两种关联关系，两端都需要增加对关联属性的访问，
					                     N的一端增加应用到关联实体的属性，1的一端增加结合属性，该集合记录了它所关联的全部实体。
				    若为双向关联，则在保存关联关系（也即存在外键）的实体中，要配合@JoinColumn；在没有保存关联关系的实体中，要使用mappedBy属性明确所关联的实体。
                    mappedBy用在双向关联中，mappedBy所在的实体为关系被维护端，而另一个实体为关系维护端（也即保存关联关系的一端）。
					
					单向和双向的关联关系可以存在于实体的任何一种关联关系中
					
	  
【JPA】 级联标签的解释 @Cascade 
	 
	  CascadeType.PRESIST 级联持久化（保存）操作（持久保存拥有方实体时，也会持久保存该实体的所有相关数据。）
===============================================================
      CascadeType.REMOVE 级联删除操作（删除一个实体时，也会删除该实体的所有相关数据。）
===============================================================
      CascadeType.MERGE 级联更新（合并）操作（将分离的实体重新合并到活动的持久性上下文时，也会合并该实体的所有相关数据。）
===============================================================
      CascadeType.REFRESH 级联刷新操作 （只会查询获取操作）
===============================================================
      CascadeType.ALL 包含以上全部级联操作
===============================================================

【实体关联区分控制端】
	  所谓的控制端指的是：关系维护者，起着主导作用
	  即：增加关联属性字段（数据库字段）的实体属于控制端