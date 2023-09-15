package com.kh.springhome.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.dto.BoardDto;
import com.kh.springhome.dto.BoardListDto;
import com.kh.springhome.dto.BoardMentionListDto;
import com.kh.springhome.mapper.BoardListMapper;
import com.kh.springhome.mapper.BoardMapper;
import com.kh.springhome.mapper.BoardMentionListMapper;
import com.kh.springhome.vo.PaginationVO;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private BoardListMapper boardListMapper;

	@Override
	public int sequence() {
		String sql = "select board_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}

	@Override
	public void insert(BoardDto boardDto) {
		String sql = "insert into board("
						+ "board_no, board_title, board_content, board_writer, "
						+ "board_group, board_parent, board_depth"
					+ ") values(?, ?, ?, ?, ?, ?, ?)";
		Object[] data = {
				boardDto.getBoardNo(), boardDto.getBoardTitle(),
				boardDto.getBoardContent(), boardDto.getBoardWriter(),
				boardDto.getBoardGroup(), boardDto.getBoardParent(),
				boardDto.getBoardDepth()
		};
		jdbcTemplate.update(sql, data);
	}

	@Override
	public List<BoardListDto> selectList() {
		//기존 조회 구문
		//String sql = "select * from board_list order by board_no desc";
		
		//계층형 조회 구문
		String sql = "select * from board_list "
						+ "connect by prior board_no=board_parent "
						+ "start with board_parent is null "
						+ "order siblings by board_group desc, board_no asc";
		return jdbcTemplate.query(sql, boardListMapper);
	}

	@Override
	public BoardDto selectOne(int boardNo) {
		String sql = "select * from board where board_no = ?";
		Object[] data = {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public boolean update(BoardDto boardDto) {
		String sql = "update board "
						+ "set "
							+ "board_title=?, "
							+ "board_content=?, "
							+ "board_utime=sysdate "
						+ "where board_no=?";
		Object[] data = {
			boardDto.getBoardTitle(), boardDto.getBoardContent(),
			boardDto.getBoardNo()
		};
		return jdbcTemplate.update(sql, data) > 0;
	}

	@Override
	public boolean delete(int boardNo) {
		String sql = "delete board where board_no = ?";
		Object[] data = {boardNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	@Override
	public boolean updateBoardReadcount(int boardNo) {
		String sql = "update board set "
						+ "board_readcount = board_readcount + 1 "
						+ "where board_no = ?";
		Object[] data = {boardNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	@Override
	public Integer selectMax(String boardWriter) {
		String sql = "select max(board_no) from board "
						+ "where board_writer = ?";
		Object[] data = {boardWriter};
		return jdbcTemplate.queryForObject(sql, Integer.class, data);
	}
	
//	@Override
//	public List<BoardDto> selectList(String type, String keyword) {
//		String sql;
//		if(type.equals("board_title")) {//type이 제목인 경우
//			sql  = "select * from board_list "
//					+ "where instr(board_title, ?) > 0 "
//					+ "order by board_no desc";
//		}
//		else {//type이 작성자인 경우
//			sql = "select * from board_list "
//					+ "where instr(board_writer, ?) > 0 "
//					+ "order by board_no desc";
//		}
//		Object[] data = {keyword};
//		return jdbcTemplate.query(sql, boardListMapper, data);
//	}
	
	@Override
	public List<BoardListDto> selectList(String type, String keyword) {
		String sql = "select * from board_list "
						+ "where instr("+type+", ?) > 0 "
						+ "connect by prior board_no=board_parent "
						+ "start with board_parent is null "
						+ "order siblings by board_group desc, board_no asc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, boardListMapper, data);
	}
	
//	@Override
//	public List<BoardDto> selectList(String type, String keyword) {
//		String sql = "select * from board_list "
//					+ "where instr(#1, ?) > 0 "
//					+ "order by board_no desc";
//		sql = sql.replace("#1", type);
//		Object[] data = {keyword};
//		return jdbcTemplate.query(sql, boardListMapper, data);
//	}
	
	@Autowired
	private BoardMentionListMapper boardMentionListMapper;
	
	@Override
	public List<BoardMentionListDto> selectMentionList() {
		String sql = "select * from board_mention_list order by board_no asc";
		return jdbcTemplate.query(sql, boardMentionListMapper);
	}
	
	//페이징 추가된 목록
	@Override
	public List<BoardListDto> selectListByPage(int page) {
		int begin = page * 10 - 9;
		int end = page * 10;
		
		String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
								+ "select * from board_list "
								+ "connect by prior board_no=board_parent "
								+ "start with board_parent is null "
								+ "order siblings by board_group desc, board_no asc"
							+ ")TMP"
						+ ") where rn between ? and ?";
		Object[] data = {begin, end};
		return jdbcTemplate.query(sql, boardListMapper, data);
	}
	
	@Override
	public List<BoardListDto> selectListByPage(String type, String keyword, int page) {
		int begin = page * 10 - 9;
		int end = page * 10;
		String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
								+"select * from board_list "
								+ "where instr("+type+", ?) > 0 "
								+ "connect by prior board_no=board_parent "
								+ "start with board_parent is null "
								+ "order siblings by board_group desc, board_no asc"
							+ ")TMP"
						+ ") where rn between ? and ?";
		Object[] data = {keyword, begin, end};
		return jdbcTemplate.query(sql, boardListMapper, data);
	}
	
	@Override
	public int countList() {
		String sql = "select count(*) from board";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	@Override
	public int countList(String type, String keyword) {
		String sql = "select count(*) from board "
						+ "where instr("+type+", ?) > 0";
		Object[] data = {keyword};
		return jdbcTemplate.queryForObject(sql, int.class, data);
	}
	
	@Override
	public int countList(PaginationVO vo) {
		if(vo.isSearch()) {
			String sql = "select count(*) from board "
					+ "where instr("+vo.getType()+", ?) > 0";
			Object[] data = {vo.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, data);
		}
		else {
			String sql = "select count(*) from board";
			return jdbcTemplate.queryForObject(sql, int.class);
		}
	}
	
	@Override
	public List<BoardListDto> selectListByPage(PaginationVO vo) {
		if(vo.isSearch()) {
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+"select * from board_list "
									+ "where instr("+vo.getType()+", ?) > 0 "
									+ "connect by prior board_no=board_parent "
									+ "start with board_parent is null "
									+ "order siblings by board_group desc, board_no asc"
								+ ")TMP"
							+ ") where rn between ? and ?";
			Object[] data = {vo.getKeyword(), vo.getStartRow(), vo.getFinishRow()};
			return jdbcTemplate.query(sql, boardListMapper, data);
		}
		else {
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select * from board_list "
									+ "connect by prior board_no=board_parent "
									+ "start with board_parent is null "
									+ "order siblings by board_group desc, board_no asc"
								+ ")TMP"
							+ ") where rn between ? and ?";
			Object[] data = {vo.getStartRow(), vo.getFinishRow()};
			return jdbcTemplate.query(sql, boardListMapper, data);
		}
	}
	
	@Override
	public List<BoardListDto> selectListByBoardWriter(String boardWriter) {
		String sql = "select * from board_list "
						+ "where board_writer = ? "
						+ "order by board_no desc";
		Object[] data = {boardWriter};
		return jdbcTemplate.query(sql, boardListMapper, data);
	}

	@Override
	public boolean updateBoardReplycount(int boardNo) {
		String sql = "update board set board_replycount = ("
							+ "select count(*) from reply where reply_origin = ?"
						+ ") "
						+ "where board_no = ?";
		Object[] data = {boardNo, boardNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
}






