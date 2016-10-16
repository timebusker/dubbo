package aa.mine.model;

import java.util.Date;

public class Administrator {

	private long adminId;
	
	private String adminName;
	
	private String adminrloe;
	
	private Date lastLoginDate;

	
	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminrloe() {
		return adminrloe;
	}

	public void setAdminrloe(String adminrloe) {
		this.adminrloe = adminrloe;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
		
}
