package com.kh.springhome.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.springhome.dto.BoardDto;
import com.kh.springhome.dto.BoardListDto;

@Component
public class BoardListMapper implements RowMapper<BoardListDto>{
	@Override
	public BoardListDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardListDto boardListDto = new BoardListDto();
		boardListDto.setBoardNo(rs.getInt("board_no"));
		boardListDto.setBoardTitle(rs.getString("board_title"));
		boardListDto.setBoardWriter(rs.getString("board_writer"));
		boardListDto.setBoardReadcount(rs.getInt("board_readcount"));
		boardListDto.setBoardReplycount(rs.getInt("board_replycount"));
		boardListDto.setBoardLikecount(rs.getInt("board_likecount"));
		boardListDto.setBoardCtime(rs.getDate("board_ctime"));
		boardListDto.setBoardUtime(rs.getDate("board_utime"));
		boardListDto.setMemberNickname(rs.getString("member_nickname"));
		
		boardListDto.setBoardGroup(rs.getInt("board_group"));
		boardListDto.setBoardParent(rs.getObject("board_parent", Integer.class));
		boardListDto.setBoardDepth(rs.getInt("board_depth"));
		return boardListDto;
	}
}








