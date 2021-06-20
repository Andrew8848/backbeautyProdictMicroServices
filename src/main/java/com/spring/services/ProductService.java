package com.spring.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Product;
import com.spring.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Long getProductIds() {
		return repository.count();
	}
	
	public String addProduct(Product product) {
		repository.save(product);
		return "Added product: " + product.getId() + "; " + product.getBrand() + "; " + product.getName();
	}
	
	public Product getProductById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Product> getProductByIdsRange(Long startIndex, Long lastIndex) {
		long productIndexes = repository.count();
		List<Long> ids = LongStream.rangeClosed(startIndex, lastIndex)
				.filter(f -> f > 0 && f <= productIndexes).boxed().collect(Collectors.toList());
		return repository.findAllById(ids); 
	}
	
	public List<Product> getProductByPage(int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable).stream().collect(Collectors.toList());
	}
	
	public String updateProduct(Product product) {
		Product exictingProduct = repository.findById(product.getId()).orElse(null);
		if(exictingProduct != null) {
			product.setId(exictingProduct.getId());
			repository.save(product);
			return "[Product Updated]: " + product.getId() + " from " + product.getBrand()
			                           + "; " + product.getName() + " to " 
			                           + exictingProduct.getId() + "; " 
			                           + exictingProduct.getBrand() + "; " 
			                           + exictingProduct.getName();
		}	
		return "Product Not Found by id: " +product.getId();
	}

	public String deleteById(Long id) {
		repository.deleteById(id);
		return "[Deleted by id]: " + id;
	}
	
	
}
