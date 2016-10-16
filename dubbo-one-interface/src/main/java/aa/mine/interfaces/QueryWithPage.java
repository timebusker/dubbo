package aa.mine.interfaces;

import java.util.List;
import aa.mine.model.Message;
/**
 * 本接口主要实现自定义SQL查询
 * @author Administrator
 *
 */
public interface QueryWithPage {

	/******************************此部分为单表查询操作*************************************/
	// 分页查询所有数据
	List<Message> findAllPage(int pageNumber, int pageSize);

	// 条件分页查询
	List<Message> findAllByConPage(int pageNumber, int pageSize, String con);

	List<Message> findAllByConPage(int pageNumber, int pageSize, long con1, long con2);
}
