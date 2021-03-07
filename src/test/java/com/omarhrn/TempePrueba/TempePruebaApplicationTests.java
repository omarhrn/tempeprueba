package com.omarhrn.TempePrueba;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.omarhrn.TempePrueba.dto.PriceResultDto;
import com.omarhrn.TempePrueba.exceptions.CustomErrorException;
import com.omarhrn.TempePrueba.model.Price;
import com.omarhrn.TempePrueba.service.IPriceService;


/**
 * Clase de pruebas para los servicios disponibles en la aplicación.
 * En esta aplicación existe el servicio:
 * 		PriceService : Servicio para recuperar el precio de un producto con una tarifa aplicada
 * @author omarhrn
 *
 */

@SpringBootTest
class TempePruebaApplicationTests {

	@Autowired
	private IPriceService priceService;
	
	/**
	 * Teniendo en cuenta los cuatro registros proporcionados en la prueba técnica
	 * se comprueba que el priceList 1 (id) tiene un valor de "35.50"
	 */
	@Test
	public void testFindAll_comprobarPrimerPrecio() {
		List<Price> listaPrecios = priceService.findAll();
		
		assertEquals(Integer.parseInt("1"), listaPrecios.get(0).getPriceList());
		assertEquals(Double.parseDouble("35.50"), listaPrecios.get(0).getPrice());
	}
	
	/**
	 * Teniendo en cuenta los cuatro registros proporcionados en la prueba técnica
	 * se comprueba que el priceList 2 (id) tiene un valor de "25.45"
	 */
	@Test
	public void testFindAll_comprobarSegundoPrecio() {
		List<Price> listaPrecios = priceService.findAll();
		
		assertEquals(Integer.parseInt("2"), listaPrecios.get(1).getPriceList());
		assertEquals(Double.parseDouble("25.45"), listaPrecios.get(1).getPrice());
	}
	
	/**
	 * Teniendo en cuenta los cuatro registros proporcionados en la prueba técnica
	 * se comprueba que el priceList 3 (id) tiene un valor de "30.50"
	 */
	@Test
	public void testFindAll_comprobarTercerPrecio() {
		List<Price> listaPrecios = priceService.findAll();
		
		assertEquals(Integer.parseInt("3"), listaPrecios.get(2).getPriceList());
		assertEquals(Double.parseDouble("30.50"), listaPrecios.get(2).getPrice());
	}
	
	/**
	 * Teniendo en cuenta los cuatro registros proporcionados en la prueba técnica
	 * se comprueba que el priceList 4 (id) tiene un valor de "38.95"
	 */
	@Test
	public void testFindAll_comprobarCuartoPrecio() {
		List<Price> listaPrecios = priceService.findAll();
		
		assertEquals(Integer.parseInt("4"), listaPrecios.get(3).getPriceList());
		assertEquals(Double.parseDouble("38.95"), listaPrecios.get(3).getPrice());
	}

	/**
	 * Comprobación las fechas son iguales
	 */
	@Test
	public void testValidaFecha_test1() {
		try {
			Date fecha = priceService.validaFecha("2020-06-14-10.00.00");
			Date fechaEsperada = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").parse("2020-06-14-10.00.00");
			
			assertEquals(fechaEsperada, fecha);
			
		} catch (CustomErrorException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Comprobación las fechas son distintas
	 */
	@Test
	public void testValidaFecha_test2() {
		try {
			Date fecha = priceService.validaFecha("2020-06-14-10.00.00");
			Date fechaEsperadaDistinta = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").parse("2021-12-19-10.00.00");
			
			assertNotEquals(fechaEsperadaDistinta, fecha);
			
		} catch (CustomErrorException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Recuperará un objeto PriceResultDto del servicio priceService.consultaPrecio
	 * y lo comparará con el objeto esperado
	 * @throws CustomErrorException 
	 * @throws NumberFormatException 
	 */
	@Test
	public void testConsultaPrecio_test1() throws NumberFormatException, CustomErrorException {
		PriceResultDto resultadoEsperado = 
				new PriceResultDto(Long.parseLong("35455"),Integer.parseInt("1"),Integer.parseInt("1"),priceService.validaFecha("2020-06-14-00.00.00"),priceService.validaFecha("2020-12-31-23.59.59"),Double.parseDouble("35.50"),"EUR");
		
		PriceResultDto resultado = priceService.consultarPrecio(Long.parseLong("35455"),Integer.parseInt("1"), priceService.validaFecha("2020-06-14-10.00.00"));
		
		assertEquals(resultadoEsperado, resultado);
	}
}
