package aa.mine.service.dao.Relevance;

import org.springframework.data.jpa.repository.JpaRepository;

import aa.mine.model.OneToOne.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
