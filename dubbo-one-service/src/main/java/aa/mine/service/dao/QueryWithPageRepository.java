package aa.mine.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import aa.mine.model.Message;

@Repository
public class QueryWithPageRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
		
	public List<Message> findAllPage(int pageNumber, int pageSize) {
		/**
		 * 错误写法：
		 * String sql = "SELECT Message FROM Message";
		 */
		String sql = "SELECT tm.name FROM Message tm";
		@SuppressWarnings("unchecked")
		List<Message> listMessage = entityManager.createQuery(sql).getResultList();
		return listMessage;
	}
	
	public List<Message> findAllByConPage(int pageNumber, int pageSize, String con) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Message> findAllByConPage(int pageNumber, int pageSize, long con1, long con2) {
		// TODO Auto-generated method stub
		return null;
	}

}
