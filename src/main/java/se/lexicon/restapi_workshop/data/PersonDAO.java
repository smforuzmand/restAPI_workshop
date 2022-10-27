package se.lexicon.restapi_workshop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import se.lexicon.restapi_workshop.model.entity.Person;

import java.util.List;

public interface PersonDAO extends JpaRepository<Person, Integer> {


    @Query("SELECT p FROM Person p where SIZE(p.todoItems)=0")
    List<Person> findByIdelPeople();
}
