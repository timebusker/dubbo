package aa.mine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aa.mine.dao.AdministratotDao;
import aa.mine.model.Administrator;

@Service
public class AdministratorService {
	
	@Autowired
	private AdministratotDao dao;

	public List<Administrator> getAdmin(int len) {
		// TODO Auto-generated method stub
		List<Administrator> listadmin = new ArrayList<Administrator>();
		for(int i=0;i<10;i++){
			int random=(int)(Math.random()*len);
			Administrator admin = dao.createAdmin(random);
			listadmin.add(admin);
		}
		return listadmin;
	}
}
