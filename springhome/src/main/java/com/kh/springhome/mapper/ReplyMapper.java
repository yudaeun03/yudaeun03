package com.kh.springhome.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.springhome.dto.ReplyDto;

@Component
public class ReplyMapper implements RowMapper<ReplyDto>{
	@Override
	public ReplyDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReplyDto replyDto = new ReplyDto();
		replyDto.setReplyNo(rs.getInt("reply_no"));
		replyDto.setReplyWriter(rs.getString("reply_writer"));
		replyDto.setReplyContent(rs.getString("reply_content"));
		replyDto.setReplyTime(rs.getDate("reply_time"));
		replyDto.setReplyOrigin(rs.getInt("reply_origin"));
		return replyDto;
	}
}