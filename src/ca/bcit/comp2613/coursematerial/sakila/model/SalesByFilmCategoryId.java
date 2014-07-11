package ca.bcit.comp2613.coursematerial.sakila.model;

// Generated Jul 10, 2014 12:08:13 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SalesByFilmCategoryId generated by hbm2java
 */
@Embeddable
public class SalesByFilmCategoryId implements java.io.Serializable {

	private Integer category;
	private Integer totalSales;

	public SalesByFilmCategoryId() {
	}

	public SalesByFilmCategoryId(Integer category, Integer totalSales) {
		this.category = category;
		this.totalSales = totalSales;
	}

	@Column(name = "category")
	public Integer getCategory() {
		return this.category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	@Column(name = "total_sales")
	public Integer getTotalSales() {
		return this.totalSales;
	}

	public void setTotalSales(Integer totalSales) {
		this.totalSales = totalSales;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SalesByFilmCategoryId))
			return false;
		SalesByFilmCategoryId castOther = (SalesByFilmCategoryId) other;

		return ((this.getCategory() == castOther.getCategory()) || (this
				.getCategory() != null && castOther.getCategory() != null && this
				.getCategory().equals(castOther.getCategory())))
				&& ((this.getTotalSales() == castOther.getTotalSales()) || (this
						.getTotalSales() != null
						&& castOther.getTotalSales() != null && this
						.getTotalSales().equals(castOther.getTotalSales())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCategory() == null ? 0 : this.getCategory().hashCode());
		result = 37
				* result
				+ (getTotalSales() == null ? 0 : this.getTotalSales()
						.hashCode());
		return result;
	}

}
