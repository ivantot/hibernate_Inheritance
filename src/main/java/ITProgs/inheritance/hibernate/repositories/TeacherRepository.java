package ITProgs.inheritance.hibernate.repositories;

import org.springframework.data.repository.CrudRepository;

import ITProgs.inheritance.hibernate.entites.TeacherEntity;

public interface TeacherRepository extends CrudRepository<TeacherEntity, Long> {

}
