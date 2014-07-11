package ca.bcit.comp2613.coursematerial.sakila.model;

// Generated Jul 10, 2014 12:08:13 PM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ActorInfo generated by hbm2java
 */
@Entity
@Table(name = "actor_info", catalog = "sql345717")
public class ActorInfo implements java.io.Serializable {

	private ActorInfoId id;

	public ActorInfo() {
	}

	public ActorInfo(ActorInfoId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "actorId", column = @Column(name = "actor_id")),
			@AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
			@AttributeOverride(name = "lastName", column = @Column(name = "last_name")),
			@AttributeOverride(name = "filmInfo", column = @Column(name = "film_info")) })
	public ActorInfoId getId() {
		return this.id;
	}

	public void setId(ActorInfoId id) {
		this.id = id;
	}

}
