package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Long> {

	Optional List<Category> getAllCategory();
}
