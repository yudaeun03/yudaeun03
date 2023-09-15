package com.kh.springhome.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.springhome.dto.PocketmonDto;

@Component//컨트롤러도 아니고 리파지토리도 아닌 애매한놈들
public class PocketmonMapper implements RowMapper<PocketmonDto>{

	@Override
	public PocketmonDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		PocketmonDto dto = new PocketmonDto();
		dto.setNo(rs.getInt("no"));
		dto.setName(rs.getString("name"));
		dto.setType(rs.getString("type"));
		// dto.setImage(rs.getInt("attach_no") > 0); // int일 때는 0이냐 아니냐로 구분
		dto.setImage(rs.getObject("attach_no")!= null);
		return dto;
	}

}