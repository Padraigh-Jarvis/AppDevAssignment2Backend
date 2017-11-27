package ie.cit.appdev.assginment2backend.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ie.cit.appdev.assginment2backend.entities.Flower;
import ie.cit.appdev.assginment2backend.entities.Order;
import ie.cit.appdev.assginment2backend.repositories.FlowerRepo;
import ie.cit.appdev.assginment2backend.repositories.OrderRepo;

@RestController
public class Controller {
	
	@Autowired
	OrderRepo orderDAO;
	
	@Autowired
	FlowerRepo flowerDAO;
	
	@GetMapping("/myOrders") //Working with only 1 order for each florest in DB
	public List<Order> myOrders(@RequestParam(value="id")int id, Model model)
	{
		return orderDAO.findByFlorestId(id);
	}

	@GetMapping("/allFlowers")//Working
	public List<Flower> allFlowers()
	{
		return flowerDAO.findAll();
	}
	
	
	@PostMapping("/makeOrder")
	public void makeOrder(Order order) 
	{
		orderDAO.save(order); 
		//need to subtract the number of flowers ordered from the total stock. Do we do it here or somewhere else?
	}
	
//	
//	@GetMapping("/test")
//	public List<Order> apiTest() {
//		return orderDAO.findAll();
//	}
//	
//	@PostMapping("/postTest")
//	public void postTest(Order test)
//	{
//		System.out.println(test);
//		orderDAO.save(test);
//	}
}
