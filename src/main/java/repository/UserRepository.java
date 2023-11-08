package repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import model.UserModel;


public interface UserRepository extends MongoRepository<UserModel, String> 
{
    @Query("{'name': ?0}")
    List<UserModel> findByName(String name);

    @Query("{name: ?1, 'age': ?0}")
    List<UserModel> findByAgeName(short age, String name);

     
}
