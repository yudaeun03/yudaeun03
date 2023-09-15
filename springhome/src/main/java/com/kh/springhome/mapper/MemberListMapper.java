package com.kh.springhome.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.springhome.dto.MemberDto;
import com.kh.springhome.dto.MemberListDto;

@Component
public class MemberListMapper implements RowMapper<MemberListDto>{

	@Override
	public MemberListDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberListDto memberListDto = new MemberListDto();
		memberListDto.setMemberId(rs.getString("member_id"));
		memberListDto.setMemberPw(rs.getString("member_pw"));
		memberListDto.setMemberNickname(rs.getString("member_nickname"));
		memberListDto.setMemberEmail(rs.getString("member_email"));
		memberListDto.setMemberContact(rs.getString("member_contact"));
		memberListDto.setMemberBirth(rs.getString("member_birth"));
		memberListDto.setMemberPost(rs.getString("member_post"));
		memberListDto.setMemberAddr1(rs.getString("member_addr1"));
		memberListDto.setMemberAddr2(rs.getString("member_addr2"));
		memberListDto.setMemberLevel(rs.getString("member_level"));
		memberListDto.setMemberPoint(rs.getInt("member_point"));
		memberListDto.setMemberJoin(rs.getDate("member_join"));
		memberListDto.setMemberLogin(rs.getDate("member_login"));
		memberListDto.setMemberChange(rs.getDate("member_change"));
		memberListDto.setBlock(rs.getString("block"));
		return memberListDto;
	}
	
}





