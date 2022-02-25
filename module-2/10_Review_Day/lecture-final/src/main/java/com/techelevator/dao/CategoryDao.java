package com.techelevator.dao;

import com.techelevator.model.Category;

import java.util.List;

public interface CategoryDao {

    Category getCategory(int categoryId);

    List<Category> getCategories();
}
