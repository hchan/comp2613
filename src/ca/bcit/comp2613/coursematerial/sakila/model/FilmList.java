package ca.bcit.comp2613.coursematerial.sakila.model;

// Generated Jul 10, 2014 8:59:31 PM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * FilmList generated by hbm2java
 */
@Entity
@Table(name = "film_list", catalog = "sakila")
public class FilmList implements java.io.Serializable {

	private FilmListId id;

	public FilmList() {
	}

	public FilmList(FilmListId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "fid", column = @Column(name = "FID")),
			@AttributeOverride(name = "title", column = @Column(name = "title")),
			@AttributeOverride(name = "description", column = @Column(name = "description", length = 65535)),
			@AttributeOverride(name = "category", column = @Column(name = "category", nullable = false, length = 25)),
			@AttributeOverride(name = "price", column = @Column(name = "price", precision = 4)),
			@AttributeOverride(name = "length", column = @Column(name = "length")),
			@AttributeOverride(name = "rating", column = @Column(name = "rating", length = 5)),
			@AttributeOverride(name = "actors", column = @Column(name = "actors", length = 65535)) })
	public FilmListId getId() {
		return this.id;
	}

	public void setId(FilmListId id) {
		this.id = id;
	}

}
