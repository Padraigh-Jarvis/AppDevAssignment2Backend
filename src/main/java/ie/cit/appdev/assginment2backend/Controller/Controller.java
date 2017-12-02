package ie.cit.appdev.assginment2backend.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ie.cit.appdev.assginment2backend.entities.Flower;
import ie.cit.appdev.assginment2backend.entities.Order;
import ie.cit.appdev.assginment2backend.utils.Worker;

@RestController
public class Controller {

	@Autowired
	private Worker worker;
	
	@GetMapping("/flowerDetails")
	public Flower flowerDetails(@RequestParam(value="id") String id)
	{		
		Flower f =worker.flowerDetails(id);
		return f;
	}
	
	@GetMapping("/myOrders") 
	public List<Order> myOrders(@RequestParam(value="id")int id)
	{
		List<Order> orders = worker.myOrders(id);
		return orders;
	}

	@GetMapping("/allFlowers")
	public List<Flower> allFlowers()
	{
		List<Flower> flowers = worker.allFlowers();
		return flowers;
	}
	
	@PostMapping("/makeOrder")
	public boolean makeOrder(@RequestBody Order order) 
	{
		boolean success=worker.makeOrder(order);
		return success;
	}
	
	@DeleteMapping("/deleteOrder/{orderId}")
	public void deleteOrder(@PathVariable String orderId)
	{
		worker.deleteOrder(orderId);
	}

	

}
