package aa.mine.web.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import aa.mine.model.Menu;
import aa.mine.web.biz.MenuBiz;

@Controller
//@RequestMapping("/*")
public class MenuController {

	private static Logger log = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuBiz menuBiz;
	
	@RequestMapping(value="/menus",method=RequestMethod.GET)
	private @ResponseBody List<Menu> showMenu(){
		List<Menu> listmenu = menuBiz.findAll();
		//log.info(JSON.toJSONString(listmenu));
		return listmenu;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.GET)
	private void saveMenu(){
		for(int i=0;i<10;i++){
			Menu menu = new Menu();
			menu.setMenuCreateDate(new Date());
			menu.setMenuDesc("ceshi");
			menu.setMenuName("ceshi");
			menu.setMenuOrder(i);
			menu.setMenuPosition("shouye");
			if(i%3==0){				
				menu.setParentMenuId(i);
			}else{
				menu.setParentMenuId(0L);
			}
			menuBiz.saveMenu(menu);
		}
	}
}
