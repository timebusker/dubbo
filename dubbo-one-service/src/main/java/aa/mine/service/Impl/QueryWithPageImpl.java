package aa.mine.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aa.mine.interfaces.QueryWithPage;
import aa.mine.model.Message;
import aa.mine.service.dao.QueryWithPageRepository;

@Service
public class QueryWithPageImpl implements QueryWithPage {

	@Autowired
	private QueryWithPageRepository queryWithRepository;
	
	@Override
	public List<Message> findAllPage(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return queryWithRepository.findAllPage(pageNumber, pageSize);
	}

	@Override
	public List<Message> findAllByConPage(int pageNumber, int pageSize, String con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findAllByConPage(int pageNumber, int pageSize, long con1, long con2) {
		// TODO Auto-generated method stub
		return null;
	}

}
