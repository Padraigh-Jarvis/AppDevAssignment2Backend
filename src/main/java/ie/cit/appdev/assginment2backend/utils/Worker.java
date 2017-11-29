package ie.cit.appdev.assginment2backend.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ie.cit.appdev.assginment2backend.entities.Flower;
import ie.cit.appdev.assginment2backend.entities.Order;
import ie.cit.appdev.assginment2backend.repositories.FlowerRepo;
import ie.cit.appdev.assginment2backend.repositories.OrderRepo;

@Service 
public class Worker {

	@Autowired 
	FlowerRepo flowerDAO;
	

	@Autowired 
	OrderRepo orderDAO;
	
	
	@Transactional
	public boolean makeOrder(Order order)
	{
		
		for(Flower flower: order.getContents())
		{
			int currentFlowerStock= flowerDAO.findOne(flower.getId()).getQuantity();
			if (currentFlowerStock>= flower.getQuantity())
			{
				flowerDAO.save(new Flower(flower.getId(),flower.getName(),flower.getPrice(),currentFlowerStock-flower.getQuantity()));
				orderDAO.save(order);
				return true;
			}
			else 
				return false;
		}
		return false;
	}
	
	
}
