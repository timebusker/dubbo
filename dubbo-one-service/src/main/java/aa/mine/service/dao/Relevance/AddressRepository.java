package aa.mine.service.dao.Relevance;

import org.springframework.data.jpa.repository.JpaRepository;

import aa.mine.model.OneToOne.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
