package com.sunbeam.service;

import java.util.List;

import com.sunbeam.entities.BlogPost;

public interface BlogPostService {

	////add a method to list post ny category
	
	List<BlogPost> getPostsByCategoryName(String catName);
}
