package com.kh.springajax.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springajax.dto.MemberDto;
import com.kh.springajax.mapper.MemberMapper;



@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MemberMapper memberMapper;


	@Override
	public MemberDto selectOne(String memberId) {
		String sql = "select * from member where member_id = ?";
		Object[] data = {memberId};
		List<MemberDto> list = jdbcTemplate.query(sql, memberMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}


	@Override
	public MemberDto selectNick(String memberNickname) {
		String sql = "select * from member where member_nickname = ?";
		Object[] data = {memberNickname};
		List<MemberDto> list = jdbcTemplate.query(sql, memberMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
 
	}


	

