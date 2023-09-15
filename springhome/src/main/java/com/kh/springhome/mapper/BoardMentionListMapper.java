package com.kh.springhome.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.springhome.dto.BoardDto;
import com.kh.springhome.dto.BoardMentionListDto;

@Component
public class BoardMentionListMapper implements RowMapper<BoardMentionListDto>{
	@Override
	public BoardMentionListDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardMentionListDto boardMentionListDto = new BoardMentionListDto();
		boardMentionListDto.setBoardNo(rs.getInt("board_no"));
		boardMentionListDto.setBoardTitle(rs.getString("board_title"));
		boardMentionListDto.setBoardWriter(rs.getString("board_writer"));
		boardMentionListDto.setBoardContent(rs.getString("board_content"));
		boardMentionListDto.setBoardReadcount(rs.getInt("board_readcount"));
		boardMentionListDto.setBoardReplycount(rs.getInt("board_replycount"));
		boardMentionListDto.setBoardLikecount(rs.getInt("board_likecount"));
		boardMentionListDto.setBoardCtime(rs.getDate("board_ctime"));
		boardMentionListDto.setBoardUtime(rs.getDate("board_utime"));
		
		boardMentionListDto.setBoardGroup(rs.getInt("board_group"));
		boardMentionListDto.setBoardDepth(rs.getInt("board_depth"));
		boardMentionListDto.setBoardParent(rs.getObject("board_parent", Integer.class));
		
		boardMentionListDto.setSuperBoardNo(rs.getInt("super_board_no"));
		boardMentionListDto.setSuperBoardTitle(rs.getString("super_board_title"));
		return boardMentionListDto;
	}
}