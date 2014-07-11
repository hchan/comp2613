package ca.bcit.comp2613.coursematerial.sakila;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.bcit.comp2613.coursematerial.sakila.model.Actor;

public interface ActorRepository extends CrudRepository<Actor, Short> {
}