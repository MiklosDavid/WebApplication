package hu.elte.todo.repositories;

import hu.elte.todo.entities.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {
   Optional<User> findByUsername(String username);
}
