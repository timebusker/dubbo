package aa.mine.interfaces;

import java.util.List;

import aa.mine.model.Menu;

public interface MenuService {

	/**
	 * 保存菜单项
	 * @param menu
	 */
	void saveMenu(Menu menu);
	
	/**
	 * 更新菜单项
	 * @param menu
	 */
	void updateMenu(Menu menu);
	
	/**
	 * 删除菜单项
	 * @param menuId
	 */
	void deleteMenu(long menuId);
	
	/**
	 * 查询菜单项
	 * @param menuId
	 * @return
	 */
	Menu findMenubyId(long menuId);
	
	/**
	 * 查询所有子菜单
	 * @param menuId
	 * @return
	 */
	List<Menu> findAllbyId(long menuId);
	
	/**
	 * 查询所有菜单
	 * @return
	 */
	List<Menu> findAll();
}
