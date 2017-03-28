package citi.hibernate.entity;
// Generated 2017-3-23 19:40:30 by Hibernate Tools 5.2.1.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Stationery generated by hbm2java
 */
@JsonIgnoreProperties({"orderses"})
public class Stationery implements java.io.Serializable {

	private Integer stationeryId;
	private String kind;
	private String name;
	private String standard;
	private BigDecimal price;
	@JsonIgnore
	private Set orderses = new HashSet(0);

	public Stationery() {
	}

	public Stationery(String kind, String name, String standard, BigDecimal price) {
		this.kind = kind;
		this.name = name;
		this.standard = standard;
		this.price = price;
	}
	public Stationery(Integer stationeryId, String kind, String name, String standard, BigDecimal price) {
		this.stationeryId = stationeryId;
		this.kind = kind;
		this.name = name;
		this.standard = standard;
		this.price = price;
	}
	public Stationery(String kind, String name, String standard, BigDecimal price, Set orderses) {
		this.kind = kind;
		this.name = name;
		this.standard = standard;
		this.price = price;
		this.orderses = orderses;
	}

	public Integer getStationeryId() {
		return this.stationeryId;
	}

	public void setStationeryId(Integer stationeryId) {
		this.stationeryId = stationeryId;
	}

	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStandard() {
		return this.standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@JsonIgnore
	public Set getOrderses() {
		return this.orderses;
	}
	@JsonIgnore
	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

}
