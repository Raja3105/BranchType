package com.tech.endpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.endpro.controller.EndProduct;
import com.tech.endpro.dao.EndProductDao;

@Service
public class EndProductService {
	@Autowired
	EndProductDao as;
	
	public String setProduct(List<EndProduct>x) {
		return as.setProduct(x);
	

}
}
