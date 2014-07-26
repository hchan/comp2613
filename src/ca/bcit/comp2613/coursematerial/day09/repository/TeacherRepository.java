package ca.bcit.comp2613.coursematerial.day09.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.bcit.comp2613.coursematerial.day09.model.Teacher;


public interface TeacherRepository extends CrudRepository<Teacher, String> {
// 	see http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
    List<Teacher> findByLastName(String lastName);
}