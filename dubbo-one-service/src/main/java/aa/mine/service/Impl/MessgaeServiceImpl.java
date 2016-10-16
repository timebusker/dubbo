package aa.mine.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import aa.mine.interfaces.MessageService;
import aa.mine.model.Message;
import aa.mine.service.dao.MessageRepository;

@Service
//@Transactional
/**
 * Spring-data在更新数据时，需要在service层或者respository(持久层)
 * 添加事务管理，否则更新数据会无法提交。
 */
public class MessgaeServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	// 构建PageRequest，实现分页查询
	private PageRequest buildPageRequest(int pageNumber, int pagzSize) {
		return new PageRequest(pageNumber - 1, pagzSize, null);
	}

	@Override
	public List<Message> getall() {
		// TODO Auto-generated method stub
		Sort sort = new Sort(Sort.Direction.DESC, "id")
				.and(new Sort(Sort.Direction.ASC, "name"));
		return messageRepository.findAll(sort);
	}

	@Override
	public Message getMessageById(long id) {
		// TODO Auto-generated method stub
		return messageRepository.findOne(id);
	}

	@Override
	public Message getMessageByName(String name) {
		// TODO Auto-generated method stub
		return messageRepository.getByname(name);
	}

	@Override
	public Message updateMessage(Message message) {
		// TODO Auto-generated method stub
		messageRepository.updateName(message.getName(),
				message.getId());		
		return message;
	}

	@Override
	public Message deleteMessage(Message message) {
		// TODO Auto-generated method stub
		messageRepository.delete(message);
		return message;
	}

	@Override
	public Message insterMessage(Message message) {
		// TODO Auto-generated method stub
		return messageRepository.save(message);
	}

	@Override
	public Message getMessageByNameAndId(long id, String name) {
		// TODO Auto-generated method stub
		return messageRepository.getByIdAndName(id, name);
	}

	@Override
	public List<Message> findAllByCon(String con) {
		// TODO Auto-generated method stub
		return messageRepository.findAllByCon(con);
	}

	@Override
	public List<Message> findAllByCon(long con1, long con2) {
		// TODO Auto-generated method stub
		return messageRepository.findAllByCon(con1, con2);
	}

	@Override
	public Integer findCount() {
		// TODO Auto-generated method stub
		return messageRepository.findCount();
	}

	@Override
	public Integer findCount(long con1, long con2) {
		// TODO Auto-generated method stub
		return messageRepository.findCount(con1, con2);
	}

	@Override
	public List<Message> deleteMessages(List<Message> listmessage) {
		// TODO Auto-generated method stub
		messageRepository.delete(listmessage);
		return listmessage;
	}

	// 简单的分页查询
	@Override
	public Page<Message> findAllPage(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		PageRequest pageable = this.buildPageRequest(pageNumber, pageSize);
		Page<Message> PageMessage = messageRepository.findAll(pageable);
		return PageMessage;
	}

}
