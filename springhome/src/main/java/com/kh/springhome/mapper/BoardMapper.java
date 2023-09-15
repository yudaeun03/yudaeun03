package com.kh.springhome.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.springhome.dto.BoardDto;

@Component
public class BoardMapper implements RowMapper<BoardDto>{
	@Override
	public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardNo(rs.getInt("board_no"));
		boardDto.setBoardTitle(rs.getString("board_title"));
		boardDto.setBoardWriter(rs.getString("board_writer"));
		boardDto.setBoardContent(rs.getString("board_content"));
		boardDto.setBoardReadcount(rs.getInt("board_readcount"));
		boardDto.setBoardReplycount(rs.getInt("board_replycount"));
		boardDto.setBoardLikecount(rs.getInt("board_likecount"));
		boardDto.setBoardCtime(rs.getDate("board_ctime"));
		boardDto.setBoardUtime(rs.getDate("board_utime"));
		
		boardDto.setBoardGroup(rs.getInt("board_group"));
		boardDto.setBoardDepth(rs.getInt("board_depth"));
		//[1] int로 그대로 꺼낸다(null이 0으로 바뀌어 조회됨)
		//boardDto.setBoardParent(rs.getInt("board_parent"));
		//[2] Integer 형태로 꺼낸다(null이 그대로 조회됨)
		boardDto.setBoardParent(rs.getObject("board_parent", Integer.class));
		return boardDto;
	}
}








