package aa.mine.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aa.mine.interfaces.MenuService;
import aa.mine.model.Menu;
import aa.mine.service.dao.MenuRespository;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuRespository menuRespository;

	@Override
	public void saveMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuRespository.save(menu);
	}

	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMenu(long menuId) {
		// TODO Auto-generated method stub
		menuRespository.delete(menuId);
	}

	@Override
	public Menu findMenubyId(long menuId) {
		// TODO Auto-generated method stub
		Menu Menu = menuRespository.findOne(menuId);
		return Menu;
	}

	@Override
	public List<Menu> findAllbyId(long menuId) {
		// TODO Auto-generated method stub
		List<Menu> listmenu =  menuRespository.findAll();
		return listmenu;
	}

	@Override
	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		List<Menu> listmenu =  menuRespository.findAll();
		return listmenu;
	}

}
