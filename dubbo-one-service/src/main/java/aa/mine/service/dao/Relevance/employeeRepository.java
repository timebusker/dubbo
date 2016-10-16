package aa.mine.service.dao.Relevance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aa.mine.model.Relevance.employee;

public interface employeeRepository extends JpaRepository<employee, Long> {

	@Modifying(clearAutomatically = true) 
	@Query("update employee set empName =?1 "			
			+ "where empId =?2")
	void updateName(@Param(value = "name")String name,
			@Param(value = "id")long id);
}
