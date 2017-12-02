package ie.cit.appdev.assginment2backend.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ie.cit.appdev.assginment2backend.repositories.FlowerRepo;
import ie.cit.appdev.assginment2backend.repositories.OrderRepo;

@Component
public class DataLoader implements ApplicationRunner{
	@Autowired 
	private OrderRepo orderDAO;
	@Autowired
	private FlowerRepo flowerDAO;

	@Override
	public void run(ApplicationArguments arg0) throws Exception
	{

		populateFlowers();
		populateOrders();
	}
	private void populateFlowers() {
		flowerDAO.insert(new Flower("Rose",0.50,1000));
		flowerDAO.insert(new Flower("Lily",0.50,900));
		flowerDAO.insert(new Flower("Daisy",0.50,1100));

	}
	private void populateOrders() {


		Random rand = new Random();

		for(int i=1;i<=3;i++)
		{

			
			int  roseQuantity = rand.nextInt(50) + 1;
			int  lilyQuantity = rand.nextInt(50) + 1;
			int  daisyQuantity = rand.nextInt(50) + 1;
			List<Flower> flowerList = flowerDAO.findAll();
			Flower roseOrder = null;
			Flower lilyOrder = null;
			Flower daisyOrder = null;
			for(Flower flower : flowerList)
			{
				if(flower.getName().equalsIgnoreCase("Rose"))
					roseOrder=flower;
				else if (flower.getName().equalsIgnoreCase("Lily"))
					lilyOrder=flower;
				else if(flower.getName().equalsIgnoreCase("Daisy"))
					daisyOrder=flower;
			}
			ArrayList<Flower> orderContents = new ArrayList<Flower>();
			flowerDAO.save(new Flower(roseOrder.getId(),"Rose",0.50,roseOrder.getQuantity()-roseQuantity));
			roseOrder.setQuantity(roseQuantity);

			flowerDAO.save(new Flower(lilyOrder.getId(),"Lily",0.50,lilyOrder.getQuantity()-lilyQuantity));
			lilyOrder.setQuantity(lilyQuantity);

			flowerDAO.save(new Flower(daisyOrder.getId(),"Daisy",0.50,daisyOrder.getQuantity()-daisyQuantity));
			daisyOrder.setQuantity(daisyQuantity);
			
			orderContents.add(roseOrder);
			orderContents.add(lilyOrder);
			orderContents.add(daisyOrder);
			double orderCost=0;
			for(Flower flower: orderContents)
			{
				orderCost+=(flower.getPrice()*flower.getQuantity());
			}
			if(orderCost<50.00)
				orderCost+=10.00;
			
			if(i==1)			
				orderDAO.save(new Order(1,"Larkin's flowers",orderContents,orderCost));
			else if (i==2)
				orderDAO.save(new Order(2,"Ryan's flowers", orderContents, orderCost));
			else
				orderDAO.save(new Order(3,"Philie's flowers", orderContents, orderCost));

		}

	}
}


