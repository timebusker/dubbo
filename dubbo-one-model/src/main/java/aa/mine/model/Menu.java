package aa.mine.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu implements Serializable{

	
	private static final long serialVersionUID = 1081552793300809602L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long menuId;

	@Column(nullable = false, updatable = false)
	private long parentMenuId;

	@Column(nullable = false, updatable = false, length = 32)
	private String menuName;

	@Column(nullable = false, updatable = false, length = 16)
	private String menuPosition;

	@Column(nullable = false, updatable = false)
	private int menuOrder;

	@Column(nullable = false, updatable = false, length = 128)
	private String menuDesc;

	@Column(nullable = false, updatable = false)
	private Date menuCreateDate;

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public long getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(long parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuPosition() {
		return menuPosition;
	}

	public void setMenuPosition(String menuPosition) {
		this.menuPosition = menuPosition;
	}

	public int getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public Date getMenuCreateDate() {
		return menuCreateDate;
	}

	public void setMenuCreateDate(Date menuCreateDate) {
		this.menuCreateDate = menuCreateDate;
	}

}
