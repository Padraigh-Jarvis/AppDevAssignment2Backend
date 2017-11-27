package ie.cit.appdev.assginment2backend.repositories;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ie.cit.appdev.assginment2backend.entities.Order;

public interface OrderRepo extends MongoRepository<Order, Integer>{

//	@Query(value="{'florestId' : ?0 }")
	List<Order> findByFlorestId(int florestId);
}
