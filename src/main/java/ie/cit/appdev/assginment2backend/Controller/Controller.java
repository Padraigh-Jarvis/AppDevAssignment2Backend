package ie.cit.appdev.assginment2backend.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ie.cit.appdev.assginment2backend.entities.Flower;
import ie.cit.appdev.assginment2backend.entities.Order;
import ie.cit.appdev.assginment2backend.repositories.FlowerRepo;
import ie.cit.appdev.assginment2backend.repositories.OrderRepo;
import ie.cit.appdev.assginment2backend.utils.Worker;

@RestController
public class Controller {
	
	@Autowired
	OrderRepo orderDAO;
	
	@Autowired
	FlowerRepo flowerDAO;
	
	@Autowired
	Worker worker;
	
	@GetMapping("/flowerDetails")
	public Flower flowerDetails(@RequestParam(value="id") int id)
	{
		return flowerDAO.findOne(id);
	}
	
	@GetMapping("/myOrders") 
	public List<Order> myOrders(@RequestParam(value="id")int id)
	{
		return orderDAO.findByFlorestId(id);
	}

	@GetMapping("/allFlowers")
	public List<Flower> allFlowers()
	{
		return flowerDAO.findAll();
	}
	
	@PostMapping("/makeOrder")
	public boolean makeOrder(@RequestBody Order order) 
	{
		boolean success=worker.makeOrder(order);
		return success;
	}
	
	@DeleteMapping("/deleteOrder")
	public void deleteOrder(@RequestBody String orderId)
	{
		orderDAO.delete(orderId);
	}

	

}
