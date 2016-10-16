package aa.mine.interfaces;

import java.util.List;
import org.springframework.data.domain.Page;

import aa.mine.model.Message;

/**
 * 本接口继承JpaRepository接口，实现简单的分页、排序、
 * 方法名解析创建查询、删除（批量）、更新
 * 全为单表操作
 * 
 */
public interface MessageService {

	List<Message> getall();

	// 条件查询
	List<Message> findAllByCon(String con);

	List<Message> findAllByCon(long con1, long con2);

	Message getMessageById(long id);

	Message getMessageByName(String name);

	Message getMessageByNameAndId(long id, String name);

	// 更新	
	Message updateMessage(Message message);

	// 删除
	Message deleteMessage(Message message);

	List<Message> deleteMessages(List<Message> listmessage);

	// 增加对象
	Message insterMessage(Message message);

	// 统计数量
	Integer findCount();

	Integer findCount(long con1, long con2);

	// 简单分页查询
	Page<Message> findAllPage(int pageNumber, int pageSize);
}
