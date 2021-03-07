package com.omarhrn.TempePrueba.service;

import java.util.Date;
import java.util.List;

import com.omarhrn.TempePrueba.dto.PriceResultDto;
import com.omarhrn.TempePrueba.exceptions.CustomErrorException;
import com.omarhrn.TempePrueba.model.Price;

/**
 * Servicio de precios
 * @author omar
 *
 */
public interface IPriceService {
	
	/**
	 * Recupera el precio según los parámetros aplicados.
	 * 
	 * @param productId Identificador del producto
	 * @param brandId	Identificador de la cadena
	 * @param applicationDate	Fecha de aplicación
	 * @return Devuelve un objeto ProceResultDto
	 * @throws CustomErrorException 
	 */
	public PriceResultDto consultarPrecio(Long productId, Integer brandId, Date applicationDate) throws CustomErrorException;
	
	/**
	 * Función que retorna toda la tabla Prices
	 * @return Lista de objetos Price
	 */
	public List<Price> findAll();
	
	/**
	 * Función encargada de validar el formato de la fecha introducida
	 * @param fecha
	 * @return Objeto Date construido
	 * @throws CustomErrorException 
	 */
	public Date validaFecha(String fecha) throws CustomErrorException;
}
