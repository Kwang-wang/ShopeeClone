package com.shopeeClone.shopeeClone.dto.product;

import java.util.ArrayList;
import java.util.List;

public class CreateProductDTO {
	private Long productId;
	private String name;
	private Double importPrice;
	private Double price;
	private Integer discountPercent;
	private String description;
	private Long categoryId;
	private Long supplierId;
	private List<Long> imageIds = new ArrayList<>();
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getImportPrice() {
		return importPrice;
	}
	public void setImportPrice(Double importPrice) {
		this.importPrice = importPrice;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public List<Long> getImageIds() {
		return imageIds;
	}
	public void setImageIds(List<Long> imageIds) {
		this.imageIds = imageIds;
	}
	
}
