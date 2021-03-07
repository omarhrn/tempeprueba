package com.omarhrn.TempePrueba;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Clase de pruebas del controlador REST PreciosApiRest
 * @author omarhrn
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class PreciosApiRestTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void findAll() throws Exception{
		mvc.perform(get("/precios/findAll"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].price",is(Double.parseDouble("35.50"))));
	}
	

	@Test
	/**
	 * Test para evaluar el siguiente caso:
	 * 		Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	 *		Resultado del precio esperado 35.50
	 *
	 *	Petición a lanzar:
	 *		http://localhost:8080/precios/consultaPrecio?productId=35455&brandId=1&applicationDate=2020-06-14-10.00.00
	 */
	public void consultaPrecio_test1() throws NumberFormatException, Exception {
		mvc.perform(get("/precios/consultaPrecio?productId=35455&brandId=1&applicationDate=2020-06-14-10.00.00"))
		.andExpect(status().isOk())
		.andExpect(content().json("{'productId':35455,'brandId':1,'priceList':1,'startDate':'2020-06-13T22:00:00.000+00:00','endDate':'2020-12-31T22:59:59.000+00:00','price':35.5,'curr':'EUR'}"));
	}
	
	@Test
	/**
	 * Test para evaluar el siguiente caso:
	 * 		Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 *		Resultado del precio esperado 25.45
	 *
	 *	Petición a lanzar:
	 *		http://localhost:8080/precios/consultaPrecio?productId=35455&brandId=1&applicationDate=2020-06-14-16.00.00
	 */
	public void consultaPrecio_test2() throws NumberFormatException, Exception {
		mvc.perform(get("/precios/consultaPrecio?productId=35455&brandId=1&applicationDate=2020-06-14-16.00.00"))
		.andExpect(status().isOk())
		.andExpect(content().json("{'productId':35455,'brandId':1,'priceList':2,'startDate':'2020-06-14T13:00:00.000+00:00','endDate':'2020-06-14T16:30:00.000+00:00','price':25.45,'curr':'EUR'}"));
	}
	
	@Test
	/**
	 * Test para evaluar el siguiente caso:
	 * 		Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 *		Resultado del precio esperado 35.50
	 *
	 *	Petición a lanzar:
	 *		http://localhost:8080/precios/consultaPrecio?productId=35455&brandId=1&applicationDate=2020-06-14-21.00.00
	 */
	public void consultaPrecio_test3() throws NumberFormatException, Exception {
		mvc.perform(get("/precios/consultaPrecio?productId=35455&brandId=1&applicationDate=2020-06-14-21.00.00"))
		.andExpect(status().isOk())
		.andExpect(content().json("{'productId':35455,'brandId':1,'priceList':1,'startDate':'2020-06-13T22:00:00.000+00:00','endDate':'2020-12-31T22:59:59.000+00:00','price':35.5,'curr':'EUR'}"));
	}
	
	@Test
	/**
	 * Test para evaluar el siguiente caso:
	 * 		Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
	 *		Resultado del precio esperado 30.50
	 *
	 *	Petición a lanzar:
	 *		http://localhost:8080/precios/consultaPrecio?productId=35455&brandId=1&applicationDate=2020-06-15-10.00.00
	 */
	public void consultaPrecio_test4() throws NumberFormatException, Exception {
		mvc.perform(get("/precios/consultaPrecio?productId=35455&brandId=1&applicationDate=2020-06-15-10.00.00"))
		.andExpect(status().isOk())
		.andExpect(content().json("{'productId':35455,'brandId':1,'priceList':3,'startDate':'2020-06-14T22:00:00.000+00:00','endDate':'2020-06-15T09:00:00.000+00:00','price':30.5,'curr':'EUR'}"));
	}
	
	
	@Test
	/**
	 * Test para evaluar el siguiente caso:
	 * 		Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
	 *		Resultado del precio esperado 38.95
	 *
	 *	Petición a lanzar:
	 *		http://localhost:8080/precios/consultaPrecio?productId=35455&brandId=1&applicationDate=2020-06-16-21.00.00
	 */
	public void consultaPrecio_test5() throws NumberFormatException, Exception {
		mvc.perform(get("/precios/consultaPrecio?productId=35455&brandId=1&applicationDate=2020-06-16-21.00.00"))
		.andExpect(status().isOk())
		.andExpect(content().json("{'productId':35455,'brandId':1,'priceList':4,'startDate':'2020-06-15T14:00:00.000+00:00','endDate':'2020-12-31T22:59:59.000+00:00','price':38.95,'curr':'EUR'}"));
	}
}
