package com.kh.springajax.dao;

import java.util.List;

import com.kh.springajax.dto.MemberDto;


//메소드 명세만 작성(책으로치면 목차)
public interface MemberDao {
	MemberDto selectOne(String memberId);
	MemberDto selectNick(String memberNick);
}




