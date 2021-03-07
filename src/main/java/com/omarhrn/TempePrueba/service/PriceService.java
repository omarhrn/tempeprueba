package com.omarhrn.TempePrueba.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omarhrn.TempePrueba.dao.IPriceDao;
import com.omarhrn.TempePrueba.dto.PriceResultDto;
import com.omarhrn.TempePrueba.exceptions.CustomErrorException;
import com.omarhrn.TempePrueba.model.Price;

/**
 * Servicio PriceService
 * @author omarhrn
 *
 */
@Service
public class PriceService implements IPriceService{
	
	private final String EL_PARAMETRO = "El parámetro ";
	private final String NO_VACIO = " no puede ser vacío";
	
	private ModelMapper mapper = new ModelMapper();
	
	@Autowired
	IPriceDao priceDao;
	
	@Override
	public List<Price> findAll(){
		return priceDao.findAll();
	}
	
	@Override
	public PriceResultDto consultarPrecio(Long productId, Integer brandId, Date applicationDate) throws CustomErrorException {
		if(productId == null) {
			throw new CustomErrorException(EL_PARAMETRO.concat("productId").concat(NO_VACIO));
		}
		if(brandId == null) {
			throw new CustomErrorException(EL_PARAMETRO.concat("brandId").concat(NO_VACIO));
		}
		
		List<Price> listaPreciosOrdenados = priceDao.consultaPrecio(productId, brandId, applicationDate);
		PriceResultDto res = null;
		if (listaPreciosOrdenados.size() >= 1) {
			res = mapper.map(listaPreciosOrdenados.get(0), PriceResultDto.class );
		}
		return res;
	}

	@Override
	public Date validaFecha(String fecha) throws CustomErrorException {
		if (fecha == null) {
			throw new CustomErrorException(EL_PARAMETRO.concat("applicationDate").concat(NO_VACIO).concat("(formato yyyy-MM-dd-HH.mm.ss)"));
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
	    
		try {
			LocalDate.parse(fecha, formatter);
			Date date=df.parse(fecha);
			return date;
		} catch (Exception e) {
			throw new CustomErrorException("El parámetro applicationDate debe tener el formato yyyy-MM-dd-HH.mm.ss)");
		}
	}
}
