package com.sunbeam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dao.CommentDao;
import com.sunbeam.dto.AddCommentDTO;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CommentResponseDTO;
import com.sunbeam.service.CommentService;



@RestController
@RequestMapping("/comments")
public class CommentController {

	private CommentService commentService;
	
	public CommentController() {
		System.out.println("in ctor " + getClass());
	}
	
	@PostMapping
	public ResponseEntity<?> addComment(@RequestBody AddCommentDTO dto)
	{
		System.out.println("in add comment"+dto);
//		try {
//			System.out.println("tryblock");
//			
//			return ResponseEntity.status(HttpStatus.CREATED)
//					.body(commentService.addNewComment(dto));
//			
//		} catch (RuntimeException e) {
//			// TODO: handle exception
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//					.body(new ApiResponse(e.getMessage()));
//		}
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(commentService.addNewComment(dto));
			} catch (RuntimeException e) {
				System.out.println(e);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new ApiResponse(e.getMessage()));
			}
	}
}
