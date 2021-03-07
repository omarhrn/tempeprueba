package com.omarhrn.TempePrueba.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.omarhrn.TempePrueba.model.Price;

/**
 * Repositorio JPA para la entidad {@link Price}
 * @author omarhrn
 *
 */
public interface IPriceDao extends JpaRepository<Price, Integer>{
	
	/**
	 * Usando la anotación Query realizamos una búsqueda de un listado
	 * de precios según los parámetros. Este resultado está ordenado DESCENDENTEMENTE por el campo PRIORITY.
	 * El primer registro será el de mayor prioridad.
	 * 
	 * @param productId
	 * @param brandId
	 * @param applicationDate
	 * @return
	 */
	@Query("SELECT p "
			+ "FROM Price p "
			+ "WHERE p.productId = :productId "
			+ "AND p.brandId = :brandId "
			+ "AND :applicationDate BETWEEN p.startDate AND p.endDate "
			+ "ORDER BY p.priority DESC")
	public List<Price> consultaPrecio(@Param("productId") Long productId, @Param("brandId") Integer brandId,
			@Param("applicationDate") Date applicationDate);
}
