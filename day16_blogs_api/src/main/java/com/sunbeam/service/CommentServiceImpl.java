package com.sunbeam.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.CommentDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.AddCommentDTO;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CommentResponseDTO;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Comment;
import com.sunbeam.entities.User;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

	@Autowired
	private BlogPostDao blogPostDao;
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private UserDao commenterDao;
	
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CommentResponseDTO addNewComment(AddCommentDTO requestDTO) {
		// TODO Auto-generated method stub
		System.out.println("entry in comment sys");
		BlogPost blogPost=blogPostDao.findById(requestDTO.getBlogPostId())
				.orElseThrow(()->new ResourceNotFoundException("invalid blog post id...!"));
		
		User commenter =commenterDao.findById(requestDTO.getCommenterId())
				.orElseThrow(()->new ResourceNotFoundException("commenter Id is invalied...!"));
		
//		if(commenter.getId()==blogPost.getBlogger().getId())
//		{
//			throw new ApiException("blogger cant comment his own post!!!");
//		}
		
		Comment comment=mapper.map(requestDTO, Comment.class);
		System.out.println("entry in comment sys"+comment);
		
		comment.setCommenter(commenter);
		comment.setPost(blogPost);
		System.out.println("comment.setPost(blogPost)");
		
		
		Comment persistentComment=commentDao.save(comment);
		System.out.println(persistentComment);
//		return new ApiResponse("new comment added with id:"+persistentComment.getId());
	return mapper.map(persistentComment,CommentResponseDTO.class);
	}
	


}
