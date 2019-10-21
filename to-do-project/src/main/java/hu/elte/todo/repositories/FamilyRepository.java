package hu.elte.todo.repositories;

import hu.elte.todo.entities.Family;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FamilyRepository extends CrudRepository<Family, Integer> {
  //Family findByFamilyName(String name); 

}
