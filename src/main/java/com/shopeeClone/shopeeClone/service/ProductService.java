package com.shopeeClone.shopeeClone.service;

import java.util.List;
import java.util.Map;

import com.shopeeClone.shopeeClone.dto.product.CreateProductDTO;
import com.shopeeClone.shopeeClone.dto.product.ProductDTO;

public interface ProductService {

	ProductDTO createProduct(CreateProductDTO createProductDto);
	
	ProductDTO getProductById(Long productId);
	
	List<ProductDTO> getProductList(Map<String, String> params);
	
}
