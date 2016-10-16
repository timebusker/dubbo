package aa.mine.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import aa.mine.model.Relevance.detailInfo;
import aa.mine.model.Relevance.employee;
import aa.mine.service.dao.Relevance.UserRepository;
import aa.mine.service.dao.Relevance.companyRepository;
import aa.mine.service.dao.Relevance.departmentRepository;
import aa.mine.service.dao.Relevance.detailInfoRepository;
import aa.mine.service.dao.Relevance.employeeRepository;
import aa.mine.service.dao.Relevance.positionRepository;

/**
 * 测试JPA的关联关系
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class RelevanceTest {
	
	@SuppressWarnings("unused")
	@Autowired
	private companyRepository companyRe;
	
	@SuppressWarnings("unused")
	@Autowired
	private departmentRepository departmentRe;
	
	@Autowired
	private detailInfoRepository detailInfoRe;
	
	@Autowired
	private employeeRepository employeeRe;
	
	@SuppressWarnings("unused")
	@Autowired
	private positionRepository positionRe;
	
	@SuppressWarnings("unused")
	@Autowired
	private UserRepository UserRe;

	// 测试一对一
	@Test
	public void test1_add() throws Exception {
		// 实体关联的控制端对于关系的维护起主导作用，比如：在保存employee时，为完成一对一关联，必须实现
		//em.setDetailInfo(de);建立对应关系（强调控制端对关系的）		
		//信息附属端作为控制端才能够保证信息的一致性和完整性		
		// 两个实体的Cascade（串联）关系决定了实体操作的简便性，比如：下面不需要手动保存detailInfo
		//顺序问题
//		employee em = new employee();
//		em.setEmpName("timebusker");		
//		detailInfo de = new detailInfo();
//		de.setDetName("信息中心");
//		de.setEmployee(em);		
//		//employeeRe.save(em);
//		detailInfoRe.save(de);
//		
//		User user = new User("name");  
//        Address address = new Address("street", "city");  
//        user.setAddress(address);  
//        //不添加报错：attempted to assign id from null one-to-one property: user  
//        address.setUser(user);
//        UserRe.save(user);
	}
	
	@Test
	public void test1_del() throws Exception {		
		detailInfo de = new detailInfo();
		employee em = new employee();
		
		de = detailInfoRe.findOne(1L);
		System.out.println(JSON.toJSONString(de));
		em = employeeRe.findOne(1L);
		System.out.println(JSON.toJSONString(em));
		//detailInfoRe.delete(de);
		//employeeRe.delete(em);
		
	}

	// 测试一对多--单向
	@Test
	public void test2() throws Exception {

	}

	// 测试一对多--双向
	@Test
	public void test3() throws Exception {

	}

	// 测试多对一
	@Test
	public void test4() throws Exception {

	}

	// 测试多对多
	@Test
	public void test5() throws Exception {

	}
}
