package com.spring.restcontroller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Product;
import com.spring.services.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/products")
public class ProductRestController {

	@Autowired
	private ProductService service;

	
	@RequestMapping(value="/lastId",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Long getLastIdOfProducts() throws FileNotFoundException, IOException {
		return service.getProductIds();
	}

	@RequestMapping(value="/{productId}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Product getProductById(@PathVariable("productId") Long productId) {
		return service.getProductById(productId);
	}
	
	@RequestMapping(value="/ids/{startIndex}/{lastIndex}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<Product> getProductByRangeOfIndexes(@PathVariable("startIndex") Long startIndex, @PathVariable("lastIndex") Long lastIndex) {
		return service.getProductByIdsRange(startIndex, lastIndex);
	}
	
	@RequestMapping(value="/page/{page}/{size}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<Product> getProductByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		return service.getProductByPage(page-1, size);
	}
	
	@RequestMapping(value = "/set", 
			method = RequestMethod.POST,
			produces = {MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE})
	
	public String setProduct(@RequestBody Product product) throws FileNotFoundException, IOException {
		return service.addProduct(product);
	}
	
	@RequestMapping(value = "/api/product/update")
	
	public String updateProductById(@RequestBody Product product) {		
		return service.updateProduct(product);
	}
	
//    @RequestMapping(value = "/api/product/update")
//	
//	public String delete(@PathVariable Long id) {		
//		return service.deleteById(id);
//	}
	
	
}
