package ca.bcit.comp2613.coursematerial.sakila.model;

// Generated Jul 10, 2014 9:29:20 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Inventory generated by hbm2java
 */
@Entity
@Table(name = "inventory", catalog = "sakila")
public class Inventory implements java.io.Serializable {

	private Integer inventoryId;
	private Store store;
	private Film film;
	private Date lastUpdate;
	private Set<Rental> rentals = new HashSet<Rental>(0);

	public Inventory() {
	}

	public Inventory(Store store, Film film, Date lastUpdate) {
		this.store = store;
		this.film = film;
		this.lastUpdate = lastUpdate;
	}

	public Inventory(Store store, Film film, Date lastUpdate,
			Set<Rental> rentals) {
		this.store = store;
		this.film = film;
		this.lastUpdate = lastUpdate;
		this.rentals = rentals;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "inventory_id", unique = true, nullable = false)
	public Integer getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id", nullable = false)
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id", nullable = false)
	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false, length = 19)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventory")
	public Set<Rental> getRentals() {
		return this.rentals;
	}

	public void setRentals(Set<Rental> rentals) {
		this.rentals = rentals;
	}

}
