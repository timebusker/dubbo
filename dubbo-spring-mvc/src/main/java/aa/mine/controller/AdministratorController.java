package aa.mine.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import aa.mine.model.Administrator;
import aa.mine.service.AdministratorService;

@Controller
public class AdministratorController {

	@Autowired
	private AdministratorService service;
	
	@RequestMapping("/admin/{len}")
	private String index(@PathVariable("len") Integer len,
			Map<String, Object> model) {
		List<Administrator> listadmin = new ArrayList<Administrator>();	
		listadmin = service.getAdmin(len);
		System.out.println("******************************************");
		model.put("admin",listadmin.get(0));
		return "index";
	}
	
	@RequestMapping(value = "/admins*")
	@ResponseBody
	private List<Administrator> showAdmin() {
		List<Administrator> listadmin = new ArrayList<Administrator>();	
		listadmin = service.getAdmin(5);
		System.out.println("******************************************");
		return listadmin;
	}
}
