package com.omarhrn.TempePrueba.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Objeto de retorno como resultado a la petición consultaPrecio
 * @author omar
 *
 */
@Data
public class PriceResultDto implements Serializable {
	
	private static final long serialVersionUID = -304503186963383129L;
	
	/**
	 * Identificador código del producto
	 */
	private Long productId;
		
	/**
	 * Identificador de la cadena del grupo
	 */
	private Integer brandId;
	
	/**
	 * Identificador de la tarifa de precios aplicable
	 */
	private Integer priceList;

	/**
	 * Inicio de rango de fechas en el que aplica el precio tarifa indicado
	 */
	private Date startDate;
	
	/**
	 * Fin de rango de fechas en el que aplica el precio tarifa indicado
	 */
	private Date endDate;
	
	/**
	 * Precio final de venta
	 */
	private Double price;
	
	/**
	 * ISO de la moneda
	 */
	private String curr;

	public PriceResultDto(Long productId, Integer brandId, Integer priceList, Date startDate, Date endDate,
			Double price, String curr) {
		super();
		this.productId = productId;
		this.brandId = brandId;
		this.priceList = priceList;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.curr = curr;
	}

	public PriceResultDto() {
		super();
	}
	
}
