package ca.bcit.comp2613.coursematerial.sakila.model;

// Generated Jul 10, 2014 12:08:13 PM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * StaffList generated by hbm2java
 */
@Entity
@Table(name = "staff_list", catalog = "sql345717")
public class StaffList implements java.io.Serializable {

	private StaffListId id;

	public StaffList() {
	}

	public StaffList(StaffListId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "ID")),
			@AttributeOverride(name = "name", column = @Column(name = "name")),
			@AttributeOverride(name = "address", column = @Column(name = "address")),
			@AttributeOverride(name = "zipCode", column = @Column(name = "zip code")),
			@AttributeOverride(name = "phone", column = @Column(name = "phone")),
			@AttributeOverride(name = "city", column = @Column(name = "city")),
			@AttributeOverride(name = "country", column = @Column(name = "country")),
			@AttributeOverride(name = "sid", column = @Column(name = "SID")) })
	public StaffListId getId() {
		return this.id;
	}

	public void setId(StaffListId id) {
		this.id = id;
	}

}
