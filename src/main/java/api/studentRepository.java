package api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends CrudRepository <studentEntity, Integer>{

}
