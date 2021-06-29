package ITProgs.inheritance.hibernate.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ITProgs.inheritance.hibernate.entites.ParentEntity;

public interface ParentRepository extends CrudRepository<ParentEntity, Long> {
	
	
}
