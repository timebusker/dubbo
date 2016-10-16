package aa.mine.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import aa.mine.model.Administrator;
import aa.mine.utils.commonUtil;

@Repository
public class AdministratotDao {

	private Administrator admin = new Administrator();
	
	public Administrator createAdmin(int random) {
		// TODO Auto-generated method stub
		admin.setAdminId(System.currentTimeMillis());
		admin.setAdminName(commonUtil.getRandomString(random));
		admin.setAdminrloe("**********************");
		admin.setLastLoginDate(new Date());
		return admin;
	}
}
