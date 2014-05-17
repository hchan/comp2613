package ca.bcit.comp2613.coursematerial.day09.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.bcit.comp2613.coursematerial.day09.model.Student;
import ca.bcit.comp2613.coursematerial.day09.model.Teacher;


public interface StudentRepository extends CrudRepository<Student, Long> {

}