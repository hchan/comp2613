package ca.bcit.comp2613.coursematerial.sakila.model;

// Generated Jul 10, 2014 8:59:31 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FilmCategoryId generated by hbm2java
 */
@Embeddable
public class FilmCategoryId implements java.io.Serializable {

	private short filmId;
	private byte categoryId;

	public FilmCategoryId() {
	}

	public FilmCategoryId(short filmId, byte categoryId) {
		this.filmId = filmId;
		this.categoryId = categoryId;
	}

	@Column(name = "film_id", nullable = false)
	public short getFilmId() {
		return this.filmId;
	}

	public void setFilmId(short filmId) {
		this.filmId = filmId;
	}

	@Column(name = "category_id", nullable = false)
	public byte getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(byte categoryId) {
		this.categoryId = categoryId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FilmCategoryId))
			return false;
		FilmCategoryId castOther = (FilmCategoryId) other;

		return (this.getFilmId() == castOther.getFilmId())
				&& (this.getCategoryId() == castOther.getCategoryId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getFilmId();
		result = 37 * result + this.getCategoryId();
		return result;
	}

}
