package com.kh.springhome.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardMentionListDto {
	private int boardNo;
	private String boardWriter, boardTitle, boardContent;
	private int boardReadcount, boardLikecount, boardReplycount;
	private Date boardCtime, boardUtime;
	private int boardGroup;
	private Integer boardParent;
	private int boardDepth;
	
	private int superBoardNo;
	private String superBoardTitle;
}