package ca.bcit.comp2613.coursematerial.day08.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ca.bcit.comp2613.coursematerial.day08.model.Student;


public interface StudentRepository extends CrudRepository<Student, Long> {

	
	@Query("select s from Student s where s.firstName = :firstName or s.lastName = :lastName")
	Student findByLastnameOrFirstname(@Param("lastName") String lastName,
	                                 @Param("firstName") String firstFame);
	
	/*
	 List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
	
	@Modifying
	@Query("update Student s set s.firstName = ?1 where u.lastName = ?2")
	int setFixedFirstnameFor(String firstName, String lastName);
	*/
}