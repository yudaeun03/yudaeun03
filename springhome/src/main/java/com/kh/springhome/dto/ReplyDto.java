package com.kh.springhome.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyDto {
	private int replyNo;
	private String replyWriter;
	private String replyContent;
	private Date replyTime;
	private int replyOrigin;
}