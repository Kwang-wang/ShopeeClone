package com.shopeeClone.shopeeClone.service;	

import java.util.Map;

import com.shopeeClone.shopeeClone.dto.PageDTO;
import com.shopeeClone.shopeeClone.dto.category.CategoryDTO;

public interface CategoryService {
	
	CategoryDTO createCategory(CategoryDTO dto);
	
	// localhost:8080?name=Minh&age=18
	PageDTO<CategoryDTO> getCategories(Map<String, String> params);
	
	CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO);
	
	void deleteCategory(Long categoryId);

	CategoryDTO getCategoryByCategoryId(Long categoryId);

}
