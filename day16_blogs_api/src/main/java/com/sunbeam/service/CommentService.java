package com.sunbeam.service;

import com.sunbeam.dto.AddCommentDTO;
import com.sunbeam.dto.ApiResponse;

public interface CommentService {

	ApiResponse addNewComment(AddCommentDTO requestDTO);
}
