package aa.mine.service.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import aa.mine.model.Message;

/**
 * 1. Repository 是一个空接口. 即是一个标记接口
 * 2. 若我们定义的接口继承了 Repository, 则该接口会被 IOC 容器识别为一个 Repository Bean.
 *    纳入到 IOC 容器中. 进而可以在该接口中定义满足一定规范的方法. 
 * 3. 实际上, 也可以通过 @RepositoryDefinition 注解来替代继承 Repository 接口
 */

/**
 * 在 Repository 子接口中声明方法
 * 1. 不是随便声明的. 而需要符合一定的规范
 * 2. 查询方法以 find | read | get 开头
 * 3. 涉及条件查询时，条件的属性用条件关键字连接
 * 4. 要注意的是：条件属性以首字母大写。
 * 5. 支持属性的级联查询. 若当前类有符合条件的属性, 则优先使用, 而不使用级联属性. 
 *    若需要使用级联属性, 则属性之间使用 _进行连接. 
 */
@Transactional
public interface MessageRepository extends JpaRepository<Message, Long> {

	/**
	 * JPA全称Java Persistence API.JPA通过JDK 5.0注解或XML描述对象－关系表的映射关系，并将运行期的实体对象持久化到数据库中。
	 * Spring 对 JPA 的支持已经非常强大，开发者无需过多关注 EntityManager 的创建、事务处理等 JPA相关的处理
	 * 
	 * ***********************************************************************
	 * 然而spring对Jpa的支持不止于此，它要从根本上来简化我们的业务代码                                                                                                   
	 * 在没用使用jpa支持的时候，我们的代码应该是这样的：                                                                                                                             
	 * 1、MessageDao 持久层接口     2、MessageDaoImpl 持久层实现类     3、MessageService 业务层接口.....后面不在列举
	 * 每写一个实体类，都要衍生出5、6个类来对他进行操作，即使有了注解，我们可以依赖注入方式来拿到实现类，
	 * 但是通用的CRUD等操作却不免在每个实现类里声明，你又说，我可以定义一个父类，利用泛型反射原理就可以了，
	 * 但那样你还需要为每个Dao声明自己的实现类来继承你的父类
	 * ***********************************************************************
	 * 对持久层的简化技术哪家强？ Spring Data Jpa
	 * 你唯一要做的就只是声明持久层的接口，来继承他自身已经封装好的持久层接口，正如本类MessageDao一样
	 * 
	 * 可使用的接口有：
	 * Repository：是 Spring Data的一个核心接口，它不提供任何方法，开发者需要在自己定义的接口中声明需要的方法。
	 * CrudRepository：继承Repository，提供增删改查方法，可以直接调用。
	 * PagingAndSortingRepository：继承CrudRepository，具有分页查询和排序功能（本类实例）
	 * JpaRepository： 继承PagingAndSortingRepository，针对JPA技术提供的接口
	 * JpaSpecificationExecutor： 可以执行原生SQL查询
	 * 
	 * 继承不同的接口，有两个不同的泛型参数，他们是该持久层操作的类对象和主键类型。
	 *********************************************************************************
	 */
	//父类中只存在一个getOne（）方法，不能使用getAll()
	List<Message> findAll();
	//条件查询
	/**
	 * SQL语句内用的查询对象为Model对象，Jpa会自动建立和数据库的映射关系
	 * 参数必须使用@Param(value = "")绑定
	 * 所有传入参数均使用 :con 进行SQL拼接,也可以使用?占位符拼接SQL,参数顺序和?一致
	 * 在SQL中使用LOWER()、Date()函数对参数作简单处理
	 */
//	@Query("select tm from Message tm where name like :con order by id desc")
//	List<Message> findAllByCon(@Param(value = "con") String con);	
//	@Query("select tm from Message tm where name like ? order by id desc")
//	List<Message> findAllByCon(String con);
//	@Query("select tm from Message tm where name like LOWER(?) order by id desc")
//	List<Message> findAllByCon(String con);
	@Query("select tm from Message tm where publishDate > Date(?)  order by id desc")
	List<Message> findAllByCon(String con);
	
	
	@Query("select tm from Message tm where id > :con1 and id < :con2")
	List<Message> findAllByCon(@Param(value = "con1")long con1,
			@Param(value = "con2")long con2);
	
	@Query("select count(*) from Message tm")
	Integer findCount();
	
	@Query("select count(*) from Message tm where id > :con1 and id < :con2")
	Integer findCount(@Param(value = "con1")long con1,
			@Param(value = "con2")long con2);
	/**
	 * 通过解析方法名创建查询
	 * 
	 * 框架在进行方法名解析时，会先把方法名多余的前缀截取掉，比如 find、findBy、read、readBy、get、getBy，
	 * 然后对剩下部分进行解析。并且如果方法的最后一个参数是 Sort 或者 Pageable 类型，也会提取相关的信息，以便按规则进行排序或者分页查询。
	 * 根据 POJO 规范，首字母变为小写
	 * 以findByUserAddressZip ()（）为例，框架在解析该方法时，首先剔除 findBy，然后对剩下的属性进行解析：
	 * 
	 * 先判断 userAddressZip （根据 POJO 规范，首字母变为小写）是否为 Message 的一个属性，
	 * 如果是，则表示根据该属性进行查询；如果没有该属性，继续第二步；
	 * 
	 * 从右往左截取第一个大写字母开头的字符串（此处为 Zip），然后检查剩下的字符串是否为 Message 的一个属性，如果是，则表示根据该属性进行查询；
	 * 如果没有该属性，则重复第二步，继续从右往左截取；最后假设 user 为 Message 的一个属性；
	 * 
	 * 接着处理剩下部分（ AddressZip ），先判断 user 所对应的类型是否有 addressZip 属性，如果有，则表示该方法最终是根据 "AccountInfo.user.addressZip" 的取值进行查询；
	 * 否则继续按照步骤 2 的规则从右往左截取，最终表示根据 "AccountInfo.user.address.zip" 的值进行查询。
	 */
	Message getById(long Id);
	Message getByname(String Name);
	
//  报错：No property id found for type String! Traversed path: Message.name.
//  最后解析为：Message.name.id进行查询，报错
//	Message getByNameId(long Id,String Name);	
	//可以解析通过
	Message getByAaBbCcDd(String AaBbCcDd);
    //解析为name And id 两个属性查询,属性顺序不能颠倒
	Message getByIdAndName(long Id,String Name);
	
	//可以通过对象删除,也可以批量删除
	void delete(Message message);
	
	@Modifying(clearAutomatically = true) 
	@Query("update Message tm set tm.name =?1 "			
			+ "where tm.id =?2")
	void updateName(@Param(value = "name")String name,
			@Param(value = "id")long id);
}
