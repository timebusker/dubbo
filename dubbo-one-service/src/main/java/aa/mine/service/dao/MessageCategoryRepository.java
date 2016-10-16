package aa.mine.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import aa.mine.model.MessageCategory;

public interface MessageCategoryRepository extends JpaRepository<MessageCategory, Long> {

}
