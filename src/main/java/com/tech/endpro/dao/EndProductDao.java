package com.tech.endpro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.endpro.controller.EndProduct;
import com.tech.endpro.repository.EndProductRepository;
@Repository
public class EndProductDao {
	@Autowired
	EndProductRepository al;
	public String setProduct(List<EndProduct>x) {
		  al.saveAll(x);
		return "SUCCESSFULLY ADDED";

}
}
