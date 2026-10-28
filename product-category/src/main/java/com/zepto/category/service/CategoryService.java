package com.zepto.category.service;

import java.net.CacheRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.category.entity.CategoryEntity;
import com.zepto.category.repository.CategoryRepository;
import com.zepto.category.request.CategoryRequest;
import com.zepto.category.response.CategoryResponse;
import com.zepto.product.entity.ProductEntity;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	public void showAllCategories() {
		
		
	System.out.println("CategoryService.showAllCategories()................START");
	
	
	//Iterable<CategoryEntity> categories = categoryRepository.findAll(); //causes N+1 problem
	
	List<CategoryEntity> categories = categoryRepository.getAllCategories();
	
	//List<CategoryEntity> categories = categoryRepository.findAll(); //use findAll when using EntityGraph and need to override in repository
	
	
	
	for(CategoryEntity categoryEntity: categories)
	{
		System.out.println(categoryEntity.getName());
		System.out.println(categoryEntity.getId());
		
		List <ProductEntity> products =  categoryEntity.getProducts();
		
		System.out.println("Total Products are: "+products.size());
	}
	
	System.out.println("CategoryService.showAllCategories()................END");
	}
	
	
	
	public CategoryResponse createCategory(CategoryRequest categoryRequest) {
		
		CategoryEntity categoryEntity = new CategoryEntity();
		
		categoryEntity.setName(categoryRequest.getName());
		categoryEntity.setDescription(categoryRequest.getDescription());
		categoryEntity.setStatus("Active");
		
        CategoryEntity responseEntity = categoryRepository.save(categoryEntity);
		
		
		CategoryResponse categoryResponse = new CategoryResponse();
		
		categoryResponse.setId(responseEntity.getId());
		categoryResponse.setDescription(responseEntity.getDescription());
		categoryResponse.setName(responseEntity.getName());
		categoryResponse.setStatus(responseEntity.getStatus());
		
		
		return categoryResponse;
	}
	
	public CategoryResponse getCategoryById(Long id) {

		CategoryEntity categoryEntity = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

		CategoryResponse response = new CategoryResponse();
		response.setId(categoryEntity.getId());
		response.setName(categoryEntity.getName());
		response.setDescription(categoryEntity.getDescription());
		response.setStatus(categoryEntity.getStatus());

		return response;
	}

}
