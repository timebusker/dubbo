package aa.mine.web.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aa.mine.interfaces.MenuService;
import aa.mine.model.Menu;

@Service
public class MenuBiz {

	@Autowired
	private MenuService menuService;
	
	public void saveMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuService.saveMenu(menu);
	}
	
	public void deleteMenu(long menuId) {
		// TODO Auto-generated method stub
		menuService.deleteMenu(menuId);
	}
	
	public Menu findMenubyId(long menuId) {
		// TODO Auto-generated method stub
		Menu Menu = menuService.findMenubyId(menuId);
		return Menu;
	}
	
	public List<Menu> findAllbyId(long menuId) {
		// TODO Auto-generated method stub
		List<Menu> listmenu =  menuService.findAllbyId(menuId);
		return listmenu;
	}
	
	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		List<Menu> listmenu =  menuService.findAll();
		return listmenu;
	}
}
