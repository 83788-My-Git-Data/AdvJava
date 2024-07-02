package com.sunbeam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AddCommentDTO extends BaseDTO{

	private Long commenterId;
	private Long blogPostId;
	private String comment_text;
	private int rating;
	
}
