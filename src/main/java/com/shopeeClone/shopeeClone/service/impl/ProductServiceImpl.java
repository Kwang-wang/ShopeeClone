package com.shopeeClone.shopeeClone.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopeeClone.shopeeClone.converter.ProductConverter;
import com.shopeeClone.shopeeClone.dto.product.CreateProductDTO;
import com.shopeeClone.shopeeClone.dto.product.ProductDTO;
import com.shopeeClone.shopeeClone.entity.ProductEntity;
import com.shopeeClone.shopeeClone.repository.ProductRepository;
import com.shopeeClone.shopeeClone.service.ProductService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ProductDTO createProduct(CreateProductDTO createProductDto) {
		ProductEntity productEntity = productConverter.toEntity(createProductDto);
		productRepository.save(productEntity);
		return productConverter.toDTO(productEntity);
	}

	@Override
	public ProductDTO getProductById(Long productId) {
		return null;
	}

	@Override
	public List<ProductDTO> getProductList(Map<String, String> params) {
		return null;
	}

}
