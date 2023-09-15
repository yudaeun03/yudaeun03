package com.kh.springhome.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.dto.ReplyDto;
import com.kh.springhome.mapper.ReplyMapper;

@Repository
public class ReplyDaoImpl implements ReplyDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public int sequence() {
		String sql = "select reply_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	@Override
	public void insert(ReplyDto replyDto) {
		String sql = "insert into reply("
							+ "reply_no, reply_writer, "
							+ "reply_content, reply_origin"
						+ ") "
						+ "values(?, ?, ?, ?)";
		Object[] data = {
			replyDto.getReplyNo(), replyDto.getReplyWriter(),
			replyDto.getReplyContent(), replyDto.getReplyOrigin()
		};
		jdbcTemplate.update(sql, data);
	}
	
	@Override
	public List<ReplyDto> selectList(int replyOrigin) {
		String sql = "select * from reply "
						+ "where reply_origin = ? "
						+ "order by reply_no asc";
		Object[] data = {replyOrigin};
		return jdbcTemplate.query(sql, replyMapper, data);
	}
	
	@Override
	public ReplyDto selectOne(int replyNo) {
		String sql = "select * from reply where reply_no = ?";
		Object[] data = {replyNo};
		List<ReplyDto> list = jdbcTemplate.query(sql, replyMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public boolean delete(int replyNo) {
		String sql = "delete reply where reply_no = ?";
		Object[] data = {replyNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	@Override
	public boolean update(ReplyDto replyDto) {
		String sql = "update reply set reply_content = ? where reply_no = ?";
		Object[] data = {replyDto.getReplyContent(), replyDto.getReplyNo()};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
}









