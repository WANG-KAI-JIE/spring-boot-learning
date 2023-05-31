package top.kjwang.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import top.kjwang.domain.Person;

import java.util.List;

/**
 * @author kjwang
 * @date 2023/3/30 16:19
 * @description PersonRepository
 */
public interface PersonRepository extends CrudRepository<Person, String> {
    List<Person> findByLastname(String lastname);

    Page<Person> findPersonByLastname(String lastname, Pageable page);

    List<Person> findByFirstnameAndLastname(String firstname, String lastname);

    List<Person> findByAddressCity(String city);

    List<Person> findByFamilyListUsername(String username);
}