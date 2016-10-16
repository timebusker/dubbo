dubbo-one-service-B
         服务提供者：该项目整合了persistence.xml配置项
		 Spring 对 JPA 的支持已经非常强大，开发者无需过多关注 EntityManager 的创建、事务处理等 JPA相关的处理		 
		 |---src/main/resources
		 |---applicationContext.xml
		 |---jdbc.properties
		 |---log4j.properties		 
		 
		 在项目中实现了对spring-data-jpa比较全面的使用
		     ● 继承JpaRepository接口，实现简单的数据操作
		         ● 通过解析方法名创建查询
				 ● 删除单个对象数据、批量删除
				 ● 统计数量
				 ● 使用@Query创建查询
		
		可继承的接口有：实际上, 也可以通过 @RepositoryDefinition 注解来替代继承 Repository 接口
	 		 Repository：是 Spring Data的一个核心接口，它不提供任何方法，开发者需要在自己定义的接口中声明需要的方法，即是一个标记接口。
			             定义的接口继承了Repository, 则该接口会被IOC容器识别为一个Repository Bean，注册到 IOC 容器中。						 
						 
	 		 CrudRepository：继承Repository，提供增删改查方法，可以直接调用。
			 PagingAndSortingRepository：继承CrudRepository，具有分页查询和排序功能（本类实例）
			 JpaRepository： 继承PagingAndSortingRepository，针对JPA技术提供的接口
			 JpaSpecificationExecutor： 可以执行原生SQL查询
			 
		
	     通过解析方法名创建查询
	         框架在进行方法名解析时，会先把方法名多余的前缀截取掉，比如 find、findBy、read、readBy、get、getBy，
	         然后对剩下部分进行解析。并且如果方法的最后一个参数是 Sort 或者 Pageable 类型，也会提取相关的信息，以便按规则进行排序或者分页查询。
	         
			 以findByUserAddressZip ()（）为例，框架在解析该方法时，首先剔除 findBy，然后对剩下的属性进行解析：
	 
	         先判断 userAddressZip （根据 POJO 规范，首字母变为小写）是否为 Message 的一个属性，
	               如果是，则表示根据该属性进行查询；如果没有该属性，继续第二步；
	         从右往左截取第一个大写字母开头的字符串（此处为 Zip），然后检查剩下的字符串是否为 Message 的一个属性，如果是，则表示根据该属性进行查询；
	               如果没有该属性，则重复第二步，继续从右往左截取；最后假设 user 为 Message 的一个属性；
	         接着处理剩下部分（ AddressZip ），先判断 user 所对应的类型是否有 addressZip 属性，如果有，
			       则表示该方法最终是根据 "AccountInfo.user.addressZip" 的取值进行查询；
	               否则继续按照步骤 2 的规则从右往左截取，最终表示根据 "AccountInfo.user.address.zip" 的值进行查询。
	               
Spring-data数据更新：
      Spring-data在更新数据时，需要在service层或者respository(持久层)添加事务管理，
              否则更新数据会无法提交到数据（事务不会提交）。
      解决方案：在类上加@Transactional注解即可。

JAP实体关联映射：
                              一对一
                              一对多
                              多对一
                              多对多
	               
	               等待完成：分页查询、排序
 