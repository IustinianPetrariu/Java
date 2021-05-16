package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Service;
import rest.model.Person;

@Service   ///for dependency injection
@RestResource(exported = false) /// hide from public
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
