package ie.cit.appdev.assginment2backend.repositories;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ie.cit.appdev.assginment2backend.entities.Order;

public interface OrderRepo extends MongoRepository<Order, String>{

	List<Order> findByFlorestId(int florestId);
}
