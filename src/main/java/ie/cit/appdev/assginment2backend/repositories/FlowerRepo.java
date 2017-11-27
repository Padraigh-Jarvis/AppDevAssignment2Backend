package ie.cit.appdev.assginment2backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ie.cit.appdev.assginment2backend.entities.Flower;

public interface FlowerRepo extends MongoRepository<Flower, Integer> {

}
