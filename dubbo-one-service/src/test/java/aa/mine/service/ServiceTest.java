package aa.mine.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import aa.mine.interfaces.MessageService;
import aa.mine.model.Message;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"/applicationContext.xml"}) 
public class ServiceTest {
	
	@Autowired
	private MessageService messageService;
	
	@Test
	public void testBean() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
	
	@Test
	public void testSprinDataJpa1() throws Exception {
		//插入数据
		Message message = new Message();
		message.setContent("AAAAAAAAAAAAAAAA");
		message.setName("CDEFGHI");
		Date date = new Date();
		message.setPublishDate(date);
		message.setPublisher("publisher");
		messageService.insterMessage(message);
		//单个对象条件查询
		message = messageService.getMessageByNameAndId(2, "AA");
		System.out.println("::::    "+JSON.toJSONString(message));
		message = messageService.getMessageById(1);
		System.out.println("::::    "+JSON.toJSONString(message));
		message = messageService.getMessageByName("BB");
		System.out.println("::::    "+JSON.toJSONString(message));		
	}
	
	@Test
	public void testSprinDataJpa2() throws Exception {
		//无条件全部查询
		//应用了简单的排序
		List<Message> listmessage = new ArrayList<Message>();
		listmessage = messageService.getall();
		System.out.println("::::    "+JSON.toJSONString(listmessage));
		//条件查询
		listmessage = messageService.findAllByCon("2016-09-06 20:41:30");
		System.out.println("::::    "+JSON.toJSONString(listmessage));		
		listmessage = messageService.findAllByCon(2,8);
		System.out.println("::::    "+JSON.toJSONString(listmessage));
		//统计数量
		int i = 0;
		i = messageService.findCount();
		System.out.println("*****************        "+i);
		i = messageService.findCount(1, 6);
		System.out.println("*****************        "+i);
	}
	
	@Test
	public void testSprinDataJpa3() throws Exception {	
		Message message = new Message();		
		message = messageService.getMessageById(1);
		List<Message> listmessage = new ArrayList<Message>();				
		listmessage = messageService.findAllByCon(2,8);	
		//删除数据
		messageService.deleteMessage(message);
		System.out.println("**********************************************");
		messageService.deleteMessages(listmessage);
		System.out.println("**********************************************");
	}
	
	@Test	
	public void testSprinDataJpa4() throws Exception {
		Message message = new Message();
		message = messageService.getMessageById(1);
		System.out.println("::::    "+JSON.toJSONString(message));
		
//		List<Message> listmessage = new ArrayList<Message>();		
//		listmessage = messageService.findAllByCon(2,8);				
		//更新数据
		message.setName("QAZXCVB");
//		System.out.println("::::    "+JSON.toJSONString(message));
		messageService.updateMessage(message);
		message = messageService.getMessageById(1);
		System.out.println("::::    "+JSON.toJSONString(message));
		
	}
	
	@Test
	public void testSprinDataJpa5() throws Exception {
		//分页查询
		Page<Message> PageMessage = messageService.findAllPage(2, 5);
		System.out.println("::::    "+JSON.toJSONString(PageMessage.getContent()));
		
		
	}
}
