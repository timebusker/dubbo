dubbo-one-interface 
         接口层：在dubbo服务暴露接口时，该接口加入到消费者项目中，提供统一的接口规范管理
		 
		 在定义分页接口时，添加spring-data-jpa依赖，后续可不再添加依赖
		 <!-- 加载spring data，完成分页接口定义 -->
		<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-jpa</artifactId>
			<version>1.10.2.RELEASE</version>
		</dependency>
		
		规范做法是数据接口层规定好统一的数据类型，方便消费方直接使用，实现软件设计的松散耦合
		
		Page类型返回的数据为JSON数据
		 