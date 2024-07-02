package com.sunbeam.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="comments",
uniqueConstraints = 
@UniqueConstraint(columnNames= {"commenter_id","post_id"}))
public class Comment extends BaseEntity{
@Column(name="comment_text", length = 100)
private String commentText;

private int rating;

@ManyToOne
@JoinColumn(name="post_id",nullable = false)
@private BlogPost post;

@ManyToOne
@JoinColumn(name="comment_id",nullable = false)
private User commenter;

/**
 * @return the commentText
 */
public String getCommentText() {
	return commentText;
}

/**
 * @param commentText the commentText to set
 */
public void setCommentText(String commentText) {
	this.commentText = commentText;
}

/**
 * @return the rating
 */
public int getRating() {
	return rating;
}

/**
 * @param rating the rating to set
 */
public void setRating(int rating) {
	this.rating = rating;
}

/**
 * @return the post
 */
public BlogPost getPost() {
	return post;
}

/**
 * @param post the post to set
 */
public void setPost(BlogPost post) {
	this.post = post;
}

/**
 * @return the commenter
 */
public User getCommenter() {
	return commenter;
}

/**
 * @param commenter the commenter to set
 */
public void setCommenter(User commenter) {
	this.commenter = commenter;
}

public Comment(Long id, LocalDate createdOn, LocalDateTime updatedOn, String commentText, int rating, BlogPost post,
		User commenter) {
	super(id, createdOn, updatedOn);
	this.commentText = commentText;
	this.rating = rating;
	this.post = post;
	this.commenter = commenter;
}

public Comment(Long id, LocalDate createdOn, LocalDateTime updatedOn) {
	super(id, createdOn, updatedOn);
}
	
}
