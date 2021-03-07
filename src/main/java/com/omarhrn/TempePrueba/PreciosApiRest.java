package com.omarhrn.TempePrueba;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omarhrn.TempePrueba.dto.ErrorDto;
import com.omarhrn.TempePrueba.dto.PriceResultDto;
import com.omarhrn.TempePrueba.exceptions.CustomErrorException;
import com.omarhrn.TempePrueba.model.Price;
import com.omarhrn.TempePrueba.service.IPriceService;

/**
 * 
 * @author omarhrn
 *
 */

@RestController
@RequestMapping(value = "precios")
public class PreciosApiRest {
	
	@Autowired
	private IPriceService priceService;
	
	@GetMapping(value = "findAll")
	public List<Price> findAll(){
		return priceService.findAll();
	}
	
	/**
	 * Petición para recuperar dentro de un objeto el precio aplicado a un producto
	 * segun los parámetros introducidos
	 * 
	 * @param productId		
	 * @param brandId
	 * @param applicationDate Se marca como required a false para poder controlar de
	 *                        forma sencilla un mensaje en pantalla indicando el
	 *                        formato
	 * @return
	 */
	@GetMapping(value = "consultaPrecio")
	public ResponseEntity<?> consultaPrecio(@RequestParam(required = false) Long productId, @RequestParam(required = false) Integer brandId,
			@RequestParam(required = false) String applicationDate) {
		
		PriceResultDto res 	= null;
		ErrorDto error		= null;
		try {
			
			Date fecha = priceService.validaFecha(applicationDate);
			res = priceService.consultarPrecio(productId, brandId, fecha);
		
		}catch (CustomErrorException e1) {
			error = new ErrorDto();
			error.setStatus(HttpStatus.BAD_REQUEST);
			error.setMessage(e1.getMessage());
			return new ResponseEntity<ErrorDto>(error,HttpStatus.BAD_REQUEST);
		
		}catch (Exception e) {
			error = new ErrorDto();
			error.setStatus(HttpStatus.BAD_REQUEST);
			error.setMessage(e.getMessage()); 
			return new ResponseEntity<ErrorDto>(error,HttpStatus.BAD_REQUEST);
		}
		
		if(res == null) {
			error = new ErrorDto();
			error.setStatus(HttpStatus.NOT_FOUND);
			error.setMessage("No se han encontrado resultados");
			return new ResponseEntity<ErrorDto>(error,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<PriceResultDto>(res,HttpStatus.OK);
	}
}
