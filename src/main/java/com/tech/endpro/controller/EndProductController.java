package com.tech.endpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tech.endpro.service.EndProductService;

@RestController
public class EndProductController {
	@Autowired
	RestTemplate rt;
	
	@Autowired
	EndProductService rs;
	
	
	@GetMapping ("/getEndProgram")
	public List<EndProduct> getProduct(){
		String u2="http://localhost:8081/get/";//GST PROJECT
		String u1="http://localhost:8080/getProductAll"; ///PRODUCTS PROJECT
		ResponseEntity<List<EndProduct>>res1=rt.exchange(u1,HttpMethod.GET,null,new ParameterizedTypeReference<List<EndProduct>>(){});
		List<EndProduct>ep=res1.getBody();
		ep.forEach(x->{
			 int hsn=x.getHsn();
			 ResponseEntity<Integer>res2=rt.exchange(u2+hsn,HttpMethod.GET,null,Integer.class);
			 int tax=res2.getBody();
			 x.setPrice(x.getPrice()+(x.getPrice()*tax/100));
		});
		return ep;
	}
	@PostMapping(value="/table")
	public String setProduct() {
		List<EndProduct>x=getProduct();
		return rs.setProduct(x);
			}
	}
