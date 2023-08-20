package com.shopeeClone.shopeeClone.controller.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopeeClone.shopeeClone.dto.category.CategoryDTO;
import com.shopeeClone.shopeeClone.service.CategoryService;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("add")
	public String showAddCategoryPage() {
		return "admin/category/add-category";
	}
	
	@GetMapping("search")
	public String showSearchCategoriesPage() {
		return "admin/category/search-category";
	}
	
	@GetMapping("{categoryId}")
	public String showUpdateCategoryPage(
			@PathVariable Long categoryId,
			Model model
			) {
		CategoryDTO categoryDTO = categoryService
				.getCategoryByCategoryId(categoryId);
		model.addAttribute("category", categoryDTO);
		return "admin/category/update-category";
	}
	
}
