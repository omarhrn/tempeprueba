package com.omarhrn.TempePrueba.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entidad <i>Price</i>
 *
 * <p>
 * Entidad que representa los distintos precios aplicables
 * </p>
 * @author omarhrn
 *
 */
@Entity
@Table(name = "PRICES")
@Data
public class Price implements Serializable{

	private static final long serialVersionUID = -5893297324903358243L;
	
	/**
	 * Identificador de la tarifa de precios aplicable
	 */
	@Id
	@Column(name = "PRICE_LIST")
	private Integer priceList;
	
	/**
	 * Identificador de la cadena del grupo
	 */
	@Column(name = "BRAND_ID")
	private Integer brandId;
	
	/**
	 * Inicio de rango de fechas en el que aplica el precio tarifa indicado
	 */
	@Column(name = "START_DATE")
	private Date startDate;
	
	/**
	 * Fin de rango de fechas en el que aplica el precio tarifa indicado
	 */
	@Column(name = "END_DATE")
	private Date endDate;
		
	/**
	 * Identificador código del producto
	 */
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	/**
	 * Desambiguador de aplicación de precios. 
	 * Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico).
	 */
	@Column(name = "PRIORITY")
	private Integer priority;
	
	/**
	 * Precio final de venta
	 */
	@Column(name = "PRICE")
	private Double price;
	
	/**
	 * ISO de la moneda
	 */
	@Column(name = "CURR")
	private String curr;
}
