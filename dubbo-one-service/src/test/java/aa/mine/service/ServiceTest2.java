package aa.mine.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import aa.mine.interfaces.QueryWithPage;
import aa.mine.model.Message;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"/applicationContext.xml"}) 
public class ServiceTest2 {

	@Autowired
	private QueryWithPage queryWithPage;
	
	@Test
	public void test1() throws Exception {
		List<Message> listMessage =null;
		listMessage = queryWithPage.findAllPage(1, 3);
		System.out.println(JSON.toJSONString(listMessage));
	}
}
