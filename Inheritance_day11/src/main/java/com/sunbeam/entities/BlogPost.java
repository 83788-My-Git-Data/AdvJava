package com.sunbeam.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Posts")
public class BlogPost extends BaseEntity {
	
	@Column(length = 30, unique = true)
	private String title;
	private String description;
	private String content;

	@ManyToOne
	@JoinColumn(name = "category_id" ,nullable = false)
	private Category selectCategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id",nullable = false)
	private User blogger;

	public BlogPost(Long id, LocalDate createdOn, LocalDateTime updatedOn, String title, String description,
			String content, Category selectCategory, User blogger) {
		super(id, createdOn, updatedOn);
		this.title = title;
		this.description = description;
		this.content = content;
		this.selectCategory = selectCategory;
		this.blogger = blogger;
	}

	public BlogPost(Long id, LocalDate createdOn, LocalDateTime updatedOn) {
		super(id, createdOn, updatedOn);
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the selectCategory
	 */
	public Category getSelectCategory() {
		return selectCategory;
	}

	/**
	 * @param selectCategory the selectCategory to set
	 */
	public void setSelectCategory(Category selectCategory) {
		this.selectCategory = selectCategory;
	}

	/**
	 * @return the blogger
	 */
	public User getBlogger() {
		return blogger;
	}

	/**
	 * @param blogger the blogger to set
	 */
	public void setBlogger(User blogger) {
		this.blogger = blogger;
	}
	
	
}
