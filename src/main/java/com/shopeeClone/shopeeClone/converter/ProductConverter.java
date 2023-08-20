package com.shopeeClone.shopeeClone.converter;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopeeClone.shopeeClone.converter.category.CategoryConverter;
import com.shopeeClone.shopeeClone.dto.product.CreateProductDTO;
import com.shopeeClone.shopeeClone.dto.product.ProductDTO;
import com.shopeeClone.shopeeClone.entity.CategoryEntity;
import com.shopeeClone.shopeeClone.entity.ImageEntity;
import com.shopeeClone.shopeeClone.entity.ProductEntity;
import com.shopeeClone.shopeeClone.entity.SuppilierEntity;
import com.shopeeClone.shopeeClone.exeption.ValidateException;
import com.shopeeClone.shopeeClone.repository.ImageRepository;
import com.shopeeClone.shopeeClone.repository.SupplierRepository;
import com.shopeeClone.shopeeClone.repository.category.CategoryRepository;

@Component
public class ProductConverter {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SupplierRepository supplierRepository; 
	
	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private SupplierConverter supplierConverter; 
	
	@Autowired
	private ImageConverter imageConverter;
	
	public ProductEntity toEntity(CreateProductDTO dto) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(dto.getName());
		productEntity.setDescription(dto.getDescription());
		productEntity.setImportPrice(dto.getImportPrice());
		productEntity.setPrice(dto.getPrice());
		productEntity.setDiscountPercent(dto.getDiscountPercent());
		
		// Category
		CategoryEntity category = categoryRepository.findById(dto.getCategoryId())
				.orElseThrow(() -> new ValidateException("Không tìm thấy danh mục"));
		
		productEntity.setCategory(category);
		
		// Supplier
		SuppilierEntity supplier = supplierRepository.findById(dto.getSupplierId())
				.orElseThrow(() -> new ValidateException("Không tìm thấy nhà cung cấp"));
		productEntity.setSupplier(supplier);
		
		// Images
		List<Long> imageIds = dto.getImageIds();
		for(Long imageId: imageIds) {
			ImageEntity imageEntity = imageRepository.findById(imageId)
				.orElseThrow(() -> new ValidateException("Không tìm thấy hình ảnh"));
			productEntity.addImage(imageEntity);
		}
		
		return productEntity;
	};
	
	 public ProductDTO toDTO(ProductEntity productEntity) {
	        if (productEntity == null) {
	            return null;
	        }

	        ProductDTO productDTO = new ProductDTO();
	        productDTO.setProductId(productEntity.getProductId());
	        productDTO.setName(productEntity.getName());
	        productDTO.setImportPrice(productEntity.getImportPrice());
	        productDTO.setPrice(productEntity.getPrice());
	        productDTO.setDiscountPercent(productEntity.getDiscountPercent());
	        productDTO.setDescription(productEntity.getDescription());

	        // Assuming you have converters for CategoryEntity and SuppilierEntity
	        productDTO.setCategory(categoryConverter.toDTO(productEntity.getCategory()));
	        productDTO.setSupplier(supplierConverter.toDTO(productEntity.getSupplier()));

	        // Assuming you have a converter for ImageEntity
	        productDTO.setImages(imageConverter.toDTO(productEntity.getImages()));
	        productDTO.setCreatedDate(productEntity.getCreatedDate());
	        productDTO.setCreateBy(productEntity.getCreateBy());
	        productDTO.setModifierDate(productEntity.getModifierDate());
	        productDTO.setModifierBy(productEntity.getModifierBy());
	        return productDTO;
	    }

}
