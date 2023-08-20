package com.shopeeClone.shopeeClone.converter.category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.shopeeClone.shopeeClone.dto.category.CategoryDTO;
import com.shopeeClone.shopeeClone.entity.CategoryEntity;

@Component
public class CategoryConverter {

	public CategoryDTO toDTO(CategoryEntity categoryEntity) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryId(categoryEntity.getCategoryId());
		categoryDTO.setName(categoryEntity.getName());
		categoryDTO.setDescription(categoryEntity.getDescription());
		
		categoryDTO.setCreatedDate(categoryEntity.getCreatedDate());
		categoryDTO.setCreateBy(categoryEntity.getCreateBy());
		
		categoryDTO.setModifierDate(categoryEntity.getModifierDate());
		categoryDTO.setModifierBy(categoryEntity.getModifierBy());
		
		return categoryDTO;
	}

	public CategoryEntity toEntity(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setName(categoryDTO.getName());
		categoryEntity.setDescription(categoryDTO.getDescription());
		return categoryEntity;
	}

	public CategoryEntity toEntity(CategoryEntity categoryEntity, CategoryDTO categoryDTO) {
		categoryEntity.setName(categoryDTO.getName());
		categoryEntity.setDescription(categoryDTO.getDescription());
		return categoryEntity;
	}

	public List<CategoryDTO> toDTOList(List<CategoryEntity> categoryEntities) {
		List<CategoryDTO> categoryDTOList = new ArrayList<>();
		for (CategoryEntity categoryEntity : categoryEntities) {
			categoryDTOList.add(toDTO(categoryEntity));
		}
		return categoryDTOList;
	}

	public List<CategoryEntity> toEntityList(List<CategoryDTO> categoryDTOList) {
		List<CategoryEntity> categoryEntities = new ArrayList<>();
		for (CategoryDTO categoryDTO : categoryDTOList) {
			categoryEntities.add(toEntity(categoryDTO));
		}
		return categoryEntities;
	}

}
