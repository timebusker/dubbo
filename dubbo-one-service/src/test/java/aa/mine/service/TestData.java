package aa.mine.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aa.mine.interfaces.MessageService;
import aa.mine.model.Message;
import aa.mine.model.MessageCategory;
import aa.mine.service.dao.MessageCategoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class TestData {

	@Autowired
	private MessageService messageService;

	@Autowired
	private MessageCategoryRepository cateRepository;

	@Test
	public void InsterData() throws Exception {
		for (int i = 0; i < 10; i++) {
			MessageCategory cate = new MessageCategory();
			Message message = new Message();			
			cate.setCateName(getUUID().substring(0, 16));
			cate.setDescCate(getUUID().substring(17, 32));
			cate.setVersion(getDate());
			cateRepository.save(cate);
			
			//cate.setCateId(10);
			
			//在保存message的同时也保存了MessageCategory
			
			//message.setId(System.currentTimeMillis());
			message.setContent(getUUID());
			message.setName(getUUID().substring(0, 16));
			Date date = new Date();
			message.setPublishDate(date);
			message.setPublisher(getUUID().substring(17, 32));
			message.setCate(cate);
			message.setAaBbCcDd("AABBCCDD");
			message.setVersion(getDate());
			messageService.insterMessage(message);
		}
	}

	public String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString().replace("-", "");
		System.out.println(str.length());
		return str;
	}
	
	public long getDate(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date date = new Date();
		String dateStr = sdf.format(date);
		System.out.println(dateStr);
		return Long.parseLong(dateStr);
	}
}
