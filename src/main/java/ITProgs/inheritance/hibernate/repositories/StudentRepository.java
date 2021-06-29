package ITProgs.inheritance.hibernate.repositories;

import org.springframework.data.repository.CrudRepository;

import ITProgs.inheritance.hibernate.entites.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {

}
