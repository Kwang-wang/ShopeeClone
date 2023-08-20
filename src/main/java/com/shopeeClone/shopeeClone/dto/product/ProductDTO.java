package com.shopeeClone.shopeeClone.dto.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shopeeClone.shopeeClone.dto.ImageDTO;
import com.shopeeClone.shopeeClone.dto.SuppilierDTO;
import com.shopeeClone.shopeeClone.dto.category.CategoryDTO;

public class ProductDTO {
	private Long productId;
	private String name;
	private Double importPrice;
	private Double price;
	private Integer discountPercent;
	private String description;
	private CategoryDTO category;
	private SuppilierDTO supplier;
	private List<ImageDTO> images = new ArrayList<>();
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
	private Date createdDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
	private Date modifierDate;
	
	private String createBy;
	
	private String modifierBy;
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifierDate() {
		return modifierDate;
	}
	public void setModifierDate(Date modifierDate) {
		this.modifierDate = modifierDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getModifierBy() {
		return modifierBy;
	}
	public void setModifierBy(String modifierBy) {
		this.modifierBy = modifierBy;
	}
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
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	public SuppilierDTO getSupplier() {
		return supplier;
	}
	public void setSupplier(SuppilierDTO supplier) {
		this.supplier = supplier;
	}
	public List<ImageDTO> getImages() {
		return images;
	}
	public void setImages(List<ImageDTO> images) {
		this.images = images;
	}
	
	
}
