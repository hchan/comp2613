package ca.bcit.comp2613.coursematerial.day08.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.bcit.comp2613.coursematerial.day08.model.Teacher;


public interface TeacherRepository extends CrudRepository<Teacher, String> {

    List<Teacher> findByLastName(String lastName);
}