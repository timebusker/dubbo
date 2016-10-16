package aa.mine.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import aa.mine.interfaces.MenuService;
import aa.mine.model.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/spring.xml" })
public class MenuServiceTes {

	@Autowired
	private MenuService menuService;
	
	@Test
	public void findAll() throws Exception {
		List<Menu> listmenu = menuService.findAll();
		System.out.println(JSON.toJSONString(listmenu));
	}
}
