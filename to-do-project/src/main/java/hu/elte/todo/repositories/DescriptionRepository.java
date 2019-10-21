package hu.elte.todo.repositories;

import hu.elte.todo.entities.Description;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DescriptionRepository extends CrudRepository<Description, Integer> {

}

